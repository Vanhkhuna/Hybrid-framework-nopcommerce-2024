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

public class Level_19_Pattern_Object extends BaseTest {
    WebDriver driver;

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;

    private String existingEmailAddress, firstName, lastName, password;

    private String date, month, year;

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
        date = "30";
        month = "November";
        year = "1995";

    }

    @Test
    public void User_01_Register_Login() {
        LogHelper.info("Register - Step 01: Navigate to 'Register' page");
        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRadioButtonByLabel(driver, "Female");

        LogHelper.info("Register - Step 02: Input to dynamic textbox");
        registerPage.inputToDynamicTextboxByID(driver, "FirstName", firstName);
        registerPage.inputToDynamicTextboxByID(driver, "LastName", lastName);

        registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
        registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
        registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

        registerPage.inputToDynamicTextboxByID(driver, "Email", existingEmailAddress);

        registerPage.clickToCheckboxByLabel(driver, "Newsletter");

        registerPage.inputToDynamicTextboxByID(driver, "Password", password);
        registerPage.inputToDynamicTextboxByID(driver, "ConfirmPassword", password);

        LogHelper.info("Register - Step 03: Click To Register button");
        registerPage.clickToButtonByText(driver, "Register");

        LogHelper.info("Register - Step 04: Verify Success Message Displayed");
        Assert.assertEquals(registerPage.getSuccessMessageDisplayed(), "Your registration completed");
    }

    @Test
    public void User_02_Login() {
        LogHelper.info("Login - Step 01: Click To Login link");
        loginPage = registerPage.clickToLoginLink();

        LogHelper.info("Login - Step 02: Enter to Email textbox");
        loginPage.inputToDynamicTextboxByID(driver, "Email", existingEmailAddress);
        loginPage.inputToDynamicTextboxByID(driver, "Password", password);

        LogHelper.info("Home - Step 03: Click To Login Button");
        loginPage.clickToButtonByText(driver, "Log in");
        homePage = PageGeneratorManager.getUserHomePage(driver);

        LogHelper.info("Home - Step 05: Verify My Account Link Displayed");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

        LogHelper.info("Home - Step 06: Click To My Account Link");
        customerInfoPage = homePage.clickMyAccountLink();

        LogHelper.info("Home - Step 07: Verify Customer Info Page Displayed");
        Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
    }

    @Test
    public void User_03_My_Account() {
        LogHelper.info("MyAccount - Step 01 : Navigate to 'My Account' page");
        customerInfoPage = homePage.clickMyAccountLink();


        LogHelper.info("MyAccount - Step 02 : Verify 'Customer Infor' page is displayed");
        Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

        LogHelper.info("MyAccount - Step 03 : Verify 'First Name' is correctly ");
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);
        LogHelper.info("MyAccount - Step 04 : Verify 'Last Name' is correctly ");
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);

        LogHelper.info("MyAccount - Step 05 : Verify 'Email' is correctly ");
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), existingEmailAddress);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
