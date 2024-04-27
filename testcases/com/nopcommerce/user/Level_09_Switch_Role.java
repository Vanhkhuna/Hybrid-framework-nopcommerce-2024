package com.nopcommerce.user;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_09_Switch_Role extends BaseTest {
    WebDriver driver;

    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private UserCustomerInfoPageObject userCustomerInfoPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;

    private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get(GlobalConstants.PORTAL_PAGE_URL);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userEmailAddress = "jadedoo55@gmail.com";
        userPassword = "123123";
        adminEmailAddress = "admin@yourstore.com";
        adminPassword = "admin";

    }

    @Test
    public void User_01_User_To_Admin() {
        userLoginPage = userHomePage.clickToLoginLink();
        userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        userCustomerInfoPage = userHomePage.clickMyAccountLink();

        userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);

        userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
        Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

        adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
    }

    @Test
    public void User_02_Admin_To_User() {
        adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userLoginPage = userHomePage.clickToLoginLink();
        userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
    }


    @Test
    public void User_05_Switch_Role() {

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
