package pageObjects.gossby;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.gossby.ThankyouPageUI;

public class ThankyouPageObject extends BasePage {
    WebDriver driver;

    public ThankyouPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCheckoutSuccessfullyDisplayed(String message) {
        // refreshCurrentPage(driver);
        waitForElementVisible(driver, ThankyouPageUI.CHECKOUT_SUCCESSFULLY_MESSAGE, message);
        return isElementDisplayed(driver, ThankyouPageUI.CHECKOUT_SUCCESSFULLY_MESSAGE, message);
    }

    public TrackOderPageObject clickToViewOrderDetailButton() {
        waitForElementClickable(driver, ThankyouPageUI.VIEW_ODER_DETAIL_BUTTON);
        clickToElement(driver, ThankyouPageUI.VIEW_ODER_DETAIL_BUTTON);
        switchToWindowByTitle(driver, "Order detail");
        return PageGeneratorManager.getTrackOderPage(driver);
    }
}
