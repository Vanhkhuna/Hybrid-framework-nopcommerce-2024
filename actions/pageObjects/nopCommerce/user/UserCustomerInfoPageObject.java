package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
    private WebDriver driver;

    public UserCustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isCustomerInfoPageDisplayed() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.MY_ACCOUNT_INFOR_HEADER);
        return isElementDisplayed(driver, UserCustomerInfoPageUI.MY_ACCOUNT_INFOR_HEADER);
    }


    public void clickToLogoutLink() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.LOGOUT_LINK);
        clickToElement(driver, UserCustomerInfoPageUI.LOGOUT_LINK);
    }
}
