package guruNewProject;

import guruNewProject.pages.LoginPage;
import guruNewProject.pages.MadgentoAdminPanelPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.DataProvider;

import java.awt.*;
import java.awt.event.InputEvent;


public class GuruUTILS {

    public static String locationWebDriverChrom;
    public static String instanceChromeDriver;
    public static String urlbackendlogin;
    public static String urlGuruMainPage;
     WebDriver driver;
    static {
        locationWebDriverChrom = "F:\\selenium drivera" +
                "\\ChromeDriver\\chromedriver_win32\\chromedriver.exe";
        instanceChromeDriver = "webdriver.chrome.driver";
        urlbackendlogin = "http://live.guru99.com/index.php/backendlogin";
        urlGuruMainPage = "http://live.guru99.com/index.php";
    }

    public WebDriver setProp(String browserType){
        switch (browserType){
            case"Chrome":
                System.setProperty("webdriver.chrome.driver","F:\\selenium drivera" +
                        "\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver","F:\\selenium drivera" +
                        "\\Mozilla GeckoDriver\\geckodriver.exe");
                 driver = new FirefoxDriver();
                 break;
            case "Opera":
                System.setProperty("webdriver.opera.driver","F:\\selenium drivera" +
                        "\\Opera\\operadriver.exe");
                 driver = new OperaDriver();

        }
         return driver;
    }


    public static void logIn(String id,String pass,WebDriver driver)  {
        LoginPage loginPage;
        loginPage = new LoginPage(driver);
        loginPage.getUserNameField().sendKeys(id);
        loginPage.loginField.sendKeys(pass);
        loginPage.getLoginButton().click();
        MadgentoAdminPanelPage madgentoAdminPanelPage = new MadgentoAdminPanelPage(driver);
        madgentoAdminPanelPage.getClose_POP_UP_WINDOW().click();

        //closePopUp();
    }


    //data for logIn
    @DataProvider(name = "logIn")
    public static Object[][]getLogData(){
        return new Object[][]{{"user01","guru99com"}};
    }

    //close popup
    public static void closePopUp() throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(701,426);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
