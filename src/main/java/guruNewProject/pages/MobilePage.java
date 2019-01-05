package guruNewProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilePage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='category-products']//img[@id='product-collection-image-1']")
    WebElement sonyImage;

    public WebElement getSonyImage() {
        return sonyImage;
    }

    public MobilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
