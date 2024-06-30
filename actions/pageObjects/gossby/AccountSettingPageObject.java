package pageObjects.gossby;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.gossby.AccountSettingPageUI;


import java.time.Duration;


public class AccountSettingPageObject extends BasePage {
    WebDriver driver;

    public AccountSettingPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEmailDisplayed(String email) {
        waitForElementVisible(driver, AccountSettingPageUI.EMAIL_DISPLAYED, email);
        return isElementDisplayed(driver, AccountSettingPageUI.EMAIL_DISPLAYED, email);
    }

    public void inputToTextboxByName(WebDriver driver, String textbox, String value) {
        waitForElementVisible(driver, AccountSettingPageUI.INPUT_TEXTBOX_BY_NAME, textbox);
        sendkeyToElement(driver, AccountSettingPageUI.INPUT_TEXTBOX_BY_NAME, value, textbox);
    }

    public String getErrorMessageAtDynamicFieldByName(WebDriver driver, String field) {
        waitForElementVisible(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_NAME_MY_PROFILE, field);
        return getElementText(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_NAME_MY_PROFILE, field);
    }

    public void clickRadioButtonByText(WebDriver driver, String radioButtonLabelName) {
        checkToDefaultCheckboxOrRadio(driver, AccountSettingPageUI.RADIO_BUTTON_BY_TEXT, radioButtonLabelName);

    }

    public void selectValueInDropdownByName(WebDriver driver, String dropdownAttributeName, String itemValue) {
        waitForElementClickable(driver, AccountSettingPageUI.DROPDOWN_BY_NAME, dropdownAttributeName);
        selectItemDefaultDropdown(driver, AccountSettingPageUI.DROPDOWN_BY_NAME, itemValue, dropdownAttributeName);
    }

    public void clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
        waitForElementClickable(driver, AccountSettingPageUI.SAVE_BUTTON);
        clickToElement(driver, AccountSettingPageUI.SAVE_BUTTON);
    }

    public boolean isMessageAfterChangeInformationDisplayed(String message) {
        waitForElementVisible(driver, AccountSettingPageUI.MESSAGE_AFTER_CHANGE_INFORMATION_DISPLAYED, message);
        return isElementDisplayed(driver, AccountSettingPageUI.MESSAGE_AFTER_CHANGE_INFORMATION_DISPLAYED, message);
    }

    public void clickEmailEditLink() {
        waitForElementClickable(driver, AccountSettingPageUI.EDIT_EMAIL_LINK);
        clickToElement(driver, AccountSettingPageUI.EDIT_EMAIL_LINK);
    }

    public boolean isChangeEmailPopupDisplayed() {
        waitForElementVisible(driver, AccountSettingPageUI.CHANGE_EMAIL_POPUP);
        return isElementDisplayed(driver, AccountSettingPageUI.CHANGE_EMAIL_POPUP);
    }

    public void clickButtonByText(WebDriver driver, String buttonText) {
        waitForElementClickable(driver, AccountSettingPageUI.BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, AccountSettingPageUI.BUTTON_BY_TEXT, buttonText);
    }

    public boolean isChangeEmailPopupUndisplayed() {
        return isElementUnDisplayed(driver, AccountSettingPageUI.CHANGE_EMAIL_POPUP);
    }

    public void inputToEmailTextbox(String value) {
        waitForElementVisible(driver, AccountSettingPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AccountSettingPageUI.EMAIL_TEXTBOX, value);
    }

    public boolean isErrorMessageAtEmailFieldDisplayed(String message) {
        waitForElementVisible(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_EMAIL_FIELD, message);
        return isElementDisplayed(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_EMAIL_FIELD, message);
    }


    public void clickChangePasswordLink() {
        waitForElementClickable(driver, AccountSettingPageUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver, AccountSettingPageUI.CHANGE_PASSWORD_LINK);
    }

    public boolean isChangeMyPasswordHeaderDisplayed() {
        waitForElementVisible(driver, AccountSettingPageUI.CHANGE_MY_PASSWORD_HEADER);
        return isElementDisplayed(driver, AccountSettingPageUI.CHANGE_MY_PASSWORD_HEADER);
    }

    public String getErrorMessageAtDynamicFieldByNameAtChangePasswordTab(WebDriver driver, String nameTextbox) {
        waitForElementVisible(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_NAME_CHANGE_PASSWORD, nameTextbox);
        return getElementText(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_NAME_CHANGE_PASSWORD, nameTextbox);
    }

    public void clickBackButton() {
        waitForElementClickable(driver, AccountSettingPageUI.BACK_BUTTON);
        clickToElement(driver, AccountSettingPageUI.BACK_BUTTON);
    }

    public void clickAddressButton() {
        waitForElementClickable(driver, AccountSettingPageUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(driver, AccountSettingPageUI.ADD_NEW_ADDRESS_BUTTON);
    }

    public boolean isAddNewAddressPopupDisplayed() {
        waitForElementVisible(driver, AccountSettingPageUI.ADD_NEW_ADDRESS_POPUP);
        return isElementDisplayed(driver, AccountSettingPageUI.ADD_NEW_ADDRESS_POPUP);
    }

    public String getErrorMessageAtFullNameField() {
        waitForElementVisible(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_FULL_NAME_FIELD);
        return getElementText(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_FULL_NAME_FIELD);
    }

    public String getErrorMessageAtPhoneField() {
        waitForElementVisible(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_PHONE_FIELD);
        return getElementText(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_PHONE_FIELD);
    }

    public String getErrorMessageAtDynamicFieldByID(WebDriver driver, String id) {
        waitForElementVisible(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_ID, id);
        return getElementText(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_ID, id);
    }

    public void inputToDynamicTextboxByName(WebDriver driver, String nameTextbox, String value) {
        waitForElementVisible(driver, AccountSettingPageUI.DYNAMIC_TEXTBOX_BY_NAME, nameTextbox);
        sendkeyToElement(driver, AccountSettingPageUI.DYNAMIC_TEXTBOX_BY_NAME, value, nameTextbox);
    }

    public void clickDefaultCheckbox() {
        waitForElementClickable(driver, AccountSettingPageUI.DEFAULT_CHECKBOX);
        checkToDefaultCheckboxOrRadio(driver, AccountSettingPageUI.DEFAULT_CHECKBOX);
    }

    public void clickRemoveDefaultCheckbox() {
        waitForElementClickable(driver, AccountSettingPageUI.DEFAULT_CHECKBOX);
        clickToElement(driver, AccountSettingPageUI.DEFAULT_CHECKBOX);
    }

    public void clickSaveButtonAtAddAddressPopup() {
        waitForElementClickable(driver, AccountSettingPageUI.SAVE_BUTTON_AT_ADD_ADDRESS_POPUP);
        clickToElement(driver, AccountSettingPageUI.SAVE_BUTTON_AT_ADD_ADDRESS_POPUP);
    }

    public void selectCountryInDropdown(WebDriver driver, String value) {
        waitForElementClickable(driver, AccountSettingPageUI.CHANGE_COUNTRY_DROPDOWN);
        selectItemInDefaultDropdown(driver, AccountSettingPageUI.CHANGE_COUNTRY_DROPDOWN, value);

    }

    public String getErrorMessageAtProvinceField() {
        waitForElementVisible(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_PROVINCE_FIELD);
        return getElementText(driver, AccountSettingPageUI.ERROR_MESSAGE_AT_PROVINCE_FIELD);
    }

    public void selectProvinceInDropdown(String value) {
        waitForElementClickable(driver, AccountSettingPageUI.PROVINCE_DROPDOWN);
        selectItemDropdown(driver, AccountSettingPageUI.PROVINCE_DROPDOWN, value);
    }

    public String isDefaultStateAddressRecentDisplayed(WebDriver driver, String fullNameAuto) {
        waitForElementVisible(driver, AccountSettingPageUI.VERIFY_DEFAULT_STATE, fullNameAuto);
        return getElementText(driver, AccountSettingPageUI.VERIFY_DEFAULT_STATE, fullNameAuto);
    }

    public void clickDeleteDefaultAddressButton() {
        waitForElementClickable(driver, AccountSettingPageUI.DELETE_DEFAULT_ADDRESS);
        clickToElement(driver, AccountSettingPageUI.DELETE_DEFAULT_ADDRESS);
    }

    public boolean isRemoveAddressDisplayed() {
        waitForElementVisible(driver, AccountSettingPageUI.REMOVE_ADDRESS_POPUP);
        return isElementDisplayed(driver, AccountSettingPageUI.REMOVE_ADDRESS_POPUP);
    }

    public void clickChangeDefaultButton() {
        waitForElementClickable(driver, AccountSettingPageUI.CHANGE_DEFAULT_ADDRESS);
        clickToElement(driver, AccountSettingPageUI.CHANGE_DEFAULT_ADDRESS);
    }

    public boolean isChangeAddressPopupDisplayed() {
        waitForElementVisible(driver, AccountSettingPageUI.ADD_NEW_ADDRESS_POPUP);
        return isElementDisplayed(driver, AccountSettingPageUI.ADD_NEW_ADDRESS_POPUP);
    }

    public void clickChangeButtonAtChangeAddressPopup() {
        waitForElementClickable(driver, AccountSettingPageUI.CHANGE_BUTTON_AT_CHANGE_ADDRESS_POPUP);
        clickToElement(driver, AccountSettingPageUI.CHANGE_BUTTON_AT_CHANGE_ADDRESS_POPUP);
        sleepInSecond(3);
    }


    public boolean isAddressUndisplayed(WebDriver driver, String fullNameAuto) {
        refreshCurrentPage(driver);
        return isElementUnDisplayed(driver, AccountSettingPageUI.ADDRESS_DISPLAY_AFTER_DELETE, fullNameAuto);
    }

    public boolean isRemoveAddressUndisplayed() {
        return isElementUnDisplayed(driver, AccountSettingPageUI.REMOVE_ADDRESS_POPUP);
    }


    public void clickDeleteButton() {
        waitForElementClickable(driver, AccountSettingPageUI.DELETE_BUTTON);
        clickToElement(driver, AccountSettingPageUI.DELETE_BUTTON);
    }

    public void clickChangeButtonAfterChangeState(WebDriver driver, String fullNameAuto) {
        refreshCurrentPage(driver);
        scrollToElement(driver, AccountSettingPageUI.CHANGE_BUTTON_AFTER_CHANGE_STATE, fullNameAuto);
        waitForElementClickable(driver, AccountSettingPageUI.CHANGE_BUTTON_AFTER_CHANGE_STATE, fullNameAuto);
        clickToElement(driver, AccountSettingPageUI.CHANGE_BUTTON_AFTER_CHANGE_STATE, fullNameAuto);
    }

    public void clickDeleteButtonAfterChangeState(WebDriver driver, String fullName) {
        // waitForElementInvisible(driver, AccountSettingPageUI.REMOVE_ADDRESS_POPUP);
        waitForElementClickable(driver, AccountSettingPageUI.DELETE_ADDRESS_AFTER_CHANGE_STATE, fullName);
        clickToElement(driver, AccountSettingPageUI.DELETE_ADDRESS_AFTER_CHANGE_STATE, fullName);

    }
}
