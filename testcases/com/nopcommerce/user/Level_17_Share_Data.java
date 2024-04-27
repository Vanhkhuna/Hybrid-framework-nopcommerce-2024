package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
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

public class Level_17_Share_Data extends BaseTest {
    WebDriver driver;

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;

    public static String emailAddress, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get(GlobalConstants.PORTAL_PAGE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        homePage = PageGeneratorManager.getUserHomePage(driver);

        emailAddress = Common_01_Register.emailAddress;
        password = Common_01_Register.password;
        LogHelper.info("Login - Step 01: Click To Login link");
        loginPage = homePage.clickToLoginLink();

        LogHelper.info("Login - Step 02: Enter to Email textbox");
        loginPage.inputToEmailTextbox(emailAddress);

        LogHelper.info("Login - Step 03: Enter to Password textbox");
        loginPage.inputToPasswordTextbox(password);

        LogHelper.info("Home - Step 04: Click To Login Button");
        homePage = loginPage.clickToLoginButton();

        LogHelper.info("Home - Step 05: Verify My Account Link Displayed");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

        LogHelper.info("Home - Step 06: Click To My Account Link");
        customerInfoPage = homePage.clickMyAccountLink();

        LogHelper.info("Home - Step 07: Verify Customer Info Page Displayed");
        Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

    }

    @Test
    public void Search_01_Empty_Data() {

    }

    @Test
    public void Search_02_Absolute_Product_Name() {

    }

    @Test
    public void Search_03_Relative_Product_Name() {

    }

    @Test
    public void Search_04_Parent_Category() {

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
