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
 import org.testng.annotations.*;
 import java.io.File;

 //Verify invoices can be printed:
 // 1.Go to http://live.guru99.com/index.php/backendlogin.
 // 2.Login credentials provided.
 // 3.Go to seles --> Orders menu.
 // 4.In the status field select "Canceled" .Click search.
 // 5.Select the checkbox next to first order.
 // 6.In Actions, select "Print invoices".Click Submit.
 // 7.Verify the error message. --> Error message:"The are no printable documents related to selected orders" is shown.
 // 8.In the status field select "Complete". Click search.
 // 9.Select the checkbox next to first order.
 // 10.In Actions, select "Print invoices".Click Submit.
 // 11.Verify the invoice is downloaded.--> Invoice is downloaded.

 public class VerifyInvoicePrint {

     WebDriver driver;
     WebDriverWait wait;
     Select select;
     MadgentoAdminPanelPage madgentoAdminPanelPage;

    @BeforeClass
     public void setProperty()  {
        System.setProperty(GuruUTILS.instanceChromeDriver, GuruUTILS.locationWebDriverChrom);
        driver = new ChromeDriver();
        driver.get(GuruUTILS.urlbackendlogin);
        madgentoAdminPanelPage  = new MadgentoAdminPanelPage(driver);
        wait = new WebDriverWait(driver,10);

    }

    @Test(dataProvider ="logIn",dataProviderClass = GuruUTILS.class, priority = 0)
     public void logIn(String id,String pass)  {
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // System.out.println(fileName);
        //Assert.assertEquals((new File(fileName)).isFile(),true);*/
       File catal = new File("C:\\Users\\Pavel\\Downloads");
        System.out.println(catal.isDirectory());
        boolean invoinceFile;
        for (File nameFile:catal.listFiles()) {
            if(nameFile.isFile()&&(invoinceFile = nameFile.getName().startsWith("invoice"))){
                Assert.assertTrue(invoinceFile);
                System.out.println("File is exist!");
                break;
            }
            else System.out.println("File not exist!");
        }

    }

    @AfterClass
     public void close(){
        driver.quit();
    }


}
