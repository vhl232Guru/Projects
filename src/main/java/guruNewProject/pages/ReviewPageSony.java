package guruNewProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPageSony {
    WebDriver driver;
    @FindBy(xpath = "//li/div[@class='input-box']")
    WebElement testAreaThougths;
    @FindBy(xpath = "//div[@class='input-box']//input[@id='summary_field']")
    WebElement areaSummaryReview;
    @FindBy(xpath = "//div[@class='input-box']//input[@id='nickname_field']")
    WebElement areaNickName;
    @FindBy(xpath = "//button[@title='Submit Review']")
    WebElement buttonReview;

    public WebElement getButtonReview() {
        return buttonReview;
    }

    public WebElement getAreaNickName() {
        return areaNickName;
    }

    public WebElement getAreaSummaryReview() {
        return areaSummaryReview;
    }

    public WebElement getTestAreaThougths() {
        return testAreaThougths;
    }

    public ReviewPageSony(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
