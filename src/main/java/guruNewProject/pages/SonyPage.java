package guruNewProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SonyPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='product-collateral toggle-content tabs']//li[2]")
    WebElement reviewsBottomButton;
    @FindBy(xpath = "//*[@id=\"customer-reviews\"]/dl/dd[1]/span")
    WebElement textReview;

    public WebElement getTextReview() {
        return textReview;
    }

    public WebElement getReviewsBottomButton() {
        return reviewsBottomButton;
    }

    public SonyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
