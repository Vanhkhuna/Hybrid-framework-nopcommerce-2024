package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRMPageUI.DashboardPageUI;

public class DashboardPageObject extends BasePage {
    WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public PIMPageObject openPIMLink() {
        waitForElementClickable(driver, DashboardPageUI.PIM_LINK);
        clickToElement(driver, DashboardPageUI.PIM_LINK);
        return PageGeneratorManager.getPIMPageObject(driver);
    }
}
