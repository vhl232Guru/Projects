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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.awt.*;

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
        try {
            GuruUTILS.logIn(id, pass, driver);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"message-popup-window\"]/div[1]/a/span")).click();
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
}
