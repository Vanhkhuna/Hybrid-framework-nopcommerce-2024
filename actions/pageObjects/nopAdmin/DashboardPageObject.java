package pageObjects.nopAdmin;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.nopAdmin.DashboardPageUI;

import java.time.Duration;

public class DashboardPageObject extends BasePage {
    WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCustomerMenu() {
        waitForElementVisible(driver, DashboardPageUI.CUSTOMER_MENU);
        clickToElement(driver, DashboardPageUI.CUSTOMER_MENU);
    }

    public CustomerPageObject clickToCustomerListLink() {
        waitForElementVisible(driver, DashboardPageUI.CUSTOMER_LIST_LINK);
        clickToElement(driver, DashboardPageUI.CUSTOMER_LIST_LINK);
        return PageGeneratorManager.getCustomerPagePage(driver);
    }

    public boolean waitForAjaxBusyLoadingInvisible() {
        WebDriverWait expliciWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy span")));
    }
}
