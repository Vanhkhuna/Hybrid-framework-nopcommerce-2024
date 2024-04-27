package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import com.nopcommerce.common.Common_01_Register_Cookie;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.LogHelper;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.time.Duration;
import java.util.Set;

public class Level_17_Share_Data_Cookie extends BaseTest {
    WebDriver driver;

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;

    public static String emailAddress, password;


    @Parameters("browser")
    @BeforeTest(description = "Create new User for all class")
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
        loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
        loginPage.refreshCurrentPage(driver);

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
        //driver.quit();
    }
}
