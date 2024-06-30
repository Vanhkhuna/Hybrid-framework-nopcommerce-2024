package pageObjects.gossby;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.gossby.CheckoutPageUI;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


import static pageObjects.gossby.ShoppingCartPageObject.roundDown;

public class CheckoutPageObject extends BasePage {
    WebDriver driver;

    public CheckoutPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToPlaceYourOrderButton() {
        waitForElementClickable(driver, CheckoutPageUI.PLACE_YOUR_ORDER_BUTTON);
        scrollToElement(driver, CheckoutPageUI.PLACE_YOUR_ORDER_BUTTON);
        clickToElementByJS(driver, CheckoutPageUI.PLACE_YOUR_ORDER_BUTTON);
    }

    public boolean isErrorMessageAtEmailAddressFieldDisplayed(String message) {
        scrollToElement(driver, CheckoutPageUI.ERROR_MESSAGE_AT_EMAIL_ADDRESS_FIELD);
        waitForElementVisible(driver, CheckoutPageUI.ERROR_MESSAGE_AT_EMAIL_ADDRESS_FIELD, message);
        return isElementDisplayed(driver, CheckoutPageUI.ERROR_MESSAGE_AT_EMAIL_ADDRESS_FIELD, message);
    }

    public boolean isErrorMessageAtPhoneFieldDisplayed(String message) {
        waitForElementVisible(driver, CheckoutPageUI.ERROR_MESSAGE_AT_PHONE_FIELD, message);
        return isElementDisplayed(driver, CheckoutPageUI.ERROR_MESSAGE_AT_PHONE_FIELD, message);
    }

    public boolean getErrorMessageAtDynamicFieldByIdDisplayed(WebDriver driver, String id) {
        waitForElementVisible(driver, CheckoutPageUI.ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_ID, id);
        return isElementDisplayed(driver, CheckoutPageUI.ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_ID, id);
    }

    public void inputToDynamicTextboxByName(WebDriver driver, String textboxByName, String value) {
        clickToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxByName);
        waitForAllElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxByName);
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_NAME, value, textboxByName);
    }

    public void selectProvinceInDropdown(String value) {
        waitForElementClickable(driver, CheckoutPageUI.PROVINCE_DROPDOWN);
        selectItemDropdown(driver, CheckoutPageUI.PROVINCE_DROPDOWN, value);
    }

    public boolean isErrorMessageAtProvinceFieldDisplayed(String message) {
        waitForElementVisible(driver, CheckoutPageUI.ERROR_MESSAGE_AT_PROVINCE_FIELD, message);
        return isElementDisplayed(driver, CheckoutPageUI.ERROR_MESSAGE_AT_PROVINCE_FIELD, message);
    }

    public boolean waitForProcessingScreenInvisible() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.w-screen")));
    }

    public boolean isErrorMessageAtCardFieldDisplayed(String message) {
        scrollToElement(driver, CheckoutPageUI.ERROR_MESSAGE_AT_CARD_FIELD);
        waitForElementVisible(driver, CheckoutPageUI.ERROR_MESSAGE_AT_CARD_FIELD, message);
        return isElementDisplayed(driver, CheckoutPageUI.ERROR_MESSAGE_AT_CARD_FIELD, message);
    }

    public void inputToCardTextbox(String value) {
        switchToFrameIframe(driver, CheckoutPageUI.IFRAME_ELEMENT);
        waitForElementClickable(driver, CheckoutPageUI.CARD_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.CARD_TEXTBOX, value);
        switchToDefaultContent(driver);
    }

    public void inputToExpiredDateTextbox(String value) {
        switchToFrameIframe(driver, CheckoutPageUI.IFRAME_ELEMENT);
        waitForElementClickable(driver, CheckoutPageUI.EXPIRED_DATE_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.EXPIRED_DATE_TEXTBOX, value);
        switchToDefaultContent(driver);
    }


    public void inputToCVCTextbox(String value) {
        switchToFrameIframe(driver, CheckoutPageUI.IFRAME_ELEMENT);
        waitForElementClickable(driver, CheckoutPageUI.CVC_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.CVC_TEXTBOX, value);
        switchToDefaultContent(driver);
    }

    public boolean isCheckoutSuccessfullyDisplayed(String message) {
        waitForElementVisible(driver, CheckoutPageUI.CHECKOUT_SUCCESSFULLY_MESSAGE, message);
        return isElementDisplayed(driver, CheckoutPageUI.CHECKOUT_SUCCESSFULLY_MESSAGE, message);
    }

    public boolean isProductNameDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.PRODUCT_NAME);
        return isElementDisplayed(driver, CheckoutPageUI.PRODUCT_NAME);
    }

    public String getProductTypeDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.PRODUCT_TYPE);
        return getElementText(driver, CheckoutPageUI.PRODUCT_TYPE);
    }

    public int getProductQuantityDisplayed() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shipping:']/parent::div/preceding-sibling::div[2]")));
        String quantityCheckout = getElementText(driver, CheckoutPageUI.PRODUCT_QUANTITY_COMPARE);
        int startIndex = quantityCheckout.indexOf('(') + 1;
        // Tìm vị trí kết thúc của chuỗi số
        int endIndex = quantityCheckout.indexOf(' ', startIndex);
        // Trích xuất phần số từ chuỗi
        String quantityString = quantityCheckout.substring(startIndex, endIndex);
        // Chuyển đổi chuỗi số sang kiểu int
        return Integer.parseInt(quantityString);
        // return getElementText(driver, CheckoutPageUI.PRODUCT_QUANTITY_COMPARE);
    }


    public boolean isShippingCountryDisplayed() {
        scrollToElement(driver, CheckoutPageUI.SHIPPING_COUNTRY);
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_COUNTRY);
        return isElementDisplayed(driver, CheckoutPageUI.SHIPPING_COUNTRY);
    }

    public boolean isStandardShippingSelected() {
        return getWebElement(driver, CheckoutPageUI.STANDARD_SHIPPING_CHECKBOX).isSelected();
    }

    public String isTaxPriceActualUIDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.TAX_PRICE_UI);
        System.out.println(getElementText(driver, CheckoutPageUI.TAX_PRICE_UI));
        return getElementText(driver, CheckoutPageUI.TAX_PRICE_UI);
    }

    public String isTaxPriceExpectedDisplayed() {
        String subtotalString = getElementText(driver, CheckoutPageUI.SUBTOTAL_PRICE);
        String subtotalPrice = subtotalString.substring(1, subtotalString.indexOf(" "));
        double subtotalValue = Double.parseDouble(subtotalPrice);

        double promoCode = roundDown(subtotalValue * 0.1, 2);

        String ShippingString = getElementText(driver, CheckoutPageUI.SHIPPING);
        String[] parts = ShippingString.split(" ");
        String numericPart = parts[0].replaceAll("[^\\d.]", "");
        double ShippingValue = Double.parseDouble(numericPart);

        double taxPrice = 0.2 * (subtotalValue - promoCode + ShippingValue);
        double roundedNumber = roundDown(taxPrice, 2);
        System.out.println(roundedNumber);
        return "$" + roundedNumber + " USD";

    }

    public void clickToTipOption() {
        waitForElementClickable(driver, CheckoutPageUI.TIP_OPTION);
        clickToElement(driver, CheckoutPageUI.TIP_OPTION);
    }

    public String isTipActualUIDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.TIP_UI);
        return getElementText(driver, CheckoutPageUI.TIP_UI);
    }

    public String isTipExpectedDisplayed() {
        String subtotalString = getElementText(driver, CheckoutPageUI.SUBTOTAL_PRICE);
        String subtotalPrice = subtotalString.substring(1, subtotalString.indexOf(" "));
        double subtotalValue = Double.parseDouble(subtotalPrice);
        double subtotal = subtotalValue * 0.2;
        double tip = Math.round(subtotal * 100.0) / 100.0;
        DecimalFormat df = new DecimalFormat("0.00");

        String formattedTip = df.format(tip);
        return "$" + formattedTip + " USD";
    }

    public String isDiscountPriceExpected() {
        var productPriceOriginal = getElementText(driver, CheckoutPageUI.PRODUCT_PRICE_ORIGINAL);
        String priceString = productPriceOriginal.replaceAll("[^\\d.]", "");
        double priceDouble = Double.parseDouble(priceString);

        waitForElementVisible(driver, CheckoutPageUI.PRODUCT_QUANTITY);
        var cartString = getElementText(driver, CheckoutPageUI.PRODUCT_QUANTITY);
        String number = cartString.substring(1, cartString.indexOf(" "));
        int productQuantityElement = Integer.parseInt(number);

        double subtotal = productQuantityElement * priceDouble;
        double applyCode = roundDown(subtotal * 0.1, 2);

        return "- $" + applyCode + " USD";
    }

    public String isDiscountPriceActualUI() {
        waitForElementVisible(driver, CheckoutPageUI.DISCOUNT_UI);
        return getElementText(driver, CheckoutPageUI.DISCOUNT_UI);
    }

    public String isTotalPriceExpected() {
        String subtotalString = getElementText(driver, CheckoutPageUI.SUBTOTAL_PRICE);
        String subtotalPrice = subtotalString.substring(1, subtotalString.indexOf(" "));
        double subtotalValue = Double.parseDouble(subtotalPrice);
        System.out.println(subtotalValue);
        double promoCode = roundDown(subtotalValue * 0.1, 2);
        System.out.println(promoCode);
        String shippingString = getElementText(driver, CheckoutPageUI.SHIPPING);
        String shippingPrice = shippingString.substring(1, shippingString.indexOf(" "));
        double shippingValue = Double.parseDouble(shippingPrice);
        System.out.println(shippingValue);

        String taxString = getElementText(driver, CheckoutPageUI.TAX_PRICE_UI);
        String taxPrice = taxString.substring(1, taxString.indexOf(" "));
        double taxValue = Double.parseDouble(taxPrice);
        System.out.println(taxValue);
        String tipString = getElementText(driver, CheckoutPageUI.TIP_UI);
        String tipPrice = tipString.substring(1, tipString.indexOf(" "));
        double tipValue = Double.parseDouble(tipPrice);
        System.out.println(tipValue);
        double total = subtotalValue - promoCode + shippingValue + taxValue + tipValue;
        System.out.println(total);
        return "$" + total + " USD";
    }

    public String isTotalPriceActualUI() {
        waitForElementVisible(driver, CheckoutPageUI.TOTAL_UI);
        System.out.println("Checkout Price UI " + getElementText(driver, CheckoutPageUI.TOTAL_UI));
        return getElementText(driver, CheckoutPageUI.TOTAL_UI);
    }


    public String getGuaranteedDateDelivery() {
        String guaranteedDate = null; // Khai báo ở ngoài try-catch

        try {
            scrollToElement(driver, CheckoutPageUI.GUARANTEED_DELIVERY_DATE);
            waitForElementVisible(driver, CheckoutPageUI.GUARANTEED_DELIVERY_DATE);
            String guaranteedString = getElementText(driver, CheckoutPageUI.GUARANTEED_DELIVERY_DATE); // Tách chuỗi bằng từ "by"
            String[] parts = guaranteedString.split("by");

            // Lấy phần tử thứ hai sau khi tách chuỗi, loại bỏ khoảng trắng ở đầu và cuối chuỗi
            String guaranteed = parts[1].trim();
            // Định nghĩa định dạng của chuỗi ngày tháng đầu vào
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, EEEE", Locale.ENGLISH);
            // Định nghĩa định dạng của chuỗi ngày tháng đầu ra
            SimpleDateFormat sdfOutput = new SimpleDateFormat("EEE, MMM dd, yyyy", Locale.ENGLISH);

            // Phân tích chuỗi ngày tháng đầu vào thành đối tượng Date
            Date date = sdf.parse(guaranteed);
            // Tạo một đối tượng Calendar và đặt ngày tháng đã phân tích
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // Lấy năm hiện tại
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            // Đặt năm cho đối tượng Calendar
            calendar.set(Calendar.YEAR, currentYear);

            // Chuyển đổi đối tượng Calendar sang định dạng chuỗi mới
            guaranteedDate = sdfOutput.format(calendar.getTime());

            System.out.println("Kết quả: " + guaranteedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ ở đây nếu cần
        }
        System.out.println(guaranteedDate);
        return guaranteedDate; // Trả về giá trị được cập nhật
    }

    public String isShippingPriceActualUIDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING);
        System.out.println("Checkout: " + getElementText(driver, CheckoutPageUI.SHIPPING));
        return getElementText(driver, CheckoutPageUI.SHIPPING);
    }

    public String isSubtotalDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.SUBTOTAL_PRICE);
        return getElementText(driver, CheckoutPageUI.SUBTOTAL_PRICE);
    }

    public String isPromoDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.PROMO_CODE);
        return getElementText(driver, CheckoutPageUI.PROMO_CODE);
    }


    public String isPhoneDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.PHONE_COMPARE);
        return getElementText(driver, CheckoutPageUI.PHONE_COMPARE);
    }

    public String getGuaranteedPriceDelivery() {
        scrollToElement(driver, CheckoutPageUI.GUARANTEED_DELIVERY_PRICE);
        waitForElementVisible(driver, CheckoutPageUI.GUARANTEED_DELIVERY_PRICE);
        String price = getElementText(driver, CheckoutPageUI.GUARANTEED_DELIVERY_PRICE);
        String[] parts = price.split(" ");

        // Lấy phần tử đầu tiên sau khi tách chuỗi
        String priceValue = parts[0];

        // Kiểm tra xem phần đầu tiên có chứa ký tự "$" không
        if (priceValue.contains("$")) {
            System.out.println("Kết quả: " + priceValue);
        } else {
            System.out.println("Không tìm thấy giá trị có chứa '$'");
        }
        return priceValue;
    }

    public String getShippingMethodDisplayed() {
        waitForElementVisible(driver, CheckoutPageUI.GUARANTEED_DELIVERY_DATE);
        String shipping = getElementText(driver, CheckoutPageUI.GUARANTEED_DELIVERY_DATE);
        String[] parts = shipping.split(":");
        String shippingText = parts[0].trim();
        return shippingText;
    }
}
