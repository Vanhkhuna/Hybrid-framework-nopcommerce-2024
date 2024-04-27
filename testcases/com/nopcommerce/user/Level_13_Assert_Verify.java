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

public class Level_13_Assert_Verify extends BaseTest {
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
        Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
