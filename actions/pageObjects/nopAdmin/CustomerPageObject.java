package pageObjects.nopAdmin;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.nopAdmin.CustomerPageUI;

import java.time.Duration;

public class CustomerPageObject extends BasePage {
    WebDriver driver;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNewButton() {
        waitForElementClickable(driver, CustomerPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, CustomerPageUI.ADD_NEW_BUTTON);
    }

    public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
        waitForElementVisible(driver, CustomerPageUI.DYNAMIC_TEXTBOX, textboxID);
        sendkeyToElement(driver, CustomerPageUI.DYNAMIC_TEXTBOX, value, textboxID);
    }

    public void clickToRadioCheckboxByID(WebDriver driver, String gender) {
        waitForElementClickable(driver, CustomerPageUI.RADIO_CHECKBOX, gender);
        checkToDefaultCheckboxOrRadio(driver, CustomerPageUI.RADIO_CHECKBOX, gender);
    }

    public void inputToCustomerTextbox(String value) {
        waitForElementVisible(driver, CustomerPageUI.ROLE_TEXTBOX);
        sendkeyToElement(driver, CustomerPageUI.ROLE_TEXTBOX, value);
    }

    public void inputToCommentTextbox(String comment) {
        waitForElementVisible(driver, CustomerPageUI.COMMENT_TEXTBOX);
        sendkeyToElement(driver, CustomerPageUI.COMMENT_TEXTBOX, comment);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, CustomerPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerPageUI.SAVE_BUTTON);
    }

    public boolean waitForAjaxBusyLoadingInvisible() {
        WebDriverWait expliciWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy span")));

    }

    public boolean isAddedNewCustomerSuccessMessageDisplayed(String message) {
        waitForElementVisible(driver, CustomerPageUI.DYNAMIC_SUCCESS_MESSAGE, message);
        return isElementDisplayed(driver, CustomerPageUI.DYNAMIC_SUCCESS_MESSAGE, message);
    }

    public void inputEmailTextbox(String email) {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX_AT_CUSTOMER_LIST);
        sendkeyToElement(driver, CustomerPageUI.EMAIL_TEXTBOX_AT_CUSTOMER_LIST, email);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, CustomerPageUI.SEARCH_BUTTON);
        clickToElement(driver, CustomerPageUI.SEARCH_BUTTON);
    }

    public String getValueRowAtTable() {
        WebElement allRowElementAtTable = getWebElement(driver, CustomerPageUI.ALL_ROW_ELEMENT_AT_TABLE);
        return allRowElementAtTable.getText();
    }

    public void clickToEditButton() {
        waitForElementClickable(driver, CustomerPageUI.EDIT_BUTTON);
        clickToElement(driver, CustomerPageUI.EDIT_BUTTON);
    }

    public void clickToDeleteButton() {
        waitForElementClickable(driver, CustomerPageUI.DELETE_BUTTON);
        clickToElement(driver, CustomerPageUI.DELETE_BUTTON);
    }

    public boolean isDeleteDialogDisplayed() {
        waitForElementVisible(driver, CustomerPageUI.DELETE_DIALOG);
        return isElementDisplayed(driver, CustomerPageUI.DELETE_DIALOG);
    }

    public void clickToDeleteButtonAtDialog() {
        waitForElementClickable(driver, CustomerPageUI.DELETE_BUTTON_AT_DIALOG);
        clickToElement(driver, CustomerPageUI.DELETE_BUTTON_AT_DIALOG);
    }

    public boolean isDeletedCustomerSuccessMessageDisplayed(String message) {
        waitForElementVisible(driver, CustomerPageUI.DYNAMIC_SUCCESS_MESSAGE, message);
        return isElementDisplayed(driver, CustomerPageUI.DYNAMIC_SUCCESS_MESSAGE, message);
    }

    public boolean isNoDataMessageDisplayed(String message) {
        waitForElementVisible(driver, CustomerPageUI.NO_DATA_MESSAGE, message);
        return isElementDisplayed(driver, CustomerPageUI.NO_DATA_MESSAGE, message);
    }
}
