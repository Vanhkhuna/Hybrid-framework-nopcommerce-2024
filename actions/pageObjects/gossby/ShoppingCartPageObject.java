package pageObjects.gossby;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.gossby.ShoppingCartUI;

import java.time.Duration;

public class ShoppingCartPageObject extends BasePage {
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplayed(String title1) {
        waitForElementVisible(driver, ShoppingCartUI.PRODUCT_NAME, title1);
        return isElementDisplayed(driver, ShoppingCartUI.PRODUCT_NAME, title1);
    }

    public boolean isProductPriceDisplayed(String price1) {
        waitForElementVisible(driver, ShoppingCartUI.PRODUCT_PRICE, price1);
        return isElementDisplayed(driver, ShoppingCartUI.PRODUCT_PRICE, price1);
    }

    public boolean isAlertMessageDisplayed(String message) {
        waitForElementVisible(driver, ShoppingCartUI.ADDED_PRODUCT_TO_YOUR_CART, message);
        return isElementDisplayed(driver, ShoppingCartUI.ADDED_PRODUCT_TO_YOUR_CART, message);
    }

    public boolean waitForImageCartLoadingInvisible() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='cart-loading']")));
    }

    public String getQuanityProductInCartDisplayed() {
        waitForElementVisible(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var cartString = getElementText(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var number = cartString.substring(cartString.indexOf("(") + 1, cartString.indexOf(")"));
        return number;
    }

    public String getQuanityProductInCart() {
        waitForElementVisible(driver, ShoppingCartUI.QUANITY_PRODUCT_IN_CART);
        return getElementText(driver, ShoppingCartUI.QUANITY_PRODUCT_IN_CART);
    }

    public void clickToPlusButton() {
        waitForElementClickable(driver, ShoppingCartUI.PLUS_BUTTON);
        clickToElement(driver, ShoppingCartUI.PLUS_BUTTON);
    }

    public void clickToRemoveButton() {
        waitForElementClickable(driver, ShoppingCartUI.REMOVE_BUTTON);
        clickToElement(driver, ShoppingCartUI.REMOVE_BUTTON);
        waitForElementClickable(driver, ShoppingCartUI.REMOVE_BUTTON_IN_DIALOG);
        clickToElement(driver, ShoppingCartUI.REMOVE_BUTTON_IN_DIALOG);
    }

    public boolean isCartEmptyMessageDisplayed(String message) {
        waitForElementVisible(driver, ShoppingCartUI.CART_EMPTY_MESSAGE, message);
        return isElementDisplayed(driver, ShoppingCartUI.CART_EMPTY_MESSAGE, message);
    }


}
