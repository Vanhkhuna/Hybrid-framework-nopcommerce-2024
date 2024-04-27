package pageObjects.openCart;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUIs.openCartPageUI.YourStorePageUI;

public class YourStorePageObject extends BasePage {
    WebDriver driver;

    public YourStorePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void getElementText(String s) {
        String productPrice = driver.findElement(By.cssSelector("")).getText();
    }


    public boolean isProductPriceDisplayed(String productPrice) {
        waitForElementVisible(driver, YourStorePageUI.PRODUCT_PRICE);
        return isElementDisplayed(driver, YourStorePageUI.PRODUCT_PRICE);
    }

    public void selectToDropdownByValue(WebDriver driver, String dropdown, String value) {
        waitForElementClickable(driver, YourStorePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdown);
        selectItemInDefaultDropdown(driver, YourStorePageUI.DYNAMIC_DROPDOWN_BY_NAME, value,
                dropdown);
    }

    public void clickToAddToCartButton() {
        waitForElementClickable(driver, YourStorePageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, YourStorePageUI.ADD_TO_CART_BUTTON);
    }

    public boolean isAddedYourShoppingCartMessageDisplayed(String message) {
        waitForElementVisible(driver, YourStorePageUI.ADD_YOUR_CART_MESSAGE_DISPLAYED, message);
        return isElementDisplayed(driver, YourStorePageUI.ADD_YOUR_CART_MESSAGE_DISPLAYED, message);
    }

    public ShoppingCartPageObject openShoppingCart() {
        waitForElementClickable(driver, YourStorePageUI.SHOPPING_CART_PAGE);
        clickToElement(driver, YourStorePageUI.SHOPPING_CART_PAGE);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }


}
