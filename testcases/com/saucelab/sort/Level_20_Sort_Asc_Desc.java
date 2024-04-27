package com.saucelab.sort;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.LogHelper;
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
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGeneratorManager;
import pageObjects.saucelab.ProductPageObject;

import java.time.Duration;

public class Level_20_Sort_Asc_Desc extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    ProductPageObject productPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://www.saucedemo.com/");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.inputToUsernameTextbox("standard_user");
        loginPage.inputToPasswordTextbox("secret_sauce");
        productPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Sort_01_Name() {
        //Ascending
        productPage.selectItemInProductSortDropdown("Name (A to Z)");
        sleepInSecond(3);
        Assert.assertTrue(productPage.isProductNameSortByAscending());
        //Descending
        productPage.selectItemInProductSortDropdown("Name (Z to A)");
        sleepInSecond(3);
        Assert.assertTrue(productPage.isProductNameSortByDescending());
    }

    @Test
    public void Sort_02_Pricing() {
        //Ascending
        productPage.selectItemInProductSortDropdown("Price (low to high)");
        sleepInSecond(3);
        Assert.assertTrue(productPage.isProductPriceSortByAscending());
        //Descending
        productPage.selectItemInProductSortDropdown("Price (high to low)");
        sleepInSecond(3);
        Assert.assertTrue(productPage.isProductPriceSortByDescending());

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
