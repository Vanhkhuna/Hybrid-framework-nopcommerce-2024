package com.nopcommerce.common;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.LogHelper;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.time.Duration;

public class Common_01_Register extends BaseTest {
    WebDriver driver;

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;

    private String firstName, lastName;
    public static String emailAddress, password;


    @Parameters("browser")
    @BeforeTest(description = "Create new User for all class")
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get(GlobalConstants.PORTAL_PAGE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Jade";
        lastName = "Do";
        emailAddress = "jadeyy" + getRandomNumber() + "@gmail.com";
        password = "555555";
        LogHelper.info("Pre-condition - Step 01: Navigate to 'Register' page");
        registerPage = homePage.clickToRegisterLink();

        LogHelper.info("Pre-condition - Step 02: Enter to Firstname textbox");
        registerPage.senkeyToFirstNameTextbox(firstName);

        LogHelper.info("Pre-condition - Step 03: Enter to Lastname textbox");
        registerPage.senkeyToLastNameTextbox(lastName);

        LogHelper.info("Pre-condition - Step 04: Enter to Email textbox");
        registerPage.senkeyToEmailTextbox(emailAddress);

        LogHelper.info("Pre-condition - Step 05: Enter to Password textbox");
        registerPage.senkeyToPasswordTextbox(password);

        LogHelper.info("Pre-condition - Step 06: Enter to Confirm password textbox");
        registerPage.senkeyToConfirmTextbox(password);

        LogHelper.info("Pre-condition - Step 07: Click To Register button");
        registerPage.clickToRegisterButton();

        LogHelper.info("Pre-condition - Step 08: Verify Success Message Displayed");
        Assert.assertEquals(registerPage.getSuccessMessageDisplayed(), "Your registration completed");
        driver.quit();
    }

}