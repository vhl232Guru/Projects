package guruNewProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuruMainPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@id='header-nav']//a")
    WebElement mobileButton;
    @FindBy(xpath = "//div[@class='footer']//div[@class='links']//li[@class=' last']/a")
    WebElement advancedSearchButton;
    @FindBy(xpath = "//div[@class='col-main']//input[@name='price[from]']")
    WebElement priceFieldFrom;
    @FindBy(xpath = "//div[@class='col-main']//input[@name='price[to]']")
    WebElement price_Fild_To;
    @FindBy(xpath = "//*[@class='buttons-set']/button")
    WebElement searchButton;
    @FindBy(xpath = "//div[@class='product-info']//a")
    WebElement sonyName;
    @FindBy(xpath = "//div[@class='product-info']//div/span/span")
    WebElement sonyPrice;
    @FindBy(xpath = "//div[@class='product-info']//a[@title='Samsung Galaxy']")
    WebElement samsungName;
    @FindBy(xpath = "//div[@class='product-info']//div[@class='price-box']//span[@id='product-price-3']")
    WebElement samsung_New_Price;
    @FindBy(xpath = "//div[@class='product-info']/h2/a")
    WebElement ifone_Name;
    @FindBy(xpath = "//div[@class='product-info']//span/span")
    WebElement ifon_Price;
    @FindBy(xpath = "//div[@class='product-info']//a[@title='LG LCD']")
    WebElement lg_lcd_Name;
    @FindBy(xpath = "//div[@class='product-info']//span[@id='product-price-4']")
    WebElement lg_lcd_Price;
    @FindBy(xpath = "//div[@class='product-info']//a[@title='Samsung LCD']")
    WebElement samsung_LCD_Name;
    @FindBy(xpath = "//div[@class='product-info']//span[@id='product-price-5']/span")
    WebElement samsung_LCD_Price;

    public WebElement getSamsung_LCD_Price() {
        return samsung_LCD_Price;
    }

    public WebElement getSamsung_LCD_Name() {
        return samsung_LCD_Name;
    }

    public WebElement getLg_lcd_Price() {
        return lg_lcd_Price;
    }

    public WebElement getLg_lcd_Name() {
        return lg_lcd_Name;
    }

    public WebElement getIfon_Price() {
        return ifon_Price;
    }

    public WebElement getIfone_Name() {
        return ifone_Name;
    }

    public WebElement getSamsung_New_Price() {
        return samsung_New_Price;
    }

    public WebElement getSamsungName() {
        return samsungName;
    }

    public WebElement getSonyPrice() {
        return sonyPrice;
    }

    public WebElement getSonyName() {
        return sonyName;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getPrice_Fild_To() {
        return price_Fild_To;
    }

    public WebElement getPriceFieldFrom() {
        return priceFieldFrom;
    }

    public WebElement getAdvancedSearchButton() {
        return advancedSearchButton;
    }

    public WebElement getMobileButton() {
        return mobileButton;
    }

    public GuruMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
