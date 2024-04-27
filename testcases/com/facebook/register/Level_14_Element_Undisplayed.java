package com.facebook.register;

import commons.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;


public class Level_14_Element_Undisplayed extends BaseTest {
    WebDriver driver;
    private LoginPageObject loginPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://www.facebook.com/");
        loginPage = PageGeneratorManager.getLoginPage(driver);

    }


    @Test
    public void TC_01_Verify_Element_Displayed() {
        loginPage.clickToCreatNewAccountButton();
        Assert.assertTrue(loginPage.isEmailAddressTextboxDisplayed());

    }


    @Test
    public void TC_02_Verify_Element_Undisplayed_In_DOM() {
        loginPage.inputToEmailAddressTextbox("Thailand2024@gmail.com");
        Assert.assertTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

        loginPage.inputToEmailAddressTextbox("");
        Assert.assertTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

    }

    @Test
    public void TC_03_Verify_Element_Undisplayed_NOT_In_DOM() {
        loginPage.closeSignUpPopup();
        Assert.assertTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
