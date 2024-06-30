package pageObjects.gossby;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.gossby.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToButtonByTitleText(WebDriver driver, String buttonTitle) {
        waitForElementClickable(driver, HomePageUI.SIGNIN_SIGNUP_BUTTON, buttonTitle);
        clickToElement(driver, HomePageUI.SIGNIN_SIGNUP_BUTTON, buttonTitle);

    }

    public void clickToCreateYourAccountButton() {
        waitForElementClickable(driver, HomePageUI.CREAT_YOUR_ACCOUNT_BUTTON);
        clickToElement(driver, HomePageUI.CREAT_YOUR_ACCOUNT_BUTTON);
    }


    public void inputToTextboxByID(WebDriver driver, String textbox, String value) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_FIELD, textbox);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_FIELD, value, textbox);
    }

    public boolean isVerificationEmailButtonByTextDisplayed(WebDriver driver, String buttonText) {
        waitForElementVisible(driver, HomePageUI.VERIFICATION_BUTTON, buttonText);
        return isElementDisplayed(driver, HomePageUI.VERIFICATION_BUTTON, buttonText);
    }

    public void clickToSigninLink() {
        waitForElementClickable(driver, HomePageUI.SIGN_IN_LINK);
        clickToElement(driver, HomePageUI.SIGN_IN_LINK);
    }

    public boolean isSignPopupDisplayed() {
        waitForElementVisible(driver, HomePageUI.VERIFICATION_BUTTON);
        return isElementDisplayed(driver, HomePageUI.VERIFICATION_BUTTON);
    }

    public boolean isErrorMessageAtEmailDisplayed(String message) {
        waitForElementVisible(driver, HomePageUI.ERROR_MESSAGE_AT_EMAIL_FIELD, message);
        return isElementDisplayed(driver, HomePageUI.ERROR_MESSAGE_AT_EMAIL_FIELD, message);
    }

    public boolean isErrorMessageAtPasswordDisplayed(String message) {
        waitForElementVisible(driver, HomePageUI.ERROR_MESSAGE_AT_PASSWORD_FIELD_SIGN_UP, message);
        return isElementDisplayed(driver, HomePageUI.ERROR_MESSAGE_AT_PASSWORD_FIELD_SIGN_UP, message);
    }

    public boolean isErrorMessageAtConfirmPasswordDisplayed(String message) {
        waitForElementVisible(driver, HomePageUI.ERROR_MESSAGE_AT_CONFIRM_FIELD_SIGN_UP, message);
        return isElementDisplayed(driver, HomePageUI.ERROR_MESSAGE_AT_CONFIRM_FIELD_SIGN_UP, message);
    }


    public void clickToSigninButton(WebDriver driver, String buttonText) {
        waitForElementClickable(driver, HomePageUI.VERIFICATION_BUTTON, buttonText);
        clickToElement(driver, HomePageUI.VERIFICATION_BUTTON, buttonText);
    }

    public boolean isErrorMessageAtEmailSigninDisplayed(String message) {
        waitForElementVisible(driver, HomePageUI.ERROR_MESSAGE_AT_EMAIL_FIELD_SIGN_IN, message);
        return isElementDisplayed(driver, HomePageUI.ERROR_MESSAGE_AT_EMAIL_FIELD_SIGN_IN, message);
    }

    public boolean isErrorMessageAtPasswordSigninDisplayed(String message) {
        waitForElementVisible(driver, HomePageUI.ERROR_MESSAGE_AT_PASS_FIELD_SIGN_IN, message);
        return isElementDisplayed(driver, HomePageUI.ERROR_MESSAGE_AT_PASS_FIELD_SIGN_IN, message);
    }

    public boolean isSignInPopupUnDisplayed() {
        return isElementUnDisplayed(driver, HomePageUI.SIGN_IN_POPUP);
    }

    public AccountSettingPageObject clickMyProfileButton() {
        waitForElementClickable(driver, HomePageUI.ACCOUNT_BUTTON);
        clickToElement(driver, HomePageUI.ACCOUNT_BUTTON);
        return PageGeneratorManager.getAccountSettingPage(driver);
    }
}
