package pageObjects.gossby;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.gossby.ProductPageUI;
import pageUIs.gossby.ShoppingCartUI;

import java.time.Duration;
import java.util.List;

public class ProductObject extends BasePage {
    WebDriver driver;

    public ProductObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSigninButton() {
        waitForElementClickable(driver, ProductPageUI.SIGNIN_BUTTON);
        clickToElement(driver, ProductPageUI.SIGNIN_BUTTON);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, ProductPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, ProductPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, ProductPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ProductPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, ProductPageUI.SUBMIT_BUTTON);
        clickToElement(driver, ProductPageUI.SUBMIT_BUTTON);
    }

    public void clickToChangeCountryButton() {
        waitForElementClickable(driver, ProductPageUI.CHANGE_COUNTRY_BUTTON);
        clickToElementByJS(driver, ProductPageUI.CHANGE_COUNTRY_BUTTON);
    }


    public void clickSaveButton() {
        waitForElementClickable(driver, ProductPageUI.SAVE_BUTTON);
        clickToElementByJS(driver, ProductPageUI.SAVE_BUTTON);
    }

    public void clickToCountry() {
        try {
            waitForElementClickable(driver, ProductPageUI.DROPDOWN);
            clickToElement(driver, ProductPageUI.DROPDOWN);
            waitForElementClickable(driver, ProductPageUI.DROPDOWN_CONTRIBUTE);
            clickToElement(driver, ProductPageUI.DROPDOWN_CONTRIBUTE);
        } catch (UnhandledAlertException e) {

            Alert alert = driver.switchTo().alert();
            alert.dismiss();

        }
    }

    public boolean isProductNameDisplayed(String name) {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_NAME, name);
        return isElementDisplayed(driver, ProductPageUI.PRODUCT_NAME, name);
    }

    public boolean isProductPriceDisplayed(String price) {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_PRICE, price);
        return isElementDisplayed(driver, ProductPageUI.PRODUCT_PRICE, price);
    }

    public void selectHairValueInDropDown(String itemValue) {
        waitForElementClickable(driver, ProductPageUI.DYNAMIC_DROPDOWN_BY_NAME);
        selectItemDefaultDropdown(driver, ProductPageUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue);

    }

    public ShoppingCartPageObject clickToAddToCartButton() {
        scrollToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON);
        waitForElementClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    public void clickCloseButtonInPopup() {
        List<WebElement> popups = driver.findElements(By.xpath("//div[@aria-label='POPUP Form']"));
        if (!popups.isEmpty()) {
            waitForElementClickable(driver, ProductPageUI.CLOSE_BUTTON_IN_POPUP);
            clickToElement(driver, ProductPageUI.CLOSE_BUTTON_IN_POPUP);
        }

    }


    public String getPriceGift() {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_GIFT);
        return getElementText(driver, ProductPageUI.PRODUCT_GIFT);
    }
}

