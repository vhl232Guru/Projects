package guruNewProject.verifySearchFunctionality;

import guruNewProject.GuruUTILS;
import guruNewProject.pages.GuruMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Verify Search Functionality
1.Go to http://live.guru99.com/index.php
2.Click on Advance Search
3.In Price field enter range 0-150. Click Search.
4.Note the Price and Product Name in the result.Print on Console.
    --> Product name and price are fetched and displayed on console.
5.Again, In the Price field enter range 151-1000. Click Search.
6.Note the Price and Product Name in the result.
5.Again, In the Price field enter range 151-1000. Click Search. Print on Console.
    -->Product name and price are fetched and displayed on console.
 */

public class Verify_Search_Functionality {
    WebDriver driver;
    GuruMainPage guruMainPage;

    @BeforeClass
    public void setSyst(){
        System.setProperty(GuruUTILS.instanceChromeDriver,GuruUTILS.locationWebDriverChrom);
        driver = new ChromeDriver();
        driver.get(GuruUTILS.urlGuruMainPage);
    }

    @Test
    public void serchFunc(){
        guruMainPage = new GuruMainPage(driver);
        guruMainPage.getAdvancedSearchButton().click();
        guruMainPage.getPriceFieldFrom().sendKeys("0");
        guruMainPage.getPrice_Fild_To().sendKeys("150");
        guruMainPage.getSearchButton().submit();

        String sonyName = guruMainPage.getSonyName().getText();
        String sonyPrice = guruMainPage.getSonyPrice().getText();

        String samsungName = guruMainPage.getSamsungName().getText();
        String samsungPrice = guruMainPage.getSamsung_New_Price().getText();

        System.out.println(sonyName+" --> "+sonyPrice);
        System.out.println(samsungName+" --> "+samsungPrice);

        System.out.println("----------------------");

        guruMainPage.getAdvancedSearchButton().click();
        guruMainPage.getPriceFieldFrom().sendKeys("151");
        guruMainPage.getPrice_Fild_To().sendKeys("1000");
        guruMainPage.getSearchButton().submit();


        String ifon_Name = guruMainPage.getIfone_Name().getText();
        String ifon_Price = guruMainPage.getIfon_Price().getText();
        String sansung_LCD_Nmae = guruMainPage.getSamsung_LCD_Name().getText();
        String samsung_LCD_Price = guruMainPage.getSamsung_LCD_Price().getText();
        String lg_Name = guruMainPage.getLg_lcd_Name().getText();
        String lg_Price = guruMainPage.getLg_lcd_Price().getText();

        System.out.println(ifon_Name+" --> "+ifon_Price);
        System.out.println(lg_Name+" --> "+lg_Price);
        System.out.println(sansung_LCD_Nmae+" --> "+samsung_LCD_Price);

        System.out.println("----------------------");

        System.out.println("Advanced Search is work and rasult displayed on console!!");
    }


    @AfterClass
    public void close(){
        driver.quit();
    }
}
