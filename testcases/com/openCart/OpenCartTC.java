package com.openCart;

import commons.BaseTest;
import commons.LogHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.openCart.*;

public class OpenCartTC extends BaseTest {
    WebDriver driver;

    LoginPageObject loginPage;
    MyAccountPageObject myAccountPage;
    DesktopsPageObject desktopsPage;
    WishlistPageObject wishlistPage;
    YourStorePageObject yourStorePage;
    ShoppingCartPageObject shoppingCartPage;
    CheckoutPageObject checkoutPage;
    LaptopPageObject laptopPage;
    ProductComparisionPageObject productComparisionPage;
    String email = "hust.k59.2014@gmail.com";
    String password = "Thuydoo95@";
    String productPrice = "$80";
    String productName = "Canon EOS 5D";

    String productColor = "Red\n" +
            "                 ";
    String pColor = productColor.replace("\n" +
            "                 ", "");
    String productCompare1 = "Sony VAIO";


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        myAccountPage = loginPage.clickToLoginButton();

    }

    @Test
    public void TC_01_Desktops_Add_To_Wishlist() {
        LogHelper.info("Desktops Page -Step 01 : Open Desktops Link");
        desktopsPage = myAccountPage.openDesktopsLink();

        LogHelper.info("Desktops Page -Step 02 : Click to see all desktop product button");
        desktopsPage.clickToSeeAllButton();

        LogHelper.info("Desktops Page -Step 03 : Click to Add To Wishlist Button By Product name");
        desktopsPage.clickToAddToWishListButtonByProductName(driver, productName);

        LogHelper.info("Desktops Page -Step 04 : Verify Add product to your wishlist success");
        Assert.assertTrue(desktopsPage.isAddedYourWishListMessageDisplayed(" Success: You have added " + productName + " to your wish list! "));

        LogHelper.info("Desktops Page -Step 05 : Open wishlist page");
        wishlistPage = desktopsPage.openWishlistPage();

        LogHelper.info("Desktops Page -Step 06 : Verify Product Name is displayed correctly");
        Assert.assertTrue(wishlistPage.isProductNameDisplayed(productName));

        LogHelper.info("Desktops Page -Step 07 : Open Your Store Page");
        yourStorePage = wishlistPage.clickToAddToCartButton();

        LogHelper.info("Desktops Page -Step 08 : Verify Product Price is displayed correctly");
        Assert.assertTrue(yourStorePage.isProductPriceDisplayed(productPrice));

        LogHelper.info("Desktops Page -Step 09 : Select Product Color in dropdown By Value");
        yourStorePage.selectToDropdownByValue(driver, "option[226]", "Red\n" +
                "                 ");

        LogHelper.info("Desktops Page -Step 10 : Click to Add To Cart button");
        yourStorePage.clickToAddToCartButton();

        LogHelper.info("Desktops Page -Step 11 : Verify add your shopping cart susccess");
        Assert.assertTrue(yourStorePage.isAddedYourShoppingCartMessageDisplayed(" Success: You have added " + productName + " to your shopping cart!"));

        LogHelper.info("Desktops Page -Step 12 : Open Shopping Cart Page");
        shoppingCartPage = yourStorePage.openShoppingCart();

        LogHelper.info("Desktops Page -Step 13 : Verify Product name is displayed correctly");
        Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(productName));

        LogHelper.info("Desktops Page -Step 14 : Verify Product color is displayed correctly");

        Assert.assertTrue(shoppingCartPage.isProductColorDisplayed("Select: " + pColor));

        LogHelper.info("Desktops Page -Step 15 : Verify Product price is displayed correctly");
        Assert.assertTrue(shoppingCartPage.isProductPriceDisplayed(productPrice));

        LogHelper.info("Desktops Page -Step 16 : Click to continue shopping button");
        shoppingCartPage.clickToContiuneShoppingButton();
//        checkoutPage = shoppingCartPage.clickCheckoutButton();
//        checkoutPage.clickToRadioButton();
//        checkoutPage.inputToDynamicTextboxByID(driver, "input-payment-firstname", "Rosen");
//        checkoutPage.inputToDynamicTextboxByID(driver, "input-payment-lastname", "JJ");
//        checkoutPage.inputToDynamicTextboxByID(driver, "input-payment-address-1", "China Town");
//        checkoutPage.inputToDynamicTextboxByID(driver, "input-payment-city", "Singapore");
//        checkoutPage.selectItemDropdownByName(driver, "input-payment-country_id", "American Samoa");
//        checkoutPage.selectItemDropdownByName(driver, "input-payment-zone_id", "Baleares");
//        checkoutPage.clickToPaymentAddressButton();
//        checkoutPage.clickToShippingAddressButton();
//        checkoutPage.clickToShippingMethodButton();
//        checkoutPage.clickToCheckbox();
//        checkoutPage.clickToPaymentMethodButton();
    }

    @Test
    public void TC_02_Laptop_Sort() {
        LogHelper.info("Shopping Cart Page -Step 01 :Click to Laptop Link");
        shoppingCartPage.clickToLaptopLink();

        LogHelper.info("Laptop Page -Step 02 : Open Laptop Page");
        laptopPage = shoppingCartPage.clickToSeeAllLaptopProductLink();

        LogHelper.info("Laptop Page -Step 03 : Sort by : 'Price (Low > High)'");
        laptopPage.selectItemInSortByDropdown("Price (Low > High)");

        LogHelper.info("Laptop Page -Step 04 : Verify Product Price Sort By Ascending");
        Assert.assertTrue(laptopPage.isProductPriceSortByAscending());

        LogHelper.info("Laptop Page -Step 05 : Sort by : 'Name (Z - A)'");
        laptopPage.selectItemInSortByDropdown("Name (Z - A)");

        LogHelper.info("Laptop Page -Step 06 : Verify Product Name Sort By Descending");
        Assert.assertTrue(laptopPage.isProductNameSortByAscending());

        LogHelper.info("Laptop Page -Step 07 : Click to Add to Compare list button");
        laptopPage.clickToAddToCompareListButtonByText(driver, productCompare1);
        Assert.assertTrue(laptopPage.isAddProductToYourComparisionMessageDisplayed(" Success: You have added " + productCompare1 + " to your product comparison! "));

        LogHelper.info("Laptop Page -Step 08 : Click To Product Compare Link ");
        productComparisionPage = laptopPage.clickToProductCompareLink();
    }

    @Test
    public void TC_03_Product_Compare() {
        LogHelper.info("Product Page -Step 01 : Verify product compare quanity displayed ");
        Assert.assertEquals(productComparisionPage.getProductCompareQuanity(), 1);

        LogHelper.info("Product Page -Step 02 : Click to remove button ");
        productComparisionPage.clickToRemoveButton();

        LogHelper.info("Product Page -Step 03 : Verify your shopping cart empty message displayed ");
        Assert.assertTrue(productComparisionPage.isShoppingCartEmptyMessageDisplayed("Your shopping cart is empty!"));

        LogHelper.info("Product Page -Step 04 : Verify modified your product comparison message displayed ");
        Assert.assertTrue(productComparisionPage.isModifiedProductComparisonMessageDisplayed(" Success: You have modified your product comparison!\n" +
                "    "));
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
