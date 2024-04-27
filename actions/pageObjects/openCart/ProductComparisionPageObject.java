package pageObjects.openCart;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.openCartPageUI.ProductComparisionPageUI;

public class ProductComparisionPageObject extends BasePage {
    WebDriver driver;

    public ProductComparisionPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public int getProductCompareQuanity() {
        return getElementSize(driver, ProductComparisionPageUI.PRODUCT_COMPARE_QUANITY);
    }

    public void clickToRemoveButton() {
        waitForElementClickable(driver, ProductComparisionPageUI.REMOVE_BUTTON);
        clickToElement(driver, ProductComparisionPageUI.REMOVE_BUTTON);
    }

    public boolean isShoppingCartEmptyMessageDisplayed(String message) {
        waitForElementVisible(driver, ProductComparisionPageUI.SHOPPING_CART_EMPTY_MESSAGE_DISPLAYED, message);
        return isElementDisplayed(driver, ProductComparisionPageUI.SHOPPING_CART_EMPTY_MESSAGE_DISPLAYED, message);
    }

    public boolean isModifiedProductComparisonMessageDisplayed(String message) {
        waitForElementVisible(driver, ProductComparisionPageUI.MODIFIED_PRODUCT_MESSAGE_DISPLAYED, message);
        return isElementDisplayed(driver, ProductComparisionPageUI.MODIFIED_PRODUCT_MESSAGE_DISPLAYED, message);
    }
}


