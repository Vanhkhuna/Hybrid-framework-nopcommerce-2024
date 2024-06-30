package pageObjects.gossby;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.gossby.ShoppingCartUI;

import java.text.DecimalFormat;
import java.time.Duration;

import static java.lang.Math.round;


public class ShoppingCartPageObject extends BasePage {
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplayed(String title1) {
        scrollToElement(driver, ShoppingCartUI.PRODUCT_NAME);
        waitForElementVisible(driver, ShoppingCartUI.PRODUCT_NAME, title1);
        return isElementDisplayed(driver, ShoppingCartUI.PRODUCT_NAME, title1);
    }

    public String isProductPriceDisplayed() {
        waitForElementVisible(driver, ShoppingCartUI.PRODUCT_PRICE);
        System.out.println(getElementText(driver, ShoppingCartUI.PRODUCT_PRICE));
        return getElementText(driver, ShoppingCartUI.PRODUCT_PRICE);
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


    public String getTotalProductPriceUIDisplayed() {
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

    public void clickToCountry(WebDriver driver,
                               String country) {
        String parentXPATH = ShoppingCartUI.CHANGE_COUNTRY_DROPDOWN;
        String childXpath = ShoppingCartUI.CHOOSE_COUNTRY;
        selectItemInCustomDropdown(driver, parentXPATH, childXpath, country);

    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, ShoppingCartUI.SAVE_BUTTON);
        clickToElement(driver, ShoppingCartUI.SAVE_BUTTON);
    }

    public String isCountryChangedDisplayed() {
        waitForElementVisible(driver, ShoppingCartUI.COUNTRY_AFTER_CHANGED_DISPLAYED);
        return getElementText(driver, ShoppingCartUI.COUNTRY_AFTER_CHANGED_DISPLAYED);
    }

    public void clickToPlusButton() {
        scrollToElement(driver, ShoppingCartUI.PLUS_BUTTON);
        waitForElementClickable(driver, ShoppingCartUI.PLUS_BUTTON);
        clickToElement(driver, ShoppingCartUI.PLUS_BUTTON);
        sleepInSecond(3);
    }

    public String getProductUpdateMessageDisplayed() {
        waitForElementVisible(driver, ShoppingCartUI.PRODUCT_UPDATED_MESSAGE);
        return getElementText(driver, ShoppingCartUI.PRODUCT_UPDATED_MESSAGE);
    }


    public String isTotalExpectedDisplayed() {
        WebElement productPriceOriginal = getWebElement(driver, ShoppingCartUI.PRODUCT_PRICE_ORIGINAL);
        // WebElement priceGiftOriginal = getWebElement(driver, ShoppingCartUI.PRICE_GIFT);
        waitForElementVisible(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var cartString = getElementText(driver, ShoppingCartUI.QUANITY_SHOPPING_CART_DISPLAY);
        var number = cartString.substring(cartString.indexOf("(") + 1, cartString.indexOf(")"));
        int productQuantityElement = Integer.parseInt(number);
        String priceString = productPriceOriginal.getText().replaceAll("[^\\d.]", "");
        //String priceGiftString = priceGiftOriginal.getText().replaceAll("[^\\d.]", "");
        double priceDouble = Double.parseDouble(priceString);
        // double priceGiftDouble = Double.parseDouble(priceGiftString);
        double subtotal = productQuantityElement * priceDouble;
        //double subtotal = productQuantityElement * (priceDouble + priceGiftDouble);
//        DecimalFormat df = new DecimalFormat("#.##");
//        String formattedSubtotal = df.format(subtotal);
//
//        System.out.println("shopping expect " + formattedSubtotal);
        return "$" + subtotal + " USD";

    }


    public String isPriceActualUIDisplayed() {
        scrollToElement(driver, ShoppingCartUI.TOTAL_PRICE);
        waitForElementVisible(driver, ShoppingCartUI.TOTAL_PRICE);
        System.out.println("shopping UI" + getElementText(driver, ShoppingCartUI.TOTAL_PRICE));
        return getElementText(driver, ShoppingCartUI.TOTAL_PRICE);
    }

    public void clickToApplyButton() {
        waitForElementClickable(driver, ShoppingCartUI.APPLY_BUTTON);
        clickToElement(driver, ShoppingCartUI.APPLY_BUTTON);
    }

    public void inputDiscountCodeToTextbox(String discountCode) {
        waitForElementVisible(driver, ShoppingCartUI.PROMO_CODE_TEXTBOX);
        clearValueInElementByPressKey(driver, ShoppingCartUI.PROMO_CODE_TEXTBOX);
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
        double applyCode = roundDown(subtotal * 0.1, 2);
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
        double applyCode = roundDown(subtotal * 0.1, 2);

        return applyCode;
    }

    public double isDiscountPriceActual() {
        WebElement discountPriceOriginal = getWebElement(driver, ShoppingCartUI.DISCOUNT_PRICE);
        String priceString = discountPriceOriginal.getText().replaceAll("[^0-9.]", "");
        double priceDouble = Double.parseDouble(priceString);
        return priceDouble;
    }


    public CheckoutPageObject clickToSecureCheckoutButton() {
        waitForElementClickable(driver, ShoppingCartUI.SECURE_CHECKOUT);
        clickToElement(driver, ShoppingCartUI.SECURE_CHECKOUT);
        return PageGeneratorManager.getCheckoutPage(driver);
    }

    public boolean isCountryNotSupportMessageDisplayed(String message) {
        waitForElementVisible(driver, ShoppingCartUI.COUNTRY_NOT_SUPPORT_MESSAGE, message);
        return isElementDisplayed(driver, ShoppingCartUI.COUNTRY_NOT_SUPPORT_MESSAGE, message);
    }


    public boolean isProductNameDisplayed() {
        scrollToElement(driver, ShoppingCartUI.PRODUCT_NAME);
        waitForElementVisible(driver, ShoppingCartUI.PRODUCT_NAME);
        return isElementDisplayed(driver, ShoppingCartUI.PRODUCT_NAME);
    }

    public String getProductTypeDisplayed() {
        scrollToElement(driver, ShoppingCartUI.PRODUCT_TYPE);
        waitForElementVisible(driver, ShoppingCartUI.PRODUCT_TYPE);
        return getElementText(driver, ShoppingCartUI.PRODUCT_TYPE);
    }

    public int getProductQuantityDisplayed() {
        scrollToElement(driver, ShoppingCartUI.PRODUCT_QUANTITY);
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Promo code:']/parent::div/preceding-sibling::div[1]")));
        String quantityShopping = getElementText(driver, ShoppingCartUI.PRODUCT_QUANTITY);
        int startIndex = quantityShopping.indexOf('(') + 1;
        // Tìm vị trí kết thúc của chuỗi số
        int endIndex = quantityShopping.indexOf(' ', startIndex);
        // Trích xuất phần số từ chuỗi
        String quantityString = quantityShopping.substring(startIndex, endIndex);
        // Chuyển đổi chuỗi số sang kiểu int
        return Integer.parseInt(quantityString);
        // return getElementText(driver, ShoppingCartUI.PRODUCT_QUANTITY);
    }

    public String getDiscountCodeAppliedMessageDisplayed() {
        waitForElementVisible(driver, ShoppingCartUI.DISCOUNT_CODE_APPLIED_MESSAGE);
        return getElementText(driver, ShoppingCartUI.DISCOUNT_CODE_APPLIED_MESSAGE);
    }

    public void clickToMinusButton() {
        waitForElementClickable(driver, ShoppingCartUI.MINUS_BUTTON);
        clickToElement(driver, ShoppingCartUI.MINUS_BUTTON);

    }


    public String getPriceGift() {
        waitForElementVisible(driver, ShoppingCartUI.PRICE_GIFT);
        return getElementText(driver, ShoppingCartUI.PRICE_GIFT);
    }
}
