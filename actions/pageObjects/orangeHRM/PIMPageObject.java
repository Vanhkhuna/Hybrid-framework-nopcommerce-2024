package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.orangeHRMPageUI.PIMPageUI;

public class PIMPageObject extends BasePage {
    WebDriver driver;

    public PIMPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddEmployeeButton() {
        waitForElementClickable(driver, PIMPageUI.ADD_EMPLOYEE_BUTTON);
        clickToElement(driver, PIMPageUI.ADD_EMPLOYEE_BUTTON);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PIMPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, PIMPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PIMPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, PIMPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void inputToEmployeeIDTextbox(String employeeID) {
        waitForElementVisible(driver, PIMPageUI.EMPLOYEE_ID_TEXTBOX);
        clearValueInElementByPressKey(driver, PIMPageUI.EMPLOYEE_ID_TEXTBOX);
        sendkeyToElement(driver, PIMPageUI.EMPLOYEE_ID_TEXTBOX, employeeID);

    }

    public void clickSaveButton() {
        waitForElementClickable(driver, PIMPageUI.SAVE_BUTTON);
        clickToElement(driver, PIMPageUI.SAVE_BUTTON);
    }

    public boolean isSuccessMessageDisplayed(String message) {
        waitForElementVisible(driver, PIMPageUI.SUCCESSFULLY_MESSAGE, message);
        return isElementDisplayed(driver, PIMPageUI.SUCCESSFULLY_MESSAGE, message);
    }


    public boolean isFirstNameTextboxDisplayed(WebDriver driver, String firstName) {
        waitForElementVisible(driver, PIMPageUI.FIRSTNAME_TEXTBOX, firstName);
        return isElementDisplayed(this.driver, PIMPageUI.FIRSTNAME_TEXTBOX, firstName);

    }

    public boolean isLastNameTextboxDisplayed(WebDriver driver, String lastName) {
        waitForElementVisible(driver, PIMPageUI.LASTNAME_TEXTBOX, lastName);
        return isElementDisplayed(driver, PIMPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public boolean isEmployeeIDTextboxDisplayed(WebDriver driver, String employeeID) {
        waitForElementVisible(driver, PIMPageUI.EMPLOYEE_ID_TEXTBOX, employeeID);
        return isElementDisplayed(driver, PIMPageUI.EMPLOYEE_ID_TEXTBOX, employeeID);
    }

    public void clickToProfilePicture() {
        waitForElementClickable(driver, PIMPageUI.PROFILE_PICTURE);
        clickToElement(driver, PIMPageUI.PROFILE_PICTURE);
    }

    public void clickToAddIcon() {
        waitForElementClickable(driver, PIMPageUI.ADD_ICON);
        clickToElement(driver, PIMPageUI.ADD_ICON);
    }

    public boolean isDefaultPhotoUndisplayed() {
        waitForElementInvisible(driver, PIMPageUI.DEFAULT_PHOTO);
        return isElementUnDisplayed(driver, PIMPageUI.DEFAULT_PHOTO);
    }

    public void openTabsItemByName(WebDriver driver, String tabItemName) {
        waitForElementClickable(driver, PIMPageUI.TABS_ITEM_BY_NAME, tabItemName);
        clickToElement(driver, PIMPageUI.TABS_ITEM_BY_NAME, tabItemName);
    }

    public void inputToTextboxByName(WebDriver driver, String textbox, String value) {
        waitForElementVisible(driver, PIMPageUI.INPUT_TO_TEXTBOX_BY_NAME, textbox);
        sendkeyToElement(driver, PIMPageUI.INPUT_TO_TEXTBOX_BY_NAME, value, textbox);
    }

    public void selectDropdownByName(WebDriver driver, String dropdown, String value) {
        waitForElementVisible(driver, PIMPageUI.SELECT_DROPDOWN_BY_NAME, dropdown);
        selectItemDropdown(driver, PIMPageUI.SELECT_DROPDOWN_BY_NAME, value);
    }

    public String getTextboxValueByName(WebDriver driver, String textboxID) {
        waitForElementVisible(driver, PIMPageUI.INPUT_TO_TEXTBOX_BY_NAME, textboxID);
        return getElementAttribute(driver, PIMPageUI.INPUT_TO_TEXTBOX_BY_NAME, "value", textboxID);
    }

    public void clickToRadioButtonByName(WebDriver driver, String radioButtonLabelName) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", PIMPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
    }

    public void clickToAddButtonByLabel(WebDriver driver, String labelName) {
        waitForElementClickable(driver, PIMPageUI.ADD_BUTTON, labelName);
        clickToElement(driver, PIMPageUI.ADD_BUTTON, labelName);
    }
}
