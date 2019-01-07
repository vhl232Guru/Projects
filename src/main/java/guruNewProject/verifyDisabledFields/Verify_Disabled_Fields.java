package guruNewProject.verifyDisabledFields;

import guruNewProject.GuruUTILS;
import guruNewProject.pages.MadgentoAdminPanelPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/*
Verify disabled fields.
1.Go to http://live.guru99.com/index.php/backendlogin
2.Login with credentials provided.
3.Go to Customers --> Manage Customers menu.
4.Open any customer's detail by clicking on view link in the grid.
5.Click on "Account Information" tab for the customer's detail page.
     --> "Associate to Website" and "Created from" controls should be disabled.
6.Verify disabled fields.
7.Verify blank fields.
     --> New Password field should bee blank.
 */

public class Verify_Disabled_Fields {
    WebDriver driver;
    Actions actions;
    Action action;
    MadgentoAdminPanelPage madgentoAdminPanelPage;

    @BeforeClass
    public void set_Properties(){
        System.setProperty(GuruUTILS.instanceChromeDriver,GuruUTILS.locationWebDriverChrom);
        driver = new ChromeDriver();
        driver.get(GuruUTILS.urlbackendlogin);

    }

    @Test(dataProvider = "logIn",dataProviderClass = GuruUTILS.class)
    public void log_in(String id,String pass){

            GuruUTILS.logIn(id, pass, driver);

        // driver.findElement(By.xpath("//*[@id=\"message-popup-window\"]/div[1]/a/span")).click();
    }
    @Test
    public void open_custumers_details(){
        madgentoAdminPanelPage = new MadgentoAdminPanelPage(driver);
        actions = new Actions(driver);
        action = actions.moveToElement(madgentoAdminPanelPage.getCustumers_Button()).build();
        action.perform();
        madgentoAdminPanelPage.getMange_Custumers_Button().click();

        madgentoAdminPanelPage.getCustumers_Table()
                .findElement(By.xpath("//*[@class='grid']//tbody/tr[1]/td[2]")).click();
    }

    @Test
    public void verify_Disabled_Fields(){
        madgentoAdminPanelPage.getAccaunt_Information_Button().click();
        Boolean assocateToWeb = madgentoAdminPanelPage.getAssociate_To_WebSite_Field().isEnabled();
        Boolean crestedFrom = madgentoAdminPanelPage.getCreated_From_Field().isEnabled();
        System.out.println(assocateToWeb + " " + crestedFrom);

        Assert.assertFalse(assocateToWeb);
        Assert.assertFalse(crestedFrom);


        String pass_Field  = madgentoAdminPanelPage.getNew_Password_Field().getAttribute("value");
        Boolean passField = pass_Field.isEmpty();
        Assert.assertTrue(passField);

    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
