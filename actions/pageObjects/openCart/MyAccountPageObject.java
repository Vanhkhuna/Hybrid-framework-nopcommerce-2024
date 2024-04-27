package pageObjects.openCart;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.openCartPageUI.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
    WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public DesktopsPageObject openDesktopsLink() {
        waitForElementClickable(driver, MyAccountPageUI.DESKTOPS_LINK);
        clickToElement(driver, MyAccountPageUI.DESKTOPS_LINK);
        return PageGeneratorManager.getDesktopsPage(driver);
    }
}
