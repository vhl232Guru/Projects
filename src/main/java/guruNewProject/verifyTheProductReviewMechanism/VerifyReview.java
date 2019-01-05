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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class VerifyReview {
    WebDriver driver;
    Actions actions;
    Action action;
    WebDriverWait wait;
    MadgentoAdminPanelPage madgentoAdminPanelPage;
    Select select;

    @BeforeTest
    public void setProPeTies(){
        System.setProperty(GuruUTILS.instanceChromeDriver, GuruUTILS.locationWebDriverChrom);
        driver = new ChromeDriver();
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
    public void logInbackendlogin(String id,String pass) throws AWTException {
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


    //get data from first cell
    public String table(){
         String dataFromTable = madgentoAdminPanelPage.getTable()
                .findElement(By.xpath("//*[@id='reviwGrid_table']/tbody/tr[1]/td[2]")).getText();
        System.out.println(dataFromTable);
        return dataFromTable;
    }
}
