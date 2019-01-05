package guruNewProject;

import guruNewProject.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.awt.*;
import java.awt.event.InputEvent;


public class GuruUTILS {

    public static String locationWebDriverChrom;
    public static String instanceChromeDriver;
    public static String urlbackendlogin;
    public static String urlGuruMainPage;
    static {
        locationWebDriverChrom = "F:\\hachik NE TROGAT\\test\\selenium drivera" +
                "\\ChromeDriver\\chromedriver_win32\\chromedriver.exe";
        //locationWebDriver = "E:\\Java\\chromedriver.exe";
        instanceChromeDriver = "webdriver.chrome.driver";
        urlbackendlogin = "http://live.guru99.com/index.php/backendlogin";
        urlGuruMainPage = "http://live.guru99.com/index.php";
    }

    /*public void setProp(WebDriver driver,String locationWebdriver,String instanceDriver, String url){
        System.getProperty(instanceDriver,locationWebdriver);
        driver = new ChromeDriver();
        driver.get(url);
    }*/

    public static void logIn(String id,String pass,WebDriver driver) throws AWTException {
        LoginPage loginPage;
        loginPage = new LoginPage(driver);
        loginPage.getUserNameField().sendKeys(id);
        loginPage.loginField.sendKeys(pass);
        loginPage.getLoginButton().click();
        //closePopUp();
    }


    //data for logIn
    @DataProvider(name = "logIn")
    public static Object[][]getLogData(){
        return new Object[][]{{"user01","guru99com"}};
    }

    //close pop up
    public static void closePopUp() throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(701,426);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
