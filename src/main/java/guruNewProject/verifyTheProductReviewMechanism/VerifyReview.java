package guruNewProject.verifyTheProductReviewMechanism;

import guruNewProject.GuruUTILS;
import guruNewProject.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


/*Verify the product review mechanism.
1. Go to http://live.guru99.com
2. Go to link http://live.guru99.com/index.php/review/product/list/id/1/
3. Fill the required review and submit it.
4. Go to http://live.guru99.com/index.php/backendlogin
5. Login with credentials provided.
6. Go to Catalogue--> Reviews and Ratings --> Customer Reviews --> Pending Reviews Menu.
7. Sort table by id and select comment then click on Edit link.
8. Change status to "Approved" and click "Save Review".
9. Go to http://live.guru99.com. Click Mobile Menu.
10.Click on Sony Xperia image.
11.In detail page click on Review tab at bottom page.
12.Verify The Review comment is shown -->Review is approved and shown.
 */

public class VerifyReview {
    WebDriver driver;
    Actions actions;
    Action action;
    WebDriverWait wait;
    MadgentoAdminPanelPage madgentoAdminPanelPage;
    Select select;
    GuruUTILS guruUTILS = new GuruUTILS();


    @BeforeClass
    public void setProPeTies(){
        //System.setProperty(GuruUTILS.instanceChromeDriver, GuruUTILS.locationWebDriverChrom);
        //driver = new ChromeDriver();
        driver = guruUTILS.setProp("Chrome");
        driver.get("http://live.guru99.com");
        wait = new WebDriverWait(driver,10);
        actions = new Actions(driver);
    }

    @Test
    public void fillReview(){
        driver.navigate().to("http://live.guru99.com/index.php/review/product/list/id/1/");
        ReviewPageSony reviewPageSony = new ReviewPageSony(driver);
        
        WebElement tEXTaREA = wait.until(ExpectedConditions.elementToBeClickable(reviewPageSony.getTestAreaThougths()));

        action = actions.moveToElement(tEXTaREA).click().sendKeys("good goods").build();
        action.perform();
        reviewPageSony.getAreaSummaryReview().sendKeys("my review");
        reviewPageSony.getAreaNickName().sendKeys("seriislon");
        reviewPageSony.getButtonReview().submit();
    }
    @Test(dataProvider = "logIn",dataProviderClass = GuruUTILS.class)
    public void logInbackendlogin(String id,String pass)  {
        driver.get(GuruUTILS.urlbackendlogin);
        GuruUTILS.logIn(id,pass,driver);
        madgentoAdminPanelPage = new MadgentoAdminPanelPage(driver);
        actions = new Actions(driver);

        action = actions.moveToElement(madgentoAdminPanelPage.getCatalogButton())
                .moveToElement(madgentoAdminPanelPage.getReviewAndSettingsButton())
                .moveToElement(madgentoAdminPanelPage.getCustamerReview())
                .moveToElement(madgentoAdminPanelPage.getPending_Reviews()).click().build();
        action.perform();

        madgentoAdminPanelPage.getFieldID().sendKeys(table());
        madgentoAdminPanelPage.getEditButton().click();

        select = new Select(madgentoAdminPanelPage.getSlectStatusReviewPage());
        select.selectByVisibleText("Approved");
        madgentoAdminPanelPage.getSaveReviewButton().click();

        driver.navigate().to("http://live.guru99.com");
        GuruMainPage guruMainPage = new GuruMainPage(driver);
        guruMainPage.getMobileButton().click();
        MobilePage mobilePage = new  MobilePage(driver);
        mobilePage.getSonyImage().click();

        SonyPage sonyPage = new SonyPage(driver);
        sonyPage.getReviewsBottomButton().click();
        String textReview = sonyPage.getTextReview().getText();
        String text_review = textReview.substring(0,20).trim();
        String verufyTextReview = "REVIEW BY SERIISLON";
        Assert.assertEquals(text_review,verufyTextReview);
    }

    @AfterClass
    public void close(){
        driver.quit();
    }



    //get data from first cell
    public String table(){
         String dataFromTable = madgentoAdminPanelPage.getTable()
                .findElement(By.xpath("//*[@id='reviwGrid_table']/tbody/tr[1]/td[2]")).getText();
        System.out.println(dataFromTable);
        return dataFromTable;
    }
}
