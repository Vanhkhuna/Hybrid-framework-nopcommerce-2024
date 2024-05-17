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
    String country = "France";
    String discountCode5 = "TEST";
    String discountCode15 = "ACPU15";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://gossby.com/en-us?sref=265");
        homePage = PageGeneratorManager.getHomePage(driver);
        LogHelper.info("Home Page - Step 01 :Click Signin Button");
        homePage.clickSigninButton();

        LogHelper.info("Home Page - Step 02 : Input to Email Textbox");
        homePage.inputToEmailTextbox("anhntv@dlsinc.com");

        LogHelper.info("Home Page - Step 03 : Input to Password Textbox");
        homePage.inputToPasswordTextbox("Matkhaula123");

        LogHelper.info("Home Page - Step 04 : Click Submit Button");
        homePage.clickToSubmitButton();

        LogHelper.info("Home Page - Step 05 : Change Country");
        homePage.clickToChangeCountryButton();

        LogHelper.info("Home Page - Step 06 : Click to country");
        homePage.clickToCountry();

        LogHelper.info("Home Page - Step 07 : Click Save Button");
        homePage.clickSaveButton();

        LogHelper.info("Home Page - Step 08 : Click Close Button in Popup");
        homePage.clickCloseButtonInPopup();

        LogHelper.info("Home Page - Step 09 : Open Mug Collection Page");
        mugCollectionPage = homePage.openMugCollectionPage();

    }

    @Test
    public void TC_01_Product_Detail_Mug() {
        LogHelper.info("Mug Page -Step 01 : Click Product By Title");
        mugCollectionPage.clickProductByTitle();

        LogHelper.info("Mug Page -Step 02 : Verify Product Name displayed");
        Assert.assertTrue(mugCollectionPage.isProductNameDisplayed(name1));

        LogHelper.info("Mug Page -Step 03 : Verify Product Price Displayed");
        Assert.assertTrue(mugCollectionPage.isProductPriceDisplayed(price1));

        LogHelper.info("Mug Page -Step 04 : Click Number Girl");
        mugCollectionPage.clickNumberGirl();

        LogHelper.info("Mug Page -Step 05 : Input to Name Textbox ");
        mugCollectionPage.inputToNameTextboxByText(driver, "Woman's Name #1", "Jade");
        mugCollectionPage.inputToNameTextboxByText(driver, "Woman's Name #2", "Jenn");
    }

    @Test
    public void TC_02_Shopping_Cart() {
        LogHelper.info("Mug Page -Step 01 : Click to Add to cart button");
        shoppingCartPage = mugCollectionPage.clickToAddToCartButton();

        LogHelper.info("Shopping Cart Page -Step 02 : Verify Image Cart Loading Invisible");
        Assert.assertTrue(shoppingCartPage.waitForImageCartLoadingInvisible());

        LogHelper.info("Shopping Cart Page -Step 03 : Verify Quanity Product after adding to cart that displayed correctly");
        Assert.assertEquals(shoppingCartPage.getQuanityProductInCartDisplayed(), shoppingCartPage.getQuanityProductInCart());

        LogHelper.info("Shopping Cart Page -Step 04 : Verify product name in cart and product name selected in mug page are the same");
        Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(title1));

        LogHelper.info("Shopping Cart Page -Step 05 : Verify product price in cart and product name selected in mug page are the same");
        Assert.assertTrue(shoppingCartPage.isProductPriceDisplayed(price1));

        LogHelper.info("Shopping Cart Page -Step 06 : Uncheck Add Gift Pack checkbox");
        shoppingCartPage.uncheckAddGiftPackCheckbox();

        LogHelper.info("Shopping Cart Page -Step 07 : Verify total product price in cart and product name selected in mug page are the same");
        sleepInSecond(10);
        Assert.assertEquals(shoppingCartPage.getTotalProductPriceDisplayed(), price1);

        LogHelper.info("Shopping Cart Page -Step 08 : Click Change country link");
        shoppingCartPage.clickToChangeCountryLink();

        LogHelper.info("Shopping Cart Page -Step 09 : Click to country dropdown");
        shoppingCartPage.clickToCountryDropdown();

        LogHelper.info("Shopping Cart Page -Step 10 : Click to country");
        shoppingCartPage.clickToCountry(driver, country);

        LogHelper.info("Shopping Cart Page -Step 11 : Click to Save button");
        shoppingCartPage.clickToSaveButton();

        LogHelper.info("Shopping Cart Page -Step 12 : Verify Image Cart Loading Invisible");
        Assert.assertTrue(shoppingCartPage.waitForImageCartLoadingInvisible());

        LogHelper.info("Shopping Cart Page -Step 13 : Verify Add Ons Gift Undisplayed");
        Assert.assertTrue(shoppingCartPage.isAddOnsGiftUndisplayed());

        LogHelper.info("Shopping Cart Page -Step 14 : Verify Country after changing displayed correctly");
        Assert.assertEquals(shoppingCartPage.isCountryChangedDisplayed(), "Shipping to: " + country);

        LogHelper.info("Shopping Cart Page -Step 15 : Click to Plus button");
        shoppingCartPage.clickToPlusButton();

        LogHelper.info("Shopping Cart Page -Step 16 : Verify product updated message displayed");
        Assert.assertTrue(shoppingCartPage.isProductUpdateMessageDisplayed("The total amount has been updated."));
        sleepInSecond(5);

        LogHelper.info("Shopping Cart Page -Step 17 : Verify Subtotal correctly");
        Assert.assertEquals(shoppingCartPage.isPriceActualUIDisplayed(), shoppingCartPage.isTotalExpectedDisplayed());

        LogHelper.info("Shopping Cart Page -Step 18 : Enter discount code < 4 characters");
        shoppingCartPage.inputDiscountCodeToTextbox("Van");

        LogHelper.info("Shopping Cart Page -Step 19 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();
        sleepInSecond(5);

        LogHelper.info("Shopping Cart Page -Step 20 : Verify error message displayed");
        Assert.assertEquals(shoppingCartPage.getErrorMessageDisplayed(), "Code must be 4-20 characters long.");

        LogHelper.info("Shopping Cart Page -Step 21 : Enter discount code >20 characters");
        shoppingCartPage.inputDiscountCodeToTextbox("qwertyuiopqwertyuiop1");

        LogHelper.info("Shopping Cart Page -Step 22 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();

        LogHelper.info("Shopping Cart Page -Step 23 : Verify error message displayed");
        Assert.assertEquals(shoppingCartPage.getErrorMessageDisplayed(), "Code must be 4-20 characters long.");

        LogHelper.info("Shopping Cart Page -Step 24 : Enter discount code 5%");
        shoppingCartPage.inputDiscountCodeToTextbox(discountCode5);

        LogHelper.info("Shopping Cart Page -Step 25 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();
        sleepInSecond(5);

        LogHelper.info("Shopping Cart Page -Step 26 : Verify the total discount price with code %");
        Assert.assertEquals(shoppingCartPage.isDiscountPriceExpected(), shoppingCartPage.isDiscountPriceActual());

        LogHelper.info("Shopping Cart Page -Step 27 : Verify the total discount price with code %");
        Assert.assertEquals(shoppingCartPage.isTotalAfterApllyDiscountCodeExpected(), shoppingCartPage.isPriceActualUIDisplayed());

        LogHelper.info("Shopping Cart Page -Step 28 : Enter discount code expired");
        shoppingCartPage.inputDiscountCodeToTextbox("GBLOVE30");

        LogHelper.info("Shopping Cart Page -Step 29 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();
        sleepInSecond(5);

        LogHelper.info("Shopping Cart Page -Step 30 : Verify error message displayed");
        Assert.assertEquals(shoppingCartPage.getErrorMessageDisplayed(), "This code is invalid or expired. Please check again or contact us for help.");

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
