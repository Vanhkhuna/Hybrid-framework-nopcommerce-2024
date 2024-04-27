package pageObjects.openCart;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.openCartPageUI.DesktopsPageUI;

public class DesktopsPageObject extends BasePage {
    WebDriver driver;

    public DesktopsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSeeAllButton() {
        waitForElementClickable(driver, DesktopsPageUI.SEE_ALL_BUTTON);
        clickToElement(driver, DesktopsPageUI.SEE_ALL_BUTTON);
    }

    public void clickToAddToWishListButtonByProductName(WebDriver driver, String productName) {
        waitForElementClickable(driver, DesktopsPageUI.ADD_TO_WISHLIST_BUTTON, productName);
        clickToElement(driver, DesktopsPageUI.ADD_TO_WISHLIST_BUTTON, productName);
    }

    public boolean isAddedYourWishListMessageDisplayed(String message) {
        waitForElementVisible(driver, DesktopsPageUI.ADD_YOUR_WISHLIST_MESSAGE_DISPLAYED, message);
        return isElementDisplayed(driver, DesktopsPageUI.ADD_YOUR_WISHLIST_MESSAGE_DISPLAYED, message);
    }

    public WishlistPageObject openWishlistPage() {
        waitForElementClickable(driver, DesktopsPageUI.WISHLIST_PAGE);
        clickToElementByJS(driver, DesktopsPageUI.WISHLIST_PAGE);
        return PageGeneratorManager.getWishlistPage(driver);
    }
}
