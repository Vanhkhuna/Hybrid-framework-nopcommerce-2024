package pageObjects.nopAdmin;

import org.openqa.selenium.WebDriver;
import pageObjects.gossby.HomePageObject;


public class PageGeneratorManager {
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static DashboardPageObject getDashboardPage(WebDriver driver) {
        return new DashboardPageObject(driver);
    }

    public static CustomerPageObject getCustomerPagePage(WebDriver driver) {
        return new CustomerPageObject(driver);
    }


}
