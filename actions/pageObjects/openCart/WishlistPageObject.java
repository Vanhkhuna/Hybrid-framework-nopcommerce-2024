package pageObjects.openCart;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.openCartPageUI.WishlistPageUI;

public class WishlistPageObject extends BasePage {
    WebDriver driver;

    public WishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isProductNameDisplayed(String productName) {
        return isElementDisplayed(driver, WishlistPageUI.PRODUCT_NAME, productName);
    }

    public YourStorePageObject clickToAddToCartButton() {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getYourStorePage(driver);
    }
}
