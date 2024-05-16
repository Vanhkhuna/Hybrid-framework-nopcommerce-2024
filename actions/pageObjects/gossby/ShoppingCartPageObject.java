package pageObjects.gossby;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.gossby.ShoppingCartUI;

import java.time.Duration;

import static java.lang.Math.round;


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


    public void uncheckAddGiftPackCheckbox() {
        scrollToElement(driver, ShoppingCartUI.ADD_GIFT_PACK_CHECKBOX);
        clickToElement(driver, ShoppingCartUI.ADD_GIFT_PACK_CHECKBOX);
    }


    public String getTotalProductPriceDisplayed() {
        waitForElementVisible(driver, ShoppingCartUI.TOTAL_PRICE);
        return getElementText(driver, ShoppingCartUI.TOTAL_PRICE);
    }

    public void clickToChangeCountryLink() {
        waitForElementClickable(driver, ShoppingCartUI.CHANGE_COUNTRY_LINK);
        clickToElement(driver, ShoppingCartUI.CHANGE_COUNTRY_LINK);
    }

    public void clickToCountryDropdown() {
        waitForElementClickable(driver, ShoppingCartUI.CHANGE_COUNTRY_DROPDOWN);
        clickToElement(driver, ShoppingCartUI.CHANGE_COUNTRY_DROPDOWN);
    }

    public void clickToCountry(WebDriver driver, String country) {
        waitForElementClickable(driver, ShoppingCartUI.CHOOSE_COUNTRY, country);
        clickToElement(driver, ShoppingCartUI.CHOOSE_COUNTRY, country);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, ShoppingCartUI.SAVE_BUTTON);
        clickToElement(driver, ShoppingCartUI.SAVE_BUTTON);
    }

    public boolean isAddOnsGiftUndisplayed() {
        waitForElementUndisplayed(driver, ShoppingCartUI.ADD_ONS_GIFT_UNDISPLAYED);
        return isElementUnDisplayed(driver, ShoppingCartUI.ADD_ONS_GIFT_UNDISPLAYED);
    }

    public String isCountryChangedDisplayed() {
        waitForElementVisible(driver, ShoppingCartUI.COUNTRY_AFTER_CHANGED_DISPLAYED);
        return getElementText(driver, ShoppingCartUI.COUNTRY_AFTER_CHANGED_DISPLAYED);
    }

    public void clickToPlusButton() {
        waitForElementClickable(driver, ShoppingCartUI.PLUS_BUTTON);
        clickToElement(driver, ShoppingCartUI.PLUS_BUTTON);
    }

    public boolean isProductUpdateMessageDisplayed(String message) {
        waitForElementVisible(driver, ShoppingCartUI.PRODUCT_UPDATED_MESSAGE, message);
        return isElementDisplayed(driver, ShoppingCartUI.PRODUCT_UPDATED_MESSAGE, message);
    }

    public String isTotalExpectedDisplayed() {
        WebElement productPriceOriginal = getWebElement(driver, ShoppingCartUI.PRODUCT_PRICE_ORIGINAL);

        waitForElementVisible(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var cartString = getElementText(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var number = cartString.substring(cartString.indexOf("(") + 1, cartString.indexOf(")"));
        int productQuantityElement = Integer.parseInt(number);
        String priceString = productPriceOriginal.getText().replaceAll("[^\\d.]", "");
        double priceDouble = Double.parseDouble(priceString);
        double subtotal = productQuantityElement * priceDouble;
        System.out.println(subtotal);
        return "$" + subtotal + " USD";

    }


    public String isPriceActualUIDisplayed() {
        waitForElementVisible(driver, ShoppingCartUI.TOTAL_PRICE);
        System.out.println(getElementText(driver, ShoppingCartUI.TOTAL_PRICE));
        return getElementText(driver, ShoppingCartUI.TOTAL_PRICE);
    }

    public void clickToApplyButton() {
        waitForElementClickable(driver, ShoppingCartUI.APPLY_BUTTON);
        clickToElement(driver, ShoppingCartUI.APPLY_BUTTON);
    }

    public void inputDiscountCodeToTextbox(String discountCode) {
        waitForElementVisible(driver, ShoppingCartUI.PROMO_CODE_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartUI.PROMO_CODE_TEXTBOX, discountCode);
    }

    public String getErrorMessageDisplayed() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Apply']/preceding-sibling::div")));
        return getElementText(driver, ShoppingCartUI.ERROR_MESSAGE_DISPLAYED);
    }

    public String isTotalAfterApllyDiscountCodeExpected() {
        WebElement productPriceOriginal = getWebElement(driver, ShoppingCartUI.PRODUCT_PRICE_ORIGINAL);
        String priceString = productPriceOriginal.getText().replaceAll("[^\\d.]", "");
        double priceDouble = Double.parseDouble(priceString);

        waitForElementVisible(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var cartString = getElementText(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var number = cartString.substring(cartString.indexOf("(") + 1, cartString.indexOf(")"));
        int productQuantityElement = Integer.parseInt(number);

        double subtotal = productQuantityElement * priceDouble;
        double applyCode = roundDown(subtotal * 0.05, 2);
        double total = Math.round((subtotal - applyCode) * 100.0) / 100.0;
        System.out.println(subtotal);
        System.out.println(applyCode);
        System.out.println(total);

        return "$" + total + " USD";
    }

    public static double roundDown(double value, int decimalPlaces) {
        double factor = Math.pow(10, decimalPlaces);
        return Math.floor(value * factor) / factor;
    }


    public double isDiscountPriceExpected() {
        WebElement productPriceOriginal = getWebElement(driver, ShoppingCartUI.PRODUCT_PRICE_ORIGINAL);
        String priceString = productPriceOriginal.getText().replaceAll("[^\\d.]", "");
        double priceDouble = Double.parseDouble(priceString);

        waitForElementVisible(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var cartString = getElementText(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var number = cartString.substring(cartString.indexOf("(") + 1, cartString.indexOf(")"));
        int productQuantityElement = Integer.parseInt(number);

        double subtotal = productQuantityElement * priceDouble;
        double applyCode = roundDown(subtotal * 0.05, 2);

        return applyCode;
    }

    public double isDiscountPriceActual() {
        WebElement discountPriceOriginal = getWebElement(driver, ShoppingCartUI.DISCOUNT_PRICE);
        String priceString = discountPriceOriginal.getText().replaceAll("[^0-9.]", "");
        double priceDouble = Double.parseDouble(priceString);
        return priceDouble;
    }
}


//dẩy code_2