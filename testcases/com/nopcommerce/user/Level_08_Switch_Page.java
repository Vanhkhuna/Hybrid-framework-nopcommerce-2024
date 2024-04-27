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
import pageObjects.nopCommerce.user.*;

import java.time.Duration;

public class Level_08_Switch_Page extends BaseTest {
    WebDriver driver;

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserAddressesPageObject addressesPage;
    private UserRewardPointsPageObject rewardPointsPage;
    private UserMyProductReviewsPageObject myProductReviewsPage;
    private UserOrdersPageObject ordersPage;

    private String existingEmailAddress, firstName, lastName, password;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get(GlobalConstants.PORTAL_PAGE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Jade";
        lastName = "Do";
        existingEmailAddress = "jadeyy" + getRandomNumber() + "@gmail.com";
        password = "555555";

    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.clickToRegisterLink();
        registerPage.senkeyToFirstNameTextbox(firstName);
        registerPage.senkeyToLastNameTextbox(lastName);
        registerPage.senkeyToEmailTextbox(existingEmailAddress);
        registerPage.senkeyToPasswordTextbox(password);
        registerPage.senkeyToConfirmTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getSuccessMessageDisplayed(), "Your registration completed");
        loginPage = registerPage.clickToLoginLink();
        loginPage.inputToEmailTextbox(existingEmailAddress);
        loginPage.inputToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
        customerInfoPage = homePage.clickMyAccountLink();
    }


    @Test
    public void User_02_Switch_Page() {
        addressesPage = customerInfoPage.openAddressesPage(driver);
        ordersPage = addressesPage.openOrdersPage(driver);
        rewardPointsPage = ordersPage.openRewardPointsPage(driver);
        myProductReviewsPage = rewardPointsPage.openMyProductReviewsPage(driver);
    }

    @Test
    public void User_03_Dynamic_Page_01() {
        rewardPointsPage = (UserRewardPointsPageObject) myProductReviewsPage.openPagesAtMyAccountByName(driver, "Reward points");
        ordersPage = (UserOrdersPageObject) rewardPointsPage.openPagesAtMyAccountByName(driver, "Orders");
        addressesPage = (UserAddressesPageObject) ordersPage.openPagesAtMyAccountByName(driver, "Addresses");

    }

    @Test
    public void User_03_Dynamic_Page_02() {

        addressesPage.openPagesAtMyAccountByPageName(driver, "Orders");//mở ở bên BasePage
        ordersPage = PageGeneratorManager.getUserOrdersPage(driver);//khởi tạo ở testcase

    }


    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
