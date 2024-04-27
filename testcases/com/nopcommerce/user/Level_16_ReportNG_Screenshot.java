package com.nopcommerce.user;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.LogHelper;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Level_16_ReportNG_Screenshot extends BaseTest {
    WebDriver driver;

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;

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
    public void User_01_Register_Login() {
        LogHelper.info("Register - Step 01: Navigate to 'Register' page");
        registerPage = homePage.clickToRegisterLink();

        LogHelper.info("Register - Step 02: Enter to Firstname textbox");
        registerPage.senkeyToFirstNameTextbox(firstName);

        LogHelper.info("Register - Step 03: Enter to Lastname textbox");
        registerPage.senkeyToLastNameTextbox(lastName);

        LogHelper.info("Register - Step 04: Enter to Email textbox");
        registerPage.senkeyToEmailTextbox(existingEmailAddress);

        LogHelper.info("Register - Step 05: Enter to Password textbox");
        registerPage.senkeyToPasswordTextbox(password);

        LogHelper.info("Register - Step 06: Enter to Confirm password textbox");
        registerPage.senkeyToConfirmTextbox(password);

        LogHelper.info("Register - Step 07: Click To Register button");
        registerPage.clickToRegisterButton();

        LogHelper.info("Register - Step 08: Verify Success Message Displayed");
        Assert.assertEquals(registerPage.getSuccessMessageDisplayed(), "Your registrationn completed");

    }

    @Test
    public void User_02_Login() {
        LogHelper.info("Login - Step 01: Click To Login link");
        loginPage = registerPage.clickToLoginLink();

        LogHelper.info("Login - Step 02: Enter to Email textbox");
        loginPage.inputToEmailTextbox(existingEmailAddress);

        LogHelper.info("Login - Step 03: Enter to Password textbox");
        loginPage.inputToPasswordTextbox(password);

        LogHelper.info("Home - Step 04: Click To Login Button");
        homePage = loginPage.clickToLoginButton();

        LogHelper.info("Home - Step 05: Verify My Account Link Displayed");
        Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

        LogHelper.info("Home - Step 06: Click To My Account Link");
        customerInfoPage = homePage.clickMyAccountLink();

        LogHelper.info("Home - Step 07: Verify Customer Info Page Displayed");
        Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
