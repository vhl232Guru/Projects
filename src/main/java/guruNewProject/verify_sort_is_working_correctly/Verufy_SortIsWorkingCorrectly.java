package guruNewProject.verify_sort_is_working_correctly;

import guruNewProject.GuruUTILS;
import guruNewProject.pages.MadgentoAdminPanelPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

/*
Verify Sort is working correctly
1.Go to http://live.guru99.com/index.php/backendlogin
2.Login with credentials provided.
3.Go to Sales invoice.
4.Sort Invoice Data Column in ascending and descending order.
5.Verify the sort working as expected. --> Sort functionality works as expected.
 */


public class Verufy_SortIsWorkingCorrectly {

    WebDriver driver;
    MadgentoAdminPanelPage madgentoAdminPanelPage;
    Actions actions;
    Action action;
    @BeforeClass
    public void setSystem(){
        System.setProperty(GuruUTILS.instanceChromeDriver,GuruUTILS.locationWebDriverChrom);
        driver = new ChromeDriver();
        driver.get(GuruUTILS.urlbackendlogin);
        actions = new Actions(driver);
    }

    @Test(dataProvider = "logIn",dataProviderClass = GuruUTILS.class)
    public void log_in(String id,String pass){
            GuruUTILS.logIn(id,pass,driver);
    }


    @Test
    public void sortInvoiceData() throws InterruptedException {
    madgentoAdminPanelPage = new MadgentoAdminPanelPage(driver);
    action = actions.moveToElement(madgentoAdminPanelPage.getSalesButton()).build();
    action.perform();
    madgentoAdminPanelPage.getInvoicesButton().click();

    System.out.println(dateFromFirstRow());
    System.out.println(dateFromLastRow());

    if(dateFromFirstRow()>dateFromLastRow()) {
        System.out.println("Table sort descending order "+ dateFromFirstRow()+" --> "+dateFromLastRow());}
    else {System.out.println("Table sort ascending order"+ dateFromLastRow()+" --> "+dateFromFirstRow());}

    madgentoAdminPanelPage.getInvocesSortButton().click();
    Thread.sleep(3000);
    if(dateFromFirstRow()>dateFromLastRow()){
        System.out.println("Sort don't work "+dateFromFirstRow()+" --> "+dateFromLastRow());
    }
    else System.out.println("Sort is work rigthd "+dateFromFirstRow()+" --> "+dateFromLastRow()+"\n"
            +"Table sort ascending order");

    }
    @AfterClass
    public void close(){
        driver.quit();
    }

    public int dateFromFirstRow(){
        String dateFromFirstRow = madgentoAdminPanelPage.getTableInvoices()
                .findElement(By.xpath("//*[@id=\"sales_invoice_grid_table\"]/tbody/tr[1]/td[3]"))
                .getText().substring(7,12).trim();
        int firstDate = Integer.parseInt(dateFromFirstRow);
        //System.out.println(dateFromFirstRow);
        return firstDate;
    }
    public int dateFromLastRow(){
        String dateFromLastRow = madgentoAdminPanelPage.getTableInvoices()
                .findElement(By.xpath("//*[@id=\"sales_invoice_grid_table\"]/tbody/tr[6]/td[3]"))
                .getText().substring(7,12).trim();
        int lastDate = Integer.parseInt(dateFromLastRow);
        //System.out.println(dateFromLastRow);
        return lastDate;
    }


}
