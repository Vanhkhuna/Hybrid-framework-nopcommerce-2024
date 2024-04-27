package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.*;

public class PageGeneratorManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPageObject(driver);
    }

    public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
        return new UserAddressesPageObject(driver);
    }

    public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {
        return new UserMyProductReviewsPageObject(driver);
    }

    public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
        return new UserOrdersPageObject(driver);
    }

    public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {
        return new UserRewardPointsPageObject(driver);
    }


    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }


}

