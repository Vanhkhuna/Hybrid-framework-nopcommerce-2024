package com.gossby;

import commons.BaseTest;
import commons.LogHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.gossby.HomePageObject;
import pageObjects.gossby.MugCollectionPageObject;
import pageObjects.gossby.PageGeneratorManager;
import pageObjects.gossby.ShoppingCartPageObject;

public class GossByTestcase extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    MugCollectionPageObject mugCollectionPage;
    ShoppingCartPageObject shoppingCartPage;
    String title1 = "Sisters/Besties Mug - I Wish You Lived Next Door (43133)";
    String name1 = title1 + "- Personalized Mug";

    String price1 = "$13.99 USD";


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://gossby.com/en-us?sref=265");
        homePage = PageGeneratorManager.getHomePage(driver);
        LogHelper.info("Home Page - Step 01 :Click Signin Button");
        homePage.clickSigninButton();

        LogHelper.info("Home Page - Step 02 : Input to Email Textbox");
        homePage.inputToEmailTextbox("jade.do@playstudios.asia");

        LogHelper.info("Home Page - Step 03 : Input to Password Textbox");
        homePage.inputToPasswordTextbox("Thuydoo95@");

        LogHelper.info("Home Page - Step 04 : Click Submit Button");
        homePage.clickToSubmitButton();

        LogHelper.info("Home Page - Step 05 : Change Country");
        homePage.clickToChangeCountryButton();

        LogHelper.info("Home Page - Step 06 : Click to country");
        homePage.clickToCountry();

        LogHelper.info("Home Page - Step 07 : Click Save Button");
        homePage.clickSaveButton();

        LogHelper.info("Home Page - Step 08 : Open Mug Collection Page");
        mugCollectionPage = homePage.openMugCollectionPage();

    }

    @Test
    public void TC_01_Mug_Add_To_Cart() {
        LogHelper.info("Mug Page -Step 01 : Click Product By Title");
        mugCollectionPage.clickProductByTitle();

        LogHelper.info("Mug Page -Step 02 : Verify Product Name displayed");
        Assert.assertTrue(mugCollectionPage.isProductNameDisplayed(name1));

        LogHelper.info("Mug Page -Step 03 : Verify Product Price Displayed");
        Assert.assertTrue(mugCollectionPage.isProductPriceDisplayed(price1));

//        LogHelper.info("Mug Page -Step 04 : Click Number Girl");
//        mugCollectionPage.clickNumberGirl();
//
//        LogHelper.info("Mug Page -Step 05 : Input to Name Textbox ");
////        mugCollectionPage.inputToNameTextboxByText(driver, "Woman's Name #1", "Jade");
////        mugCollectionPage.inputToNameTextboxByText(driver, "Woman's Name #2", "Jenn");

        LogHelper.info("Mug Page -Step 06 : Click to Add to cart button");
        shoppingCartPage = mugCollectionPage.clickToAddToCartButton();

        LogHelper.info("Shopping Cart Page -Step 07 : Verify Image Cart Loading Invisible");
        Assert.assertTrue(shoppingCartPage.waitForImageCartLoadingInvisible());

        LogHelper.info("Shopping Cart Page -Step 08 : Verify Quanity Product after adding to cart that displayed correctly");
        Assert.assertEquals(shoppingCartPage.getQuanityProductInCartDisplayed(), shoppingCartPage.getQuanityProductInCart());

        LogHelper.info("Shopping Cart Page -Step 09 : Verify product name in cart and product name selected in mug page are the same");
        Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(title1));

        LogHelper.info("Shopping Cart Page -Step 10 : Verify product price in cart and product name selected in mug page are the same");
        Assert.assertTrue(shoppingCartPage.isProductPriceDisplayed(price1));

        LogHelper.info("Shopping Cart Page -Step 11 : Click to plus button");
        shoppingCartPage.clickToPlusButton();

        LogHelper.info("Shopping Cart Page -Step 12 : Verify total amount updated message displayed");
        Assert.assertTrue(shoppingCartPage.isAlertMessageDisplayed("The total amount has been updated."));

        LogHelper.info("Shopping Cart Page -Step 13 : Verify quanity Product after adding to cart that displayed correctly");
        Assert.assertEquals(shoppingCartPage.getQuanityProductInCartDisplayed(), shoppingCartPage.getQuanityProductInCart());

        LogHelper.info("Shopping Cart Page -Step 14 : Click to remove button");
        shoppingCartPage.clickToRemoveButton();

        LogHelper.info("Shopping Cart Page -Step 15 : Verify remove product from cart message displayed");
        Assert.assertTrue(shoppingCartPage.isAlertMessageDisplayed("An item was removed from cart."));

//        LogHelper.info("Shopping Cart Page -Step 16 : Verify cart empty message displayed");
//        Assert.assertTrue(shoppingCartPage.isCartEmptyMessageDisplayed("Your cart is currently empty."));

        // Gia su nhu em code cho nay
        // Viet them mot dong nua
        // Viet them dong thu 3

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
