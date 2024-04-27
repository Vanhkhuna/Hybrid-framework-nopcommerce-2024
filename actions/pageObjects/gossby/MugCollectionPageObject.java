package pageObjects.gossby;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.gossby.MugPageUI;

public class MugCollectionPageObject extends BasePage {
    WebDriver driver;

    public MugCollectionPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProductByTitle() {
        scrollToElement(driver, MugPageUI.PRODUCT_TITLE);
        waitForElementClickable(driver, MugPageUI.PRODUCT_TITLE);
        clickToElement(driver, MugPageUI.PRODUCT_TITLE);
    }

    public boolean isProductNameDisplayed(String name) {
        waitForElementVisible(driver, MugPageUI.PRODUCT_NAME);
        return isElementDisplayed(driver, MugPageUI.PRODUCT_NAME, name);
    }

    public boolean isProductPriceDisplayed(String price) {
        waitForElementVisible(driver, MugPageUI.PRODUCT_PRICE);
        return isElementDisplayed(driver, MugPageUI.PRODUCT_PRICE, price);
    }

    public ShoppingCartPageObject clickToAddToCartButton() {
        waitForElementClickable(driver, MugPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, MugPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }

    public void clickNumberGirl() {
        waitForElementClickable(driver, MugPageUI.NUMBER_GIRL);
        clickToElement(driver, MugPageUI.NUMBER_GIRL);
    }

    public void inputToNameTextboxByText(WebDriver driver, String textbox, String name) {
        waitForElementVisible(driver, MugPageUI.NAME_GIRL, textbox);
        sendkeyToElement(driver, MugPageUI.NAME_GIRL, name, textbox);
    }
}
