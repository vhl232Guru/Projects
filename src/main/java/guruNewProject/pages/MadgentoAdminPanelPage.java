package guruNewProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MadgentoAdminPanelPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"message-popup-window\"]/div[1]/a/span")
    WebElement close_POP_UP_WINDOW;
    @FindBy(xpath = "//ul[@id='nav']/descendant::span[1]")
    public WebElement salesButton;
    @FindBy(xpath = "//ul[@id='nav']/descendant::li[2]/child::a")
    public WebElement ordersButton;
    @FindBy(xpath = "//td[@class='export a-right']/child::select")
    public WebElement selectCSV;
    @FindBy(xpath = "//td[@class='export a-right']/child::button")
    public WebElement exportButton;
    @FindBy(xpath = "//tr[@class='filter']/child::th/select[@class='no-changes']")
    public WebElement selectStatus;
    @FindBy(xpath = "//td[@class='filter-actions a-right']/child::button[2]/span")
    public WebElement buttonSearch;
    @FindBy(xpath = "//tbody/tr[contains(@title,'order_id/8060')]/td/input")
    public WebElement secondCheckbox;
    @FindBy(xpath = "//select[@id='sales_order_grid_massaction-select']")
    public WebElement actionSelect;
    @FindBy(xpath = "//span/button[@class='scalable']")
    WebElement buttonSubmit;
    @FindBy(xpath = "//div[@id='messages']/descendant::li//span")
    WebElement message;
    @FindBy(xpath = "//tbody/tr/td/input[@value='5']")
    WebElement checkboxComplite;
    @FindBy(xpath = "//li[@class='  parent level0'][2]")
    WebElement catalogButton;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/ul/li")
    WebElement reviewAndSettingsButton;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/ul/li/ul/li[1]")
    WebElement custamerReview;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/ul/li/ul/li[1]/ul/li[1]")
    WebElement pending_Reviews;
    @FindBy(xpath = "//*[@id=\"reviwGrid_table\"]/tbody/tr[1]/td[2]")
    WebElement sortIdLast;
    @FindBy(xpath = "//input[@name='review_id']")
    WebElement fieldID;
    @FindBy(xpath = "//*[@id='reviwGrid_table']/tbody")
    WebElement table;
    @FindBy(xpath = "//*[@id='reviwGrid_table']/tbody//a")
    WebElement editButton;
    @FindBy(xpath = "//div[@id='review_details']//select")
    WebElement slectStatusReviewPage;
    @FindBy(xpath = "//button[@title='Save Review']")
    WebElement saveReviewButton;
    @FindBy(xpath = "//*[@id='nav']//li[@class='  last level1']/a")
    WebElement invoicesButton;
    @FindBy(xpath = "//*[@class='hor-scroll']//tbody")
    WebElement tableInvoices;
    @FindBy(xpath = "//div[@class='hor-scroll']//tr/th[3]")
    WebElement invocesSortButton;
    @FindBy(xpath = "//*[@id='nav']/li[3]/a")
    WebElement custumers_Button;
    @FindBy(xpath = "//*[@id='nav']/li[3]/ul/li/a/span")
    WebElement mange_Custumers_Button;
    @FindBy(xpath = "//*[@class='grid']//tbody")
    WebElement custumers_Table;
    @FindBy(xpath = "//*[@id='customer_info_tabs']/li[2]/a")
    WebElement accaunt_Information_Button;
    @FindBy(xpath = "//*[@id='_accountbase_fieldset']//tbody")
    WebElement accaunt_Information_Table;
    @FindBy(xpath = "//*[@id='_accountbase_fieldset']//tbody//select")
    WebElement associate_To_WebSite_Field;
    @FindBy(xpath = "//*[@id='_accountbase_fieldset']//tbody//input")
    WebElement created_From_Field;
    @FindBy(xpath = "//*[@id='_accountnew_password']")
    WebElement new_Password_Field;

    public WebElement getNew_Password_Field() {
        return new_Password_Field;
    }

    public WebElement getCreated_From_Field() {
        return created_From_Field;
    }

    public WebElement getAssociate_To_WebSite_Field() {
        return associate_To_WebSite_Field;
    }

    public WebElement getAccaunt_Information_Table() {
        return accaunt_Information_Table;
    }

    public WebElement getAccaunt_Information_Button() {
        return accaunt_Information_Button;
    }

    public WebElement getCustumers_Table() {
        return custumers_Table;
    }

    public WebElement getMange_Custumers_Button() {
        return mange_Custumers_Button;
    }

    public WebElement getCustumers_Button() {
        return custumers_Button;
    }

    public WebElement getClose_POP_UP_WINDOW() {
        return close_POP_UP_WINDOW;
    }

    public WebElement getInvocesSortButton() {
        return invocesSortButton;
    }

    public WebElement getTableInvoices() {
        return tableInvoices;
    }

    public WebElement getInvoicesButton() {
        return invoicesButton;
    }

    public WebElement getSaveReviewButton() {
        return saveReviewButton;
    }

    public WebElement getSlectStatusReviewPage() {
        return slectStatusReviewPage;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getTable() {
        return table;
    }

    public WebElement getFieldID() {
        return fieldID;
    }

    public WebElement getSortIdLast() {
        return sortIdLast;
    }

    public WebElement getPending_Reviews() {
        return pending_Reviews;
    }

    public WebElement getCustamerReview() {
        return custamerReview;
    }

    public WebElement getReviewAndSettingsButton() {
        return reviewAndSettingsButton;
    }

    public WebElement getCatalogButton() {
        return catalogButton;
    }

    public WebElement getCheckboxComplite() {
        return checkboxComplite;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getButtonSubmit() {
        return buttonSubmit;
    }

    public WebElement getActionSelect() {
        return actionSelect;
    }

    public WebElement getSecondCheckbox() {
        return secondCheckbox;
    }

    public WebElement getButtonSearch() {
        return buttonSearch;
    }

    public WebElement getSelectStatus() {
        return selectStatus;
    }

    public WebElement getExportButton() {
        return exportButton;
    }

    public WebElement getSelectCSV() {
        return selectCSV;
    }

    public WebElement getOrdersButton() {
        return ordersButton;
    }

    public WebElement getSalesButton() {
        return salesButton;
    }

    public MadgentoAdminPanelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
