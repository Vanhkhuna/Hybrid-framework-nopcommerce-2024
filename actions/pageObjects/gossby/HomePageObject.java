package pageObjects.gossby;

import commons.BasePage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pageUIs.gossby.HomePageUI;

import javax.swing.*;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSigninButton() {
        waitForElementClickable(driver, HomePageUI.SIGNIN_BUTTON);
        clickToElement(driver, HomePageUI.SIGNIN_BUTTON);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, HomePageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, HomePageUI.SUBMIT_BUTTON);
        clickToElement(driver, HomePageUI.SUBMIT_BUTTON);
    }

    public void clickToChangeCountryButton() {
        waitForElementClickable(driver, HomePageUI.CHANGE_COUNTRY_BUTTON);
        clickToElementByJS(driver, HomePageUI.CHANGE_COUNTRY_BUTTON);
    }


    public void clickSaveButton() {
        waitForElementClickable(driver, HomePageUI.SAVE_BUTTON);
        clickToElementByJS(driver, HomePageUI.SAVE_BUTTON);
    }

    public void clickToCountry() {
        waitForElementClickable(driver, HomePageUI.DROPDOWN);
        clickToElementByJS(driver, HomePageUI.DROPDOWN);
        waitForElementClickable(driver, HomePageUI.DROPDOWN_CONTRIBUTE);
        clickToElementByJS(driver, HomePageUI.DROPDOWN_CONTRIBUTE);
    }

    public MugCollectionPageObject openMugCollectionPage() {
//        scrollToElement(driver, HomePageUI.MUG_COLLECTION_LINK);
//        clickToElement(driver, HomePageUI.MUG_COLLECTION_LINK);
        try {
            // Locate the element
            WebElement element = getWebElement(driver, HomePageUI.MUG_COLLECTION_LINK);
            // Interact with the element
            element.click();
        } catch (StaleElementReferenceException e) {
            // If StaleElementReferenceException is caught, re-find the element and try again
            WebElement element = getWebElement(driver, HomePageUI.MUG_COLLECTION_LINK);
            element.click();
        }
        return PageGeneratorManager.getMugCollectionPage(driver);
    }
}
