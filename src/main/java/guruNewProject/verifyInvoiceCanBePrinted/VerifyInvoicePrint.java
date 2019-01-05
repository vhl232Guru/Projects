 package guruNewProject.verifyInvoiceCanBePrinted;

 import guruNewProject.GuruUTILS;
 import guruNewProject.pages.LoginPage;
 import guruNewProject.pages.MadgentoAdminPanelPage;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.interactions.Action;
 import org.openqa.selenium.interactions.Actions;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.Select;
 import org.openqa.selenium.support.ui.WebDriverWait;
 import org.testng.Assert;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.DataProvider;
 import org.testng.annotations.Test;

 import java.awt.*;
 import java.awt.event.InputEvent;
 import java.io.File;

 public class VerifyInvoicePrint {

     WebDriver driver;
     WebDriverWait wait;
     Select select;
     MadgentoAdminPanelPage madgentoAdminPanelPage;

    @BeforeTest
     public void setProperty()  {
        System.setProperty(GuruUTILS.instanceChromeDriver, GuruUTILS.locationWebDriverChrom);
        driver = new ChromeDriver();
        driver.get(GuruUTILS.urlbackendlogin);
        madgentoAdminPanelPage  = new MadgentoAdminPanelPage(driver);
        wait = new WebDriverWait(driver,10);

    }

    @Test(dataProvider ="logIn",dataProviderClass = GuruUTILS.class, priority = 0)
     public void logIn(String id,String pass) throws AWTException {
       GuruUTILS.logIn(id,pass,driver);
    }

    @Test(priority = 1)
    public void entrOrderMenu(){
        Actions actions = new Actions(driver);
        WebElement sales = wait.until(ExpectedConditions.visibilityOf(madgentoAdminPanelPage.getSalesButton()));
        Action action = actions.moveToElement(sales)
                .click(madgentoAdminPanelPage.getOrdersButton()).build();
        action.perform();
    }

    @Test(priority = 2)
    public void selectStatus(){
        select = new Select(madgentoAdminPanelPage.getSelectStatus());
        select.selectByValue("canceled");
        madgentoAdminPanelPage.getButtonSearch().click();
    }

    @Test(priority = 3)
    public void selectCheckbox(){
        WebElement checkbox = wait.until(ExpectedConditions
                .elementToBeClickable(madgentoAdminPanelPage.getSecondCheckbox()));
        checkbox.click();
    }

    @Test(priority = 4)
    public void printInvoices(){
        select = new Select(madgentoAdminPanelPage.getActionSelect());
        select.selectByVisibleText("Print Invoices");
        wait.until(ExpectedConditions.elementToBeClickable(madgentoAdminPanelPage.getButtonSubmit())).click();
    }
    @Test(priority = 5)
    public void verifyErrorMessage(){
        String errorMessage = "There are no printable documents related to selected orders.";
        Assert.assertEquals(errorMessage,madgentoAdminPanelPage.getMessage().getText());
    }

    @Test(priority = 6)
    public void complit(){
        select = new Select(madgentoAdminPanelPage.getSelectStatus());
        select.selectByVisibleText("Complete");
        madgentoAdminPanelPage.getButtonSearch().click();
    }
    @Test(priority = 7)
    public void printComlitOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(madgentoAdminPanelPage.getCheckboxComplite())).click();
        printInvoices();
    }

    @Test(priority = 8)
    public void checkExtitFile(){
        String fileName = "C:\\Users\\Павел\\Downloads\\invoice2018-12-20_15-20-01.pdf";

        Assert.assertEquals((new File(fileName)).isFile(),true);
    }


}
