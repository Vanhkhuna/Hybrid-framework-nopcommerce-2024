package pageObjects.nopCommerce.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
        inputToEmailTextbox(emailAddress);
        inputToPasswordTextbox(password);
        return clickToLoginButton();

    }

}
