package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreatNewAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREAT_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREAT_NEW_ACCOUNT_BUTTON);
    }

    public boolean isEmailAddressTextboxDisplayed() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
    }

    public boolean isConfirmEmailAddressTextboxDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }

    public void inputToEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void closeSignUpPopup() {
        waitForElementClickable(driver, LoginPageUI.SIGN_UP_POPUP);
        clickToElement(driver, LoginPageUI.SIGN_UP_POPUP);
    }


    public boolean isConfirmEmailAddressTextboxUndisplayed() {
        waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
        return isElementUnDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }
}
