package pageObjects.gossby;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.gossby.TrackOrderPageUI;

import java.time.Duration;

import static pageObjects.gossby.ShoppingCartPageObject.roundDown;

public class TrackOderPageObject extends BasePage {
    WebDriver driver;

    public TrackOderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getGuaranteedDateDelivery() {
        waitForElementClickable(driver, TrackOrderPageUI.GURANTEED_DELIVERY_DATE);
        clickToElement(driver, TrackOrderPageUI.GURANTEED_DELIVERY_DATE);
        return getElementText(driver, TrackOrderPageUI.GURANTEED_DELIVERY_DATE);
    }

    public boolean isProductNameDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.PRODUCT_NAME);
        return isElementDisplayed(driver, TrackOrderPageUI.PRODUCT_NAME);
    }

    public String isProductPriceDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.PRODUCT_PRICE);
        System.out.println("Track Order Price " + getElementText(driver, TrackOrderPageUI.PRODUCT_PRICE));
        return getElementText(driver, TrackOrderPageUI.PRODUCT_PRICE);
    }

    public String getProductTypeDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.PRODUCT_TYPE);
        return getElementText(driver, TrackOrderPageUI.PRODUCT_TYPE);
    }

    public int getProductQuantityDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.PRODUCT_QUANTITY);
        String quantityTrack = getElementText(driver, TrackOrderPageUI.PRODUCT_QUANTITY);
        String[] parts = quantityTrack.split("\\s+");
        // Chuyển đổi phần tử đầu tiên thành số nguyên
        int quantity = Integer.parseInt(parts[0]);
        return quantity;
        //return getElementText(driver, TrackOrderPageUI.PRODUCT_QUANTITY);
    }

    public void clickToEditDesignButton() {
        waitForElementClickable(driver, TrackOrderPageUI.EDIT_DESIGN_BUTTON);
        clickToElement(driver, TrackOrderPageUI.EDIT_DESIGN_BUTTON);
    }

    public String isTaxPriceDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.TAX_UI);
        return getElementText(driver, TrackOrderPageUI.TAX_UI);
    }

    public String isTipPriceDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.TIP_UI);
        System.out.println(getElementText(driver, TrackOrderPageUI.TIP_UI));
        return getElementText(driver, TrackOrderPageUI.TIP_UI);
    }

    public String isShippingPriceDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.SHIPPING_UI);
        System.out.println("Track Order: " + getElementText(driver, TrackOrderPageUI.SHIPPING_UI));
        return getElementText(driver, TrackOrderPageUI.SHIPPING_UI);
    }

    public String isPromoPriceDisplayed() {
        var subtotal = getElementText(driver, TrackOrderPageUI.SUBTOTAL_UI);
        String subtotalString = subtotal.replaceAll("[^\\d.]", "");
        double subtotalDouble = Double.parseDouble(subtotalString);
        double applyCode = roundDown(subtotalDouble * 0.1, 2);

        return "- $" + applyCode + " USD";

    }

    public String isSubtotalPriceDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.SUBTOTAL_UI);
        return getElementText(driver, TrackOrderPageUI.SUBTOTAL_UI);
    }

    public boolean isEditCampaignDesignPopupDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.EDIT_DESIGN_POPUP);
        return isElementDisplayed(driver, TrackOrderPageUI.EDIT_DESIGN_POPUP);
    }

    public void selectHairValueInDropDown(String itemValue) {
        waitForElementClickable(driver, TrackOrderPageUI.DYNAMIC_DROPDOWN_BY_NAME);
        selectItemDefaultDropdown(driver, TrackOrderPageUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue);
    }

    public void clickDynamicOptionByText(WebDriver driver, String text) {

        String xpath = TrackOrderPageUI.OPTION_BY_DYNAMIC_FIELD;
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        WebElement element = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        clickToElement(driver, String.valueOf(element), text);
//
//        String xpath = TrackOrderPageUI.OPTION_BY_DYNAMIC_FIELD;
//        scrollToElement(driver, TrackOrderPageUI.OPTION_BY_DYNAMIC_FIELD);
//        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
//        WebElement element = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//        element.click();
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//        waitForElementClickable(driver, xpath, optionText);


    }

    public void inputToNameTextbox(String name) {
        waitForElementVisible(driver, TrackOrderPageUI.NAME_TEXTBOX);
        sendkeyToElement(driver, TrackOrderPageUI.NAME_TEXTBOX, name);
    }

    public void clickToButtonByTextValue(WebDriver driver, String buttonText) {
        String xpath = TrackOrderPageUI.BUTTON_TEXT;

        waitForElementClickable(driver, TrackOrderPageUI.BUTTON_TEXT, buttonText);
        clickToElement(driver, TrackOrderPageUI.BUTTON_TEXT, buttonText);
    }


    public void clickCatColorOption() {
        scrollToElement(driver, TrackOrderPageUI.CAT_COLOR);
        waitForElementClickable(driver, TrackOrderPageUI.CAT_COLOR);
        clickToElement(driver, TrackOrderPageUI.CAT_COLOR);
    }

    public void clickExpressionOption() {
        scrollToElement(driver, TrackOrderPageUI.EXPRESSION);
        waitForElementClickable(driver, TrackOrderPageUI.EXPRESSION);
        clickToElement(driver, TrackOrderPageUI.EXPRESSION);
    }

    public void clickCatShirtOption() {
        scrollToElement(driver, TrackOrderPageUI.CAT_SHIRT);
        waitForElementClickable(driver, TrackOrderPageUI.CAT_SHIRT);
        clickToElement(driver, TrackOrderPageUI.CAT_SHIRT);
    }

    public String isContactInfoDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.CONTACT_INFO);
        return getElementText(driver, TrackOrderPageUI.CONTACT_INFO);
    }

    public String isShippingAddressByIndexDisplayed(WebDriver driver, String i) {
        waitForElementVisible(driver, TrackOrderPageUI.SHIPPING_ADDRESS_INDEX, i);
        return getElementText(driver, TrackOrderPageUI.SHIPPING_ADDRESS_INDEX, i);
    }


    public void clickToUpdateDesignButton() {
        waitForElementClickable(driver, TrackOrderPageUI.UPDATE_BUTTON);
        clickToElement(driver, TrackOrderPageUI.UPDATE_BUTTON);
        waitForAlertPresence(driver);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public void clickToClosePopup() {
        waitForElementClickable(driver, TrackOrderPageUI.CLOSE_POPUP);
        clickToElement(driver, TrackOrderPageUI.CLOSE_POPUP);
    }

    public String getGuaranteedPriceDelivery() {
        waitForElementVisible(driver, TrackOrderPageUI.GURANTEED_DELIVERY_PRICE);
        String guaranteed = getElementText(driver, TrackOrderPageUI.GURANTEED_DELIVERY_PRICE);
        String foundPrice = ""; // Biến để lưu trữ giá trị chứa "$"

        String[] parts = guaranteed.split(" ");

        // Lặp qua các phần tử để tìm phần có chứa "$"
        for (String part : parts) {
            if (part.contains("$")) {
                foundPrice = part;
                System.out.println("Kết quả: " + foundPrice);
                break; // Sau khi tìm thấy, thoát vòng lặp
            }
        }
        return foundPrice;
    }

    public String getShippingMethodDelivery() {
        waitForElementVisible(driver, TrackOrderPageUI.SHIPPING_METHOD);
        return getElementText(driver, TrackOrderPageUI.SHIPPING_METHOD);
    }

    public boolean isEditOrderPopupDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.EDIT_ORDER_POPUP);
        return isElementDisplayed(driver, TrackOrderPageUI.EDIT_ORDER_POPUP);
    }

    public boolean isEditOrderPopupUndisplayed() {
        return isElementUnDisplayed(driver, TrackOrderPageUI.EDIT_ORDER_POPUP);
    }

    public void inputToDynamicTextboxByName(WebDriver driver, String textboxName, String value) {
        waitForElementVisible(driver, TrackOrderPageUI.INPUT_DYNAMIC_TEXTBOX_BY_NAME, textboxName);
        sendkeyToElement(driver, TrackOrderPageUI.INPUT_DYNAMIC_TEXTBOX_BY_NAME, value, textboxName);
    }

    public boolean isOrderEditedSuccessfullyMessageDisplayed(String message) {
        scrollToElement(driver, TrackOrderPageUI.ORDER_EDITED_OR_CANCELLED_SUCCESSFULLY_MESSAGE);
        waitForElementVisible(driver, TrackOrderPageUI.ORDER_EDITED_OR_CANCELLED_SUCCESSFULLY_MESSAGE, message);
        return isElementDisplayed(driver, TrackOrderPageUI.ORDER_EDITED_OR_CANCELLED_SUCCESSFULLY_MESSAGE, message);
    }

    public boolean isCancelOrderPopupDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.CANCEL_ORDER_DIALOG);
        return isElementDisplayed(driver, TrackOrderPageUI.CANCEL_ORDER_DIALOG);
    }

    public void selectReasonInDropdown(WebDriver driver, String value) {
        waitForElementClickable(driver, TrackOrderPageUI.REASON_DROPDOWN);
        selectItemInDefaultDropdown(driver, TrackOrderPageUI.REASON_DROPDOWN, value);

    }

    public boolean isCancelOrderPopupUndisplayed() {
        return isElementUnDisplayed(driver, TrackOrderPageUI.CANCEL_ORDER_DIALOG);
    }

    public boolean isCancelOrderSuccessfullyMessageDisplayed(String message) {
        waitForElementVisible(driver, TrackOrderPageUI.ORDER_EDITED_OR_CANCELLED_SUCCESSFULLY_MESSAGE, message);
        return isElementDisplayed(driver, TrackOrderPageUI.ORDER_EDITED_OR_CANCELLED_SUCCESSFULLY_MESSAGE, message);
    }

    public void clickToTrackOrderButton() {
        waitForElementClickable(driver, TrackOrderPageUI.TRACK_ORDER_BUTTON);
        clickToElement(driver, TrackOrderPageUI.TRACK_ORDER_BUTTON);
    }

    public boolean isErrorsMessageAtDynamicFieldByNameDisplayed(WebDriver driver, String name, String message) {
        waitForElementVisible(driver, TrackOrderPageUI.ERROR_MESSAGE, name, message);
        return isElementDisplayed(driver, TrackOrderPageUI.ERROR_MESSAGE, name, message);
    }

    public String isTrackOrderIDDisplayed() {
        waitForElementVisible(driver, TrackOrderPageUI.TRACK_ORDER_ID);
        return getElementText(driver, TrackOrderPageUI.TRACK_ORDER_ID);
    }

    public boolean isSorryMessageDisplayed(String message) {
        waitForElementVisible(driver, TrackOrderPageUI.SORRY_MESSAGE, message);
        return isElementDisplayed(driver, TrackOrderPageUI.SORRY_MESSAGE, message);
    }

    public boolean isOderCanceledMessageDisplayed(String message) {
        waitForElementVisible(driver, TrackOrderPageUI.ORDER_CANCELED_MESSAGE, message);
        return isElementDisplayed(driver, TrackOrderPageUI.ORDER_CANCELED_MESSAGE, message);
    }

    public HomePageObject clickToContinueShopping() {
        waitForElementClickable(driver, TrackOrderPageUI.CONTINUE_SHOPPING_LINK);
        clickToElement(driver, TrackOrderPageUI.CONTINUE_SHOPPING_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }
}
