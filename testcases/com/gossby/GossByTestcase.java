package com.gossby;

import commons.BaseTest;
import commons.LogHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.gossby.*;

public class GossByTestcase extends BaseTest {
    WebDriver driver;
    ProductObject productPage;
    CheckoutPageObject checkoutPage;
    ShoppingCartPageObject shoppingCartPage;
    ThankyouPageObject thankyouPage;
    TrackOderPageObject trackOderPage;
    HomePageObject homePage;
    AccountSettingPageObject accountSettingPage;

    String nameProduct = "Vanh - Auto test (please ko chỉnh sửa)";
    String price = "$13.99 USD";
    String country = "United States";
    String country1 = "Albania";
    String contactInformation = "anhntv@dlsinc.com";
    String pass = "Vanh147852a@";
    String phone = "965833562";
    String phone1 = "965833563";
    String fullName = "Auto Test";
    String fullName1 = "Test Autooo";
    String address = "HA NOI";
    String address1 = "CHIANGMAI";
    String city = "VIET NAM";
    String province = "Alabama";
    String zipCode = "555555";
    String cityZipCode = city + " " + zipCode;
    String email = "autotest" + getRandomNumber() + "@gmail.com";
    String passwordAuto = "Gossby55";
    String nameProfile = "VanAnh " + getRandomNumber();
    String fullNameAuto = "Vanh " + getRandomNumber();
    String phoneAuto = "33333" + getRandomNumber();
    String addressAuto = "PHUKET " + getRandomNumber();
    String cityAuto = "PHIPHI " + getRandomNumber();
    String zipCodeAuto = "12" + getRandomNumber();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://staging.9prints.com/en-us/product/66456C0CB69B6FN/vanh-auto-test-please-ko-chinh-sua?ccp=1&fbclid=IwZXh0bgNhZW0CMTAAAR0VNKWpsCoBWeYa4GrIc8yPOTpDtC8x9AAgQgxvDmJuh5NPvyq6MsUjhVM_aem_AQMi_JMwZhdEsKqDQYWNgolNANQkvIJxCFopogNWbsQhJ1OaZBG5IS57WCYp51CXtKvEfA6mmY1CSFPx8t3DI8AA&sref=1&variant=1641925");
        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.clickCloseButtonInPopup();

    }

    @Test
    public void TC_01_Product_Detail() {
        LogHelper.info("Product Page -Step 01 : Verify Product Name displayed");
        Assert.assertTrue(productPage.isProductNameDisplayed(nameProduct));

        LogHelper.info("Product Page -Step 02 : Verify Product Price Displayed");
        Assert.assertTrue(productPage.isProductPriceDisplayed(price));

        LogHelper.info("Product Page -Step 03 : Select Hair Value In Dropdown");
        productPage.selectHairValueInDropDown("Long hair");

        LogHelper.info("Product Page -Step 04 : Click to Add to cart button ");
        shoppingCartPage = productPage.clickToAddToCartButton();

        LogHelper.info("Shopping Cart Page -Step 05 : Verify Image Cart Loading Invisible");
        Assert.assertTrue(shoppingCartPage.waitForImageCartLoadingInvisible());

    }

    @Test
    public void TC_02_Shopping_Cart() {
        LogHelper.info("Shopping Cart Page -Step 01 : Verify product name in cart and product name in home page are the same");
        Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(nameProduct));

        LogHelper.info("Shopping Cart Page -Step 02 : Verify product price in cart and product price in home page are the same");
        Assert.assertEquals(shoppingCartPage.isProductPriceDisplayed(), price);

        LogHelper.info("Shopping Cart Page -Step 03 : Verify Quanity Product after adding to cart that displayed correctly");
        Assert.assertEquals(shoppingCartPage.getQuanityProductInCartDisplayed(), shoppingCartPage.getQuanityProductInCart());

        LogHelper.info("Shopping Cart Page -Step 04 : Verify total product price in cart and product name selected in mug page are the same");
        Assert.assertEquals(shoppingCartPage.getTotalProductPriceUIDisplayed(), shoppingCartPage.isTotalExpectedDisplayed());

        LogHelper.info("Shopping Cart Page -Step 05 : Click Change country link");
        shoppingCartPage.clickToChangeCountryLink();

        LogHelper.info("Shopping Cart Page -Step 06 : Click to country dropdown");
        shoppingCartPage.clickToCountryDropdown();

        LogHelper.info("Shopping Cart Page -Step 07 : Click to country");
        shoppingCartPage.clickToCountry(driver, country1);

        LogHelper.info("Shopping Cart Page -Step 08 : Click to Save button");
        shoppingCartPage.clickToSaveButton();
        sleepInSecond(3);

        LogHelper.info("Shopping Cart Page -Step 09 : Verify Country after changing displayed correctly");
        Assert.assertEquals(shoppingCartPage.isCountryChangedDisplayed(), "Shipping to: " + country1);

        LogHelper.info("Shopping Cart Page -Step 10 : Verify country not support message displayed");
        Assert.assertTrue(shoppingCartPage.isCountryNotSupportMessageDisplayed("Shipping to the current country is not supported for this item, please remove it from your cart."));

        LogHelper.info("Shopping Cart Page -Step 11 : Click to Save Link");
        shoppingCartPage.clickToChangeCountryLink();

        LogHelper.info("Shopping Cart Page -Step 12 : Click to country dropdown");
        shoppingCartPage.clickToCountryDropdown();

        LogHelper.info("Shopping Cart Page -Step 13 : Click to country");
        shoppingCartPage.clickToCountry(driver, country);

        LogHelper.info("Shopping Cart Page -Step 14 : Click to Save button");
        shoppingCartPage.clickToSaveButton();

        LogHelper.info("Shopping Cart Page -Step 15 : Verify Image Cart Loading Invisible");
        Assert.assertTrue(shoppingCartPage.waitForImageCartLoadingInvisible());

        LogHelper.info("Shopping Cart Page -Step 16 : Verify Country after changing displayed correctly");
        Assert.assertEquals(shoppingCartPage.isCountryChangedDisplayed(), "Shipping to: " + country);

        LogHelper.info("Shopping Cart Page -Step 17 : Enter discount code not exist");
        shoppingCartPage.inputDiscountCodeToTextbox("AUTOTEST8");

        LogHelper.info("Shopping Cart Page -Step 18 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();

        LogHelper.info("Shopping Cart Page -Step 19 : Verify error message displayed");
        Assert.assertEquals(shoppingCartPage.getErrorMessageDisplayed(), "Your order hasn't met the code requirements");

        LogHelper.info("Shopping Cart Page -Step 20 : Click to Plus button");
        shoppingCartPage.clickToPlusButton();

        LogHelper.info("Shopping Cart Page -Step 21 : Verify product updated message displayed");
        Assert.assertEquals(shoppingCartPage.getProductUpdateMessageDisplayed(), "The total amount has been updated.");

        LogHelper.info("Shopping Cart Page -Step 22 : Verify Subtotal correctly");
        Assert.assertEquals(shoppingCartPage.isPriceActualUIDisplayed(), shoppingCartPage.isTotalExpectedDisplayed());

        LogHelper.info("Shopping Cart Page -Step 23 : Click to Plus button");
        shoppingCartPage.clickToPlusButton();

        LogHelper.info("Shopping Cart Page -Step 24 : Verify product updated message displayed");
        Assert.assertEquals(shoppingCartPage.getProductUpdateMessageDisplayed(), "The total amount has been updated.");

        LogHelper.info("Shopping Cart Page -Step 25 : Verify Subtotal correctly");
        Assert.assertEquals(shoppingCartPage.isPriceActualUIDisplayed(), shoppingCartPage.isTotalExpectedDisplayed());

        LogHelper.info("Shopping Cart Page -Step 26 : Click to Minus button");
        shoppingCartPage.clickToPlusButton();

        LogHelper.info("Shopping Cart Page -Step 27 : Verify product updated message displayed");
        Assert.assertEquals(shoppingCartPage.getProductUpdateMessageDisplayed(), "The total amount has been updated.");

        LogHelper.info("Shopping Cart Page -Step 28 : Verify Subtotal correctly");
        Assert.assertEquals(shoppingCartPage.isPriceActualUIDisplayed(), shoppingCartPage.isTotalExpectedDisplayed());

        LogHelper.info("Shopping Cart Page -Step 29 : Click to Plus button");
        shoppingCartPage.clickToMinusButton();

        LogHelper.info("Shopping Cart Page -Step 30 : Verify product updated message displayed");
        Assert.assertEquals(shoppingCartPage.getProductUpdateMessageDisplayed(), "The total amount has been updated.");
        sleepInSecond(3);

        LogHelper.info("Shopping Cart Page -Step 31 : Verify Subtotal correctly");
        Assert.assertEquals(shoppingCartPage.isPriceActualUIDisplayed(), shoppingCartPage.isTotalExpectedDisplayed());

        LogHelper.info("Shopping Cart Page -Step 32 : Enter discount code 'AUTOTEST3' ");
        shoppingCartPage.inputDiscountCodeToTextbox("AUTOTEST3");

        LogHelper.info("Shopping Cart Page -Step 33 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();

        LogHelper.info("Shopping Cart Page -Step 34 : Verify message displayed");
        Assert.assertEquals(shoppingCartPage.getDiscountCodeAppliedMessageDisplayed(), "Discount code applied! We’re almost done. Fill in your shipping information at the Checkout to get the discount price.");

        LogHelper.info("Shopping Cart Page -Step 35 : Enter discount code < 4 characters");
        shoppingCartPage.inputDiscountCodeToTextbox("Van");

        LogHelper.info("Shopping Cart Page -Step 36 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();

        LogHelper.info("Shopping Cart Page -Step 37 : Verify error message displayed");
        Assert.assertEquals(shoppingCartPage.getErrorMessageDisplayed(), "Code must be 4-20 characters long.");

        LogHelper.info("Shopping Cart Page -Step 38 : Enter discount code >20 characters");
        shoppingCartPage.inputDiscountCodeToTextbox("qwertyuiopqwertyuiop1");

        LogHelper.info("Shopping Cart Page -Step 39 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();

        LogHelper.info("Shopping Cart Page -Step 40 : Verify error message displayed");
        Assert.assertEquals(shoppingCartPage.getErrorMessageDisplayed(), "Code must be 4-20 characters long.");

        LogHelper.info("Shopping Cart Page -Step 41 : Enter discount code expired");
        shoppingCartPage.inputDiscountCodeToTextbox("TRANGFKHBP");

        LogHelper.info("Shopping Cart Page -Step 42 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();

        LogHelper.info("Shopping Cart Page -Step 43 : Verify error message displayed");
        Assert.assertEquals(shoppingCartPage.getErrorMessageDisplayed(), "This code is invalid or expired. Please check again or contact us for help.");

        LogHelper.info("Shopping Cart Page -Step 44 : Enter discount code 5%");
        shoppingCartPage.inputDiscountCodeToTextbox("AUTOTEST8");
        double discountPriceShipping = shoppingCartPage.isDiscountPriceExpected();

        LogHelper.info("Shopping Cart Page -Step 45 : Click to Apply Button");
        shoppingCartPage.clickToApplyButton();

        LogHelper.info("Shopping Cart Page -Step 46 : Verify the discount price with code %");
        Assert.assertEquals(discountPriceShipping, shoppingCartPage.isDiscountPriceActual());

        LogHelper.info("Shopping Cart Page -Step 47 : Verify the total discount price with code %");
        Assert.assertEquals(shoppingCartPage.isTotalAfterApllyDiscountCodeExpected(), shoppingCartPage.isPriceActualUIDisplayed());

    }

    @Test
    public void TC_03_Checkout_Track_Order() {
        LogHelper.info("Checkout Page -Step 01 : Verify product information is same as product information in Cart page");
        int productQuantityShopping = shoppingCartPage.getProductQuantityDisplayed();
        String productTypeShopping = shoppingCartPage.getProductTypeDisplayed();
        Boolean productNameShopping = shoppingCartPage.isProductNameDisplayed();
        checkoutPage = shoppingCartPage.clickToSecureCheckoutButton();
        String productTypeCheckout = checkoutPage.getProductTypeDisplayed();
        Assert.assertEquals(productNameShopping, checkoutPage.isProductNameDisplayed());
        Assert.assertEquals(productTypeShopping, productTypeCheckout);
        String subtotalCheckout = checkoutPage.isSubtotalDisplayed();
        String promoCheckout = checkoutPage.isPromoDisplayed();

        int productQuantityCheckout = checkoutPage.getProductQuantityDisplayed();
        Assert.assertEquals(productQuantityShopping, productQuantityCheckout);

        LogHelper.info("Checkout Page -Step 02 : Verify Country after changing displayed correctly");
        Assert.assertTrue(checkoutPage.isShippingCountryDisplayed(), "Country: " + country);

        LogHelper.info("Checkout Page -Step 03 : Verify Standard Shipping is default selection");
        Assert.assertTrue(checkoutPage.isStandardShippingSelected());

        LogHelper.info("Checkout Page -Step 04 : Verify Verify Tax price correctly");
        Assert.assertEquals(checkoutPage.isTaxPriceActualUIDisplayed(), checkoutPage.isTaxPriceExpectedDisplayed());

        LogHelper.info("Checkout Page -Step 05 : Select a tip option");
        checkoutPage.clickToTipOption();

        LogHelper.info("Checkout Page -Step 06 : Verify Tip price correctly");
        Assert.assertEquals(checkoutPage.isTipActualUIDisplayed(), checkoutPage.isTipExpectedDisplayed());

        LogHelper.info("Checkout Page -Step 07 : Verify the discount price with code %");
        Assert.assertEquals(checkoutPage.isDiscountPriceExpected(), checkoutPage.isDiscountPriceActualUI());

        LogHelper.info("Checkout Page -Step 08 : Verify Total with shipping, discount, tax and tip");
        Assert.assertEquals(checkoutPage.isTotalPriceExpected(), checkoutPage.isTotalPriceActualUI());

        LogHelper.info("Checkout Page -Step 09 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();

        LogHelper.info("Checkout Page -Step 10 : Verify error message displayed");
        Assert.assertTrue(checkoutPage.isErrorMessageAtEmailAddressFieldDisplayed("Please enter a valid email address"));
        Assert.assertTrue(checkoutPage.isErrorMessageAtPhoneFieldDisplayed("Please enter a valid phone number"));
        Assert.assertTrue(checkoutPage.getErrorMessageAtDynamicFieldByIdDisplayed(driver, "shipping_address.full_name"), "Your name must include both first and last name");
        Assert.assertTrue(checkoutPage.getErrorMessageAtDynamicFieldByIdDisplayed(driver, "shipping_address.address1"), "Please enter a valid address");
        Assert.assertTrue(checkoutPage.getErrorMessageAtDynamicFieldByIdDisplayed(driver, "shipping_address.city"), "Please enter a valid city");
        Assert.assertTrue(checkoutPage.getErrorMessageAtDynamicFieldByIdDisplayed(driver, "shipping_address.zip"), "Please enter a valid zip code");

        LogHelper.info("Checkout Page -Step 11 : Input fullname invalid");
        checkoutPage.inputToDynamicTextboxByName(driver, "email", contactInformation);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.phone", phone);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.full_name", "jj");
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.address1", address);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.city", city);
        checkoutPage.selectProvinceInDropdown(province);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.zip", zipCode);

        LogHelper.info("Checkout Page -Step 12 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();

        LogHelper.info("Checkout Page -Step 13 : Verify error message when enter full name invalid");
        Assert.assertTrue(checkoutPage.getErrorMessageAtDynamicFieldByIdDisplayed(driver, "shipping_address.full_name"), "Your name must include both first and last name");

        LogHelper.info("Checkout Page -Step 14 : Province is blank");
        checkoutPage.inputToDynamicTextboxByName(driver, "email", contactInformation);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.phone", phone);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.full_name", fullName);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.address1", address);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.city", city);
        checkoutPage.selectProvinceInDropdown("Province/State");

        LogHelper.info("Checkout Page -Step 15 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();

        LogHelper.info("Checkout Page -Step 16 : Verify error message when Province is blank");
        Assert.assertTrue(checkoutPage.isErrorMessageAtProvinceFieldDisplayed("Please select a province/state"));

        LogHelper.info("Checkout Page -Step 17 : Card is blank");
        checkoutPage.inputToDynamicTextboxByName(driver, "email", contactInformation);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.phone", phone);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.full_name", fullName);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.address1", address);
        checkoutPage.inputToDynamicTextboxByName(driver, "shipping_address.city", city);
        checkoutPage.selectProvinceInDropdown(province);

        LogHelper.info("Checkout Page -Step 18 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();

        LogHelper.info("Checkout Page -Step 19 : Verify Processing Screen Invisible");
        Assert.assertTrue(checkoutPage.waitForProcessingScreenInvisible());

        LogHelper.info("Checkout Page -Step 20 : Verify error message when card is blank");
        Assert.assertTrue(checkoutPage.isErrorMessageAtCardFieldDisplayed("Your card number is incomplete."));

        LogHelper.info("Checkout Page -Step 21 : Card is invalid");
        checkoutPage.inputToCardTextbox("4444 4444 4444 4444");

        LogHelper.info("Checkout Page -Step 22 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();

        LogHelper.info("Checkout Page -Step 23 : Verify Processing Screen Invisible");
        Assert.assertTrue(checkoutPage.waitForProcessingScreenInvisible());

        LogHelper.info("Checkout Page -Step 24 : Verify error message when card is blank");
        Assert.assertTrue(checkoutPage.isErrorMessageAtCardFieldDisplayed("Your card number is invalid."));

        LogHelper.info("Checkout Page -Step 25 : Expired date is blank");
        checkoutPage.inputToCardTextbox("4242 4242 4242 4242");

        LogHelper.info("Checkout Page -Step 26 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();

        LogHelper.info("Checkout Page -Step 27 : Verify Processing Screen Invisible");
        Assert.assertTrue(checkoutPage.waitForProcessingScreenInvisible());

        LogHelper.info("Checkout Page -Step 28 : Verify error message when card is blank");
        Assert.assertTrue(checkoutPage.isErrorMessageAtCardFieldDisplayed("Your card's expiration date is incomplete."));

        LogHelper.info("Checkout Page -Step 29 : expired date is in the past");
        checkoutPage.inputToExpiredDateTextbox("1223");

        LogHelper.info("Checkout Page -Step 30 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();

        LogHelper.info("Checkout Page -Step 31 : Verify Processing Screen Invisible");
        Assert.assertTrue(checkoutPage.waitForProcessingScreenInvisible());

        LogHelper.info("Checkout Page -Step 32 : Verify error message when expired date is in the past");
        Assert.assertTrue(checkoutPage.isErrorMessageAtCardFieldDisplayed("Your card's expiration year is in the past."));

        LogHelper.info("Checkout Page -Step 33 : CVC is blank");
        checkoutPage.inputToExpiredDateTextbox("1229");

        LogHelper.info("Checkout Page -Step 34 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();

        LogHelper.info("Checkout Page -Step 35 : Verify Processing Screen Invisible");
        Assert.assertTrue(checkoutPage.waitForProcessingScreenInvisible());

        LogHelper.info("Checkout Page -Step 36 : Verify error message when CVC is blank");
        Assert.assertTrue(checkoutPage.isErrorMessageAtCardFieldDisplayed("Your card's security code is incomplete."));

        LogHelper.info("Checkout Page -Step 37 : CVC < 3 digits");
        checkoutPage.inputToCVCTextbox("12");

        LogHelper.info("Checkout Page -Step 38 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();

        LogHelper.info("Checkout Page -Step 39 : Verify Processing Screen Invisible");
        Assert.assertTrue(checkoutPage.waitForProcessingScreenInvisible());

        LogHelper.info("Checkout Page -Step 40 : Verify error message when CVC < 3 digits");
        Assert.assertTrue(checkoutPage.isErrorMessageAtCardFieldDisplayed("Your card's security code is incomplete."));

        LogHelper.info("Checkout Page -Step 41 : CVC valid");
        checkoutPage.inputToCVCTextbox("123");
        String priceAtCheckoutPage = checkoutPage.isTotalPriceActualUI();
        String phoneCompare = checkoutPage.isPhoneDisplayed();
        String shippingPriceCheckout = checkoutPage.isShippingPriceActualUIDisplayed();
        String taxPriceCheckout = checkoutPage.isTaxPriceActualUIDisplayed();
        String tipPriceCheckout = checkoutPage.isTipActualUIDisplayed();
        String shippingMethod = checkoutPage.getShippingMethodDisplayed();

        LogHelper.info("Checkout Page -Step 42 : Click to Place Your Order button");
        checkoutPage.clickToPlaceYourOrderButton();
        sleepInSecond(3);
        LogHelper.info("Checkout Page -Step 43 : Verify Processing Screen Invisible");
        Assert.assertTrue(checkoutPage.waitForProcessingScreenInvisible());

        LogHelper.info("Checkout Page -Step 44 : Verify Checkout successfully message displayed");
        thankyouPage = PageGeneratorManager.getThankyouPage(driver);
        Assert.assertTrue(thankyouPage.isCheckoutSuccessfullyDisplayed("Thanks For Your Purchase!"));

        LogHelper.info("Thankyou Page -Step 45 : Click to View order detail button");
        trackOderPage = thankyouPage.clickToViewOrderDetailButton();
        String trackOrderID = trackOderPage.isTrackOrderIDDisplayed();

        LogHelper.info("Track Order Page -Step 46 : Verify information of product is same as information in Checkout page");
        Assert.assertEquals(checkoutPage.isProductNameDisplayed(), trackOderPage.isProductNameDisplayed());
        Assert.assertEquals(priceAtCheckoutPage, trackOderPage.isProductPriceDisplayed());
        Assert.assertEquals(productTypeCheckout, trackOderPage.getProductTypeDisplayed());
        Assert.assertEquals(subtotalCheckout, trackOderPage.isSubtotalPriceDisplayed());
        Assert.assertEquals(promoCheckout, trackOderPage.isPromoPriceDisplayed());
        Assert.assertEquals(shippingPriceCheckout, trackOderPage.isShippingPriceDisplayed());
        Assert.assertEquals(taxPriceCheckout, trackOderPage.isTaxPriceDisplayed());
        Assert.assertEquals(tipPriceCheckout, trackOderPage.isTipPriceDisplayed());
        Assert.assertEquals(contactInformation, trackOderPage.isContactInfoDisplayed());
        Assert.assertEquals(phoneCompare + " " + phone, trackOderPage.isShippingAddressByIndexDisplayed(driver, "6"));
        Assert.assertEquals(fullName, trackOderPage.isShippingAddressByIndexDisplayed(driver, "1"));
        Assert.assertEquals(address, trackOderPage.isShippingAddressByIndexDisplayed(driver, "2"));
        Assert.assertEquals(cityZipCode, trackOderPage.isShippingAddressByIndexDisplayed(driver, "4"));
        Assert.assertEquals(country, trackOderPage.isShippingAddressByIndexDisplayed(driver, "5"));
        Assert.assertEquals(shippingMethod, trackOderPage.getShippingMethodDelivery());

        LogHelper.info("Track Order Page -Step 47 : Click to Edit Design button");
        trackOderPage.clickToButtonByTextValue(driver, "Edit Design");

        LogHelper.info("Track Order Page -Step 48 : Verify Edit campaign design popup is displayed");
        Assert.assertTrue(trackOderPage.isEditCampaignDesignPopupDisplayed());

        LogHelper.info("Track Order Page -Step 49 : Select Hair Value In Dropdown");
        trackOderPage.selectHairValueInDropDown("British Shorthair");

        LogHelper.info("Track Order Page -Step 50 : Edit Design");
        trackOderPage.clickCatColorOption();
        trackOderPage.inputToNameTextbox("Vanhhh");
        trackOderPage.clickExpressionOption();
        trackOderPage.clickCatShirtOption();

        LogHelper.info("Track Order Page -Step 51 : Click to Update Design button");
        trackOderPage.clickToUpdateDesignButton();

        LogHelper.info("Track Order Page -Step 52 : Click to Edit Design button");
        trackOderPage.clickToButtonByTextValue(driver, "Edit Design");

        LogHelper.info("Track Order Page -Step 53 : Click to Preview button");
        trackOderPage.clickToButtonByTextValue(driver, "Preview");

        LogHelper.info("Track Order Page -Step 54 : Close Edit Design popup");
        trackOderPage.clickToClosePopup();

        LogHelper.info("Track Order Page -Step 55 : Click to Edit Order button");
        trackOderPage.clickToButtonByTextValue(driver, "Edit Order");

        LogHelper.info("Track Order Page -Step 57 : Verify Edit Order Popup is displayed");
        Assert.assertTrue(trackOderPage.isEditOrderPopupDisplayed());

        LogHelper.info("Track Order Page -Step 58 : Click to Cancel Edit button");
        trackOderPage.clickToButtonByTextValue(driver, "Cancel Edit");

        LogHelper.info("Track Order Page -Step 59 : Verify Edit Order Popup is undisplayed");
        Assert.assertTrue(trackOderPage.isEditOrderPopupUndisplayed());

        LogHelper.info("Track Order Page -Step 60 : Click to Edit Order button");
        trackOderPage.clickToButtonByTextValue(driver, "Edit Order");

        LogHelper.info("Track Order Page -Step 61 : Verify Edit Order Popup is displayed");
        Assert.assertTrue(trackOderPage.isEditOrderPopupDisplayed());

        LogHelper.info("Track Order Page -Step 62 : Update Customer information");
        trackOderPage.inputToDynamicTextboxByName(driver, "shipping_address.phone", phone1);
        trackOderPage.inputToDynamicTextboxByName(driver, "shipping_address.full_name", fullName1);
        trackOderPage.inputToDynamicTextboxByName(driver, "shipping_address.address1", address1);

        LogHelper.info("Track Order Page -Step 63 : Click to Save button");
        trackOderPage.clickToButtonByTextValue(driver, "Save");
        trackOderPage.clickToButtonByTextValue(driver, "Save");

        LogHelper.info("Track Order Page -Step 64 : Verify Order Edit Successfully Message is Displayed");
        Assert.assertTrue(trackOderPage.isOrderEditedSuccessfullyMessageDisplayed("Order edited successfully !"));

        LogHelper.info("Track Order Page -Step 65 : Click to Cancel Order button");
        trackOderPage.clickToButtonByTextValue(driver, "Cancel Order");

        LogHelper.info("Track Order Page -Step 66 : Verify Cancel Order Popup is displayed");
        Assert.assertTrue(trackOderPage.isCancelOrderPopupDisplayed());

        LogHelper.info("Track Order Page -Step 67 : Select reasons for cancel");
        trackOderPage.selectReasonInDropdown(driver, "I need to change the design.");

        LogHelper.info("Track Order Page -Step 68 : Click to 'I want to think again' button");
        trackOderPage.clickToButtonByTextValue(driver, "I want to think again");

        LogHelper.info("Track Order Page -Step 69 : Verify Cancel Order Popup is undisplayed");
        Assert.assertTrue(trackOderPage.isCancelOrderPopupUndisplayed());

        LogHelper.info("Track Order Page -Step 70 : Click to Cancel Order button");
        trackOderPage.clickToButtonByTextValue(driver, "Cancel Order");

        LogHelper.info("Track Order Page -Step 71 : Verify Cancel Order Popup is displayed");
        Assert.assertTrue(trackOderPage.isCancelOrderPopupDisplayed());

        LogHelper.info("Track Order Page -Step 72 : Select reasons for cancel");
        trackOderPage.selectReasonInDropdown(driver, "The additional fees are too high.");

        LogHelper.info("Track Order Page -Step 73 : Click to 'Yes, Cancel it!' button");
        trackOderPage.clickToButtonByTextValue(driver, "Yes, Cancel it!");

        LogHelper.info("Track Order Page -Step 74 : Verify Cancel Order Successfully Message is displayed");
        Assert.assertTrue(trackOderPage.isCancelOrderSuccessfullyMessageDisplayed("Your order has been successfully cancelled."));

        LogHelper.info("Track Order Page -Step 75 : Click Track order button");
        trackOderPage.clickToTrackOrderButton();

        LogHelper.info("Track Order Page -Step 76 : Verify Errors Message is displayed");
        Assert.assertTrue(trackOderPage.isErrorsMessageAtDynamicFieldByNameDisplayed(driver, "email", "Email address is required!"));
        Assert.assertTrue(trackOderPage.isErrorsMessageAtDynamicFieldByNameDisplayed(driver, "code", "Please enter a valid Order ID"));

        LogHelper.info("Track Order Page -Step 77 : Input to email textbox is invalid");
        trackOderPage.inputToDynamicTextboxByName(driver, "email", "anhntv@dlsinc");

        LogHelper.info("Track Order Page -Step 78 : Click Track order button");
        trackOderPage.clickToTrackOrderButton();

        LogHelper.info("Track Order Page -Step 79 : Verify Errors Message is displayed");
        Assert.assertTrue(trackOderPage.isErrorsMessageAtDynamicFieldByNameDisplayed(driver, "email", " Please enter a valid email address"));
        Assert.assertTrue(trackOderPage.isErrorsMessageAtDynamicFieldByNameDisplayed(driver, "code", "Please enter a valid Order ID"));

        LogHelper.info("Track Order Page -Step 80 : Input to code textbox is invalid");
        trackOderPage.inputToDynamicTextboxByName(driver, "email", contactInformation);
        trackOderPage.inputToDynamicTextboxByName(driver, "code", "9P_6357");

        LogHelper.info("Track Order Page -Step 81 : Click Track order button");
        trackOderPage.clickToTrackOrderButton();

        LogHelper.info("Track Order Page -Step 82 : Verify Errors Message is displayed");
        Assert.assertTrue(trackOderPage.isSorryMessageDisplayed("Sorry, we could not find your order with the given information. Please verify that the information you entered is correct or contact us for immediate assistance."));

        LogHelper.info("Track Order Page -Step 83 : Input to email, code textbox is valid");
        trackOderPage.inputToDynamicTextboxByName(driver, "email", contactInformation);
        trackOderPage.inputToDynamicTextboxByName(driver, "code", trackOrderID);

        LogHelper.info("Track Order Page -Step 84 : Click Track order button");
        trackOderPage.clickToTrackOrderButton();

        LogHelper.info("Track Order Page -Step 85 : Verify Errors Message is displayed");
        Assert.assertTrue(trackOderPage.isOderCanceledMessageDisplayed("Your order was canceled"));

        LogHelper.info("Track Order Page -Step 86 : Click Continue Shopping link ");
        homePage = trackOderPage.clickToContinueShopping();

    }

    @Test
    public void TC_04_Home_Signup_Signin() {
        LogHelper.info("Home Page -Step 01 : Click Sign Up button ");
        homePage.clickToButtonByTitleText(driver, "Sign up");

        LogHelper.info("Home Page -Step 02 : Click Create Your Account button ");
        homePage.clickToCreateYourAccountButton();

        LogHelper.info("Home Page -Step 03 : Verify error message displayed when blank all fields ");
        Assert.assertTrue(homePage.isErrorMessageAtEmailDisplayed("Please enter a valid email address"));
        Assert.assertTrue(homePage.isErrorMessageAtPasswordDisplayed("Please enter a password"));
        Assert.assertTrue(homePage.isErrorMessageAtConfirmPasswordDisplayed("Please enter a confirm password"));

        LogHelper.info("Home Page -Step 04 : Enter invalid email ");
        homePage.inputToTextboxByID(driver, "email", "TTTT");
        homePage.inputToTextboxByID(driver, "password", passwordAuto);
        homePage.inputToTextboxByID(driver, "confirm_password", passwordAuto);

        LogHelper.info("Home Page -Step 05 : Click Create Your Account button ");
        homePage.clickToCreateYourAccountButton();

        LogHelper.info("Home Page -Step 06 : Verify error message displayed when email is invalid ");
        Assert.assertTrue(homePage.isErrorMessageAtEmailDisplayed("Please enter a valid email address"));

        LogHelper.info("Home Page -Step 07 : Enter password < 8 characters ");
        homePage.inputToTextboxByID(driver, "email", email);
        homePage.inputToTextboxByID(driver, "password", "Thai");
        homePage.inputToTextboxByID(driver, "confirm_password", passwordAuto);

        LogHelper.info("Home Page -Step 08 : Click Create Your Account button ");
        homePage.clickToCreateYourAccountButton();

        LogHelper.info("Home Page -Step 09 : Verify error message displayed when enter password < 8 characters");
        Assert.assertTrue(homePage.isErrorMessageAtPasswordDisplayed("Password must be 8-16 characters long."));
        Assert.assertTrue(homePage.isErrorMessageAtConfirmPasswordDisplayed("Confirm password does not match"));

        LogHelper.info("Home Page -Step 10 : Enter password >16 characters ");
        homePage.inputToTextboxByID(driver, "email", email);
        homePage.inputToTextboxByID(driver, "password", "Thailand5dddffdddddddddddddđ5");
        homePage.inputToTextboxByID(driver, "confirm_password", passwordAuto);

        LogHelper.info("Home Page -Step 11 : Click Create Your Account button ");
        homePage.clickToCreateYourAccountButton();

        LogHelper.info("Home Page -Step 12 : Verify error message displayed when enter password >16 characters");
        Assert.assertTrue(homePage.isErrorMessageAtPasswordDisplayed("Password must be 8-16 characters long."));
        Assert.assertTrue(homePage.isErrorMessageAtConfirmPasswordDisplayed("Confirm password does not match"));

        LogHelper.info("Home Page -Step 13 : Enter incorrect confirm password ");
        homePage.inputToTextboxByID(driver, "email", email);
        homePage.inputToTextboxByID(driver, "password", passwordAuto);
        homePage.inputToTextboxByID(driver, "confirm_password", "rrrrrr");

        LogHelper.info("Home Page -Step 14 : Click Create Your Account button ");
        homePage.clickToCreateYourAccountButton();

        LogHelper.info("Home Page -Step 15 : Verify error message displayed when enter confirm password incorrect");
        Assert.assertTrue(homePage.isErrorMessageAtConfirmPasswordDisplayed("Confirm password does not match"));

        LogHelper.info("Home Page -Step 16 : Enter correct information ");
        homePage.inputToTextboxByID(driver, "email", email);
        homePage.inputToTextboxByID(driver, "password", passwordAuto);
        homePage.inputToTextboxByID(driver, "confirm_password", passwordAuto);

        LogHelper.info("Home Page -Step 17 : Click Create Your Account button ");
        homePage.clickToCreateYourAccountButton();

        LogHelper.info("Home Page -Step 18 : Verify verification email button displayed");
        Assert.assertTrue(homePage.isVerificationEmailButtonByTextDisplayed(driver, "Resend Verification Email"));

        LogHelper.info("Home Page -Step 19 : Click Sign in link ");
        homePage.clickToSigninLink();

        LogHelper.info("Home Page -Step 20 : Verify Signin  button displayed");
        Assert.assertTrue(homePage.isVerificationEmailButtonByTextDisplayed(driver, "Sign In"));

        LogHelper.info("Home Page -Step 21 : Click Sign in button ");
        homePage.clickToSigninButton(driver, "Sign In");

        LogHelper.info("Home Page -Step 22 : Verify error message displayed when blank all fields ");
        Assert.assertTrue(homePage.isErrorMessageAtEmailSigninDisplayed("Please enter a valid email address"));
        Assert.assertTrue(homePage.isErrorMessageAtPasswordSigninDisplayed("Please enter a password"));

        LogHelper.info("Home Page -Step 23 : Enter invalid email ");
        homePage.inputToTextboxByID(driver, "username", "TTTT");
        homePage.inputToTextboxByID(driver, "password", passwordAuto);

        LogHelper.info("Home Page -Step 24 : Click Signin button ");
        homePage.clickToSigninButton(driver, "Sign In");

        LogHelper.info("Home Page -Step 25 : Verify error message displayed when email is invalid ");
        Assert.assertTrue(homePage.isErrorMessageAtEmailSigninDisplayed("Please enter a valid email address"));

        LogHelper.info("Home Page -Step 26 : Enter not exist email ");
        homePage.inputToTextboxByID(driver, "username", "tit_amskewz_tu@tfbnw.net");
        homePage.inputToTextboxByID(driver, "password", passwordAuto);

        LogHelper.info("Home Page -Step 27 : Click Signin button ");
        homePage.clickToSigninButton(driver, "Sign In");

        LogHelper.info("Home Page -Step 28 : Verify error message displayed when email is not exist ");
        Assert.assertTrue(homePage.isErrorMessageAtEmailSigninDisplayed("Email does not exist. "));

        LogHelper.info("Home Page -Step 29 : Enter password < 8 characters ");
        homePage.inputToTextboxByID(driver, "username", email);
        homePage.inputToTextboxByID(driver, "password", "1234567");

        LogHelper.info("Home Page -Step 30 : Click Signin button ");
        homePage.clickToSigninButton(driver, "Sign In");

        LogHelper.info("Home Page -Step 31 : Verify error message displayed when password < 8 characters ");
        Assert.assertTrue(homePage.isErrorMessageAtPasswordSigninDisplayed("Password must be 8-16 characters long."));

        LogHelper.info("Home Page -Step 32 : Enter password > 16 characters ");
        homePage.inputToTextboxByID(driver, "username", email);
        homePage.inputToTextboxByID(driver, "password", "12345679123456780123");

        LogHelper.info("Home Page -Step 33 : Click Signin button ");
        homePage.clickToSigninButton(driver, "Sign In");

        LogHelper.info("Home Page -Step 34 : Verify error message displayed when password > 16 characters ");
        Assert.assertTrue(homePage.isErrorMessageAtPasswordSigninDisplayed("Password must be 8-16 characters long."));

        LogHelper.info("Home Page -Step 35 : Enter password incorrect ");
        homePage.inputToTextboxByID(driver, "username", contactInformation);
        homePage.inputToTextboxByID(driver, "password", "12345679");

        LogHelper.info("Home Page -Step 36 : Click Signin button ");
        homePage.clickToSigninButton(driver, "Sign In");

        LogHelper.info("Home Page -Step 37 : Verify error message displayed when password is incorrect ");
        Assert.assertTrue(homePage.isErrorMessageAtPasswordSigninDisplayed("Email or password is incorrect"));

        LogHelper.info("Home Page -Step 38 : Enter password incorrect ");
        homePage.inputToTextboxByID(driver, "username", contactInformation);
        homePage.inputToTextboxByID(driver, "password", "12345678910");

        LogHelper.info("Home Page -Step 39 : Click Signin button ");
        homePage.clickToSigninButton(driver, "Sign In");

        LogHelper.info("Home Page -Step 40 : Open My Profile Page");
        accountSettingPage = homePage.clickMyProfileButton();
    }

    @Test
    public void TC_05_Account_Setting() {
        LogHelper.info("Account Setting Page -Step 01 : Verify email is correct");
        Assert.assertTrue(accountSettingPage.isEmailDisplayed(contactInformation));

        LogHelper.info("Account Setting Page -Step 02 : Input phone number is not digit");
        accountSettingPage.inputToTextboxByName(driver, "phone", "aaaa");

        LogHelper.info("Account Setting Page -Step 03 : Click save button");
        accountSettingPage.clickSaveButton();

        LogHelper.info("Account Setting Page -Step 04 : Verify error message when phone number is not digit");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByName(driver, "phone"), "Phone numbers must be numeric only");

        LogHelper.info("Account Setting Page -Step 05 : Input name is blank");
        accountSettingPage.inputToTextboxByName(driver, "name", "");
        accountSettingPage.inputToTextboxByName(driver, "phone", "9876544");

        LogHelper.info("Account Setting Page -Step 06 : Click save button");
        accountSettingPage.clickSaveButton();

        LogHelper.info("Account Setting Page -Step 07 : Verify error message when Name is blank");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByName(driver, "name"), "Name must be a string and not empty");

        LogHelper.info("Account Setting Page -Step 08 : Input all information are valid");
        accountSettingPage.inputToTextboxByName(driver, "name", nameProfile);
        accountSettingPage.inputToTextboxByName(driver, "phone", "9876544");
        accountSettingPage.clickRadioButtonByText(driver, "Male");
        accountSettingPage.selectValueInDropdownByName(driver, "day", "19");
        accountSettingPage.selectValueInDropdownByName(driver, "month", "June");
        accountSettingPage.selectValueInDropdownByName(driver, "year", "1994");

        LogHelper.info("Account Setting Page -Step 09 : Click save button");
        accountSettingPage.clickSaveButton();

        LogHelper.info("Account Setting Page -Step 10 : Verify edit successful message is displayed");
        Assert.assertTrue(accountSettingPage.isMessageAfterChangeInformationDisplayed("Your profile has been updated."));

        LogHelper.info("Account Setting Page -Step 11 : Click edit email link");
        accountSettingPage.clickEmailEditLink();

        LogHelper.info("Account Setting Page -Step 12 : Verify change email popup is displayed");
        Assert.assertTrue(accountSettingPage.isChangeEmailPopupDisplayed());

        LogHelper.info("Account Setting Page -Step 13 : Click cancel button");
        accountSettingPage.clickButtonByText(driver, "Cancel");

        LogHelper.info("Account Setting Page -Step 14 : Verify change email popup is undisplayed");
        Assert.assertTrue(accountSettingPage.isChangeEmailPopupUndisplayed());

        LogHelper.info("Account Setting Page -Step 15 : Click edit email link");
        accountSettingPage.clickEmailEditLink();

        LogHelper.info("Account Setting Page -Step 16 : Verify change email popup is displayed");
        Assert.assertTrue(accountSettingPage.isChangeEmailPopupDisplayed());

        LogHelper.info("Account Setting Page -Step 17 : Input email is invalid");
        accountSettingPage.inputToEmailTextbox("gossby");

        LogHelper.info("Account Setting Page -Step 18 : Click submit button");
        accountSettingPage.clickButtonByText(driver, "Submit");

        LogHelper.info("Account Setting Page -Step 19 : Verify error message when email is invalid");
        Assert.assertTrue(accountSettingPage.isErrorMessageAtEmailFieldDisplayed("Please enter a valid email address"));

        LogHelper.info("Account Setting Page -Step 20 : Input email is exist");
        accountSettingPage.inputToEmailTextbox("fdddd@gmail.com");

        LogHelper.info("Account Setting Page -Step 21 : Click submit button");
        accountSettingPage.clickButtonByText(driver, "Submit");
        accountSettingPage.clickButtonByText(driver, "Submit");

        LogHelper.info("Account Setting Page -Step 22 : Verify error message when email is exist");
        Assert.assertTrue(accountSettingPage.isErrorMessageAtEmailFieldDisplayed("New email already exists. "));

        LogHelper.info("Account Setting Page -Step 23 : Input email is valid");
        accountSettingPage.inputToEmailTextbox("gossby@gmail.com");

        LogHelper.info("Account Setting Page -Step 24 : Click submit button");
        accountSettingPage.clickButtonByText(driver, "Submit");

        LogHelper.info("Account Setting Page -Step 25 : Verify edit successful message is displayed");
        Assert.assertTrue(accountSettingPage.isMessageAfterChangeInformationDisplayed("An email has been sent to your inbox."));

        LogHelper.info("Account Setting Page -Step 26 : Click Change Password link");
        accountSettingPage.clickChangePasswordLink();

        LogHelper.info("Account Setting Page -Step 27 : Verify Change My Password header is displayed");
        Assert.assertTrue(accountSettingPage.isChangeMyPasswordHeaderDisplayed());

        LogHelper.info("Account Setting Page -Step 28 : Click Save button");
        accountSettingPage.clickSaveButton();

        LogHelper.info("Account Setting Page -Step 29 : Verify Change My Password Header is displayed");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByNameAtChangePasswordTab(driver, "password"), "Please enter a valid current password");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByNameAtChangePasswordTab(driver, "new_password"), "Please enter a valid new password");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByNameAtChangePasswordTab(driver, "confirm_password"), "Please enter a valid confirm new password");

        LogHelper.info("Account Setting Page -Step 30 : Input new password < 8 characters");
        accountSettingPage.inputToTextboxByName(driver, "password", "12345678910");
        accountSettingPage.inputToTextboxByName(driver, "new_password", "123456");

        LogHelper.info("Account Setting Page -Step 31 : Verify show error message when new password < 8 characters");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByNameAtChangePasswordTab(driver, "new_password"), "Your password must be at least 8 characters");

        LogHelper.info("Account Setting Page -Step 32 : Input new password > 16 characters");
        accountSettingPage.inputToTextboxByName(driver, "password", "12345678910");
        accountSettingPage.inputToTextboxByName(driver, "new_password", "123456333333333322");
        accountSettingPage.inputToTextboxByName(driver, "confirm_password", "123456333333333322");

        LogHelper.info("Account Setting Page -Step 33 : Click Save button");
        accountSettingPage.clickSaveButton();

        LogHelper.info("Account Setting Page -Step 34 : Verify show error message when new password >16 characters");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByNameAtChangePasswordTab(driver, "new_password"), "Password must be 8-16 characters long.");

        LogHelper.info("Account Setting Page -Step 35 : Input NEW password is same as old password");
        accountSettingPage.inputToTextboxByName(driver, "password", "12345678910");
        accountSettingPage.inputToTextboxByName(driver, "new_password", "12345678910");
        accountSettingPage.inputToTextboxByName(driver, "confirm_password", "12345678910");

        LogHelper.info("Account Setting Page -Step 36 : Verify show error message when new password is same as old password");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByNameAtChangePasswordTab(driver, "new_password"), "New password must be different from current password");

        LogHelper.info("Account Setting Page -Step 37 : Input confirm password is not match new password");
        accountSettingPage.inputToTextboxByName(driver, "password", "12345678910");
        accountSettingPage.inputToTextboxByName(driver, "new_password", "12345678910");
        accountSettingPage.inputToTextboxByName(driver, "confirm_password", "12345678911");

        LogHelper.info("Account Setting Page -Step 38 : Verify show error message when Current password is not match new password");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByNameAtChangePasswordTab(driver, "confirm_password"), "Passwords do not match");

//        LogHelper.info("Account Setting Page -Step 39 : Input information is valid");
//        accountSettingPage.inputToTextboxByName(driver, "password", "123456789");
//        accountSettingPage.inputToTextboxByName(driver, "new_password", "12345678910");
//        accountSettingPage.inputToTextboxByName(driver, "confirm_password", "12345678910");
//
//        LogHelper.info("Account Setting Page -Step 40 : Click Save button");
//        accountSettingPage.clickSaveButton();
//
//        LogHelper.info("Account Setting Page -Step 41 : Verify change password successfully");
//        Assert.assertTrue(accountSettingPage.isEditSuccessfulMessageDisplayed("Your password has been updated."));

        LogHelper.info("Account Setting Page -Step 42 : Click Back button");
        accountSettingPage.clickBackButton();

        LogHelper.info("Account Setting Page -Step 43 : Click Add new address button");
        accountSettingPage.clickAddressButton();

        LogHelper.info("Account Setting Page -Step 44 : Verify Add new address popup is displayed ");
        Assert.assertTrue(accountSettingPage.isAddNewAddressPopupDisplayed());

        LogHelper.info("Account Setting Page -Step 45 : Click Save button");
        accountSettingPage.clickSaveButtonAtAddAddressPopup();

        LogHelper.info("Account Setting Page -Step 46 : Verify show error message when all fields are blank");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtFullNameField(), "Your name must include both first and last name");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtPhoneField(), "Please enter a valid phone number");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByID(driver, "new_address.address1"), "Please enter a valid address");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByID(driver, "new_address.city"), "Please enter a valid city");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtDynamicFieldByID(driver, "new_address.zip"), "Please enter a valid zip code");

        LogHelper.info(" Account SettingPage -Step 47 : Input fullname invalid");
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.full_name", "jj");
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.phone", phoneAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.address1", addressAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.city", cityAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.zip", zipCode);

        LogHelper.info("Account Setting Page -Step 48 : Verify error message when enter full name invalid");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtFullNameField(), "Your name must include both first and last name");

        LogHelper.info("Account Setting Page -Step 49 : Province is blank");
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.full_name", fullNameAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.phone", phoneAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.address1", addressAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.city", cityAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.zip", zipCodeAuto);
        accountSettingPage.selectCountryInDropdown(driver, country);

        LogHelper.info("Account Setting Page -Step 50 : Click Save button");
        accountSettingPage.clickSaveButtonAtAddAddressPopup();

        LogHelper.info("Account Setting Page -Step 51 : Verify show error message when Province is blank");
        Assert.assertEquals(accountSettingPage.getErrorMessageAtProvinceField(), "Please select a province/state");

        LogHelper.info("Account Setting Page -Step 52 : All information is valid");
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.full_name", fullNameAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.phone", phoneAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.address1", addressAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.city", cityAuto);
        accountSettingPage.inputToDynamicTextboxByName(driver, "new_address.zip", zipCodeAuto);
        accountSettingPage.selectCountryInDropdown(driver, country);
        accountSettingPage.selectProvinceInDropdown("California");

        LogHelper.info("Account Setting Page -Step 53 : Click Default checkbox");
        accountSettingPage.clickDefaultCheckbox();

        LogHelper.info("Account Setting Page -Step 54 : Click Save button");
        accountSettingPage.clickSaveButtonAtAddAddressPopup();

        LogHelper.info("Account Setting Page -Step 55 : Verify change address successfully");
        Assert.assertTrue(accountSettingPage.isMessageAfterChangeInformationDisplayed("Your address has been added."));

        LogHelper.info("Account Setting Page -Step 56 : Verify Set as default new address");
        Assert.assertEquals(accountSettingPage.isDefaultStateAddressRecentDisplayed(driver, fullNameAuto), "Default Address");

        LogHelper.info("Account Setting Page -Step 57 : Click Delete Default Account button");
        accountSettingPage.clickDeleteDefaultAddressButton();

        LogHelper.info("Account Setting Page -Step 58 : Verify remove address is displayed");
        Assert.assertTrue(accountSettingPage.isRemoveAddressDisplayed());

        LogHelper.info("Account Setting Page -Step 59 : Click Remove button");
        accountSettingPage.clickButtonByText(driver, "Remove");

        LogHelper.info("Account Setting Page -Step 60 : Verify Can't delete default address message is displayed");
        Assert.assertTrue(accountSettingPage.isMessageAfterChangeInformationDisplayed("Can't delete the default address"));

        LogHelper.info("Account Setting Page -Step 61 : Click Cancel button");
        accountSettingPage.clickButtonByText(driver, "Cancel");

        LogHelper.info("Account Setting Page -Step 62 : Verify remove address is undisplayed");
        Assert.assertTrue(accountSettingPage.isRemoveAddressUndisplayed());

        LogHelper.info("Account Setting Page -Step 63 : Click Change Default  button");
        accountSettingPage.clickChangeDefaultButton();

        LogHelper.info("Account Setting Page -Step 64 : Verify Change address popup is displayed");
        Assert.assertTrue(accountSettingPage.isChangeAddressPopupDisplayed());

        LogHelper.info("Account Setting Page -Step 65 : Click Default checkbox");
        accountSettingPage.clickRemoveDefaultCheckbox();

        LogHelper.info("Account Setting Page -Step 66 : Click Change Button At Change Address Popup");
        accountSettingPage.clickChangeButtonAtChangeAddressPopup();

        LogHelper.info("Account Setting Page -Step 67 : Verify update message is displayed");
        Assert.assertTrue(accountSettingPage.isMessageAfterChangeInformationDisplayed("Your address has been removed."));

        LogHelper.info("Account Setting Page -Step 68 : Click Change Button After Change State");
        accountSettingPage.clickChangeButtonAfterChangeState(driver, fullNameAuto);

        LogHelper.info("Account Setting Page -Step 69 : Verify Change Address Popup is displayed");
        Assert.assertTrue(accountSettingPage.isChangeAddressPopupDisplayed());

        LogHelper.info("Account Setting Page -Step 70 : Click delete button");
        accountSettingPage.clickDeleteButton();

        LogHelper.info("Account Setting Page -Step 71 : Click Remove button");
        accountSettingPage.clickButtonByText(driver, "Remove");

        LogHelper.info("Account Setting Page -Step 72 : Verify address removed message is displayed");
        Assert.assertTrue(accountSettingPage.isMessageAfterChangeInformationDisplayed("Your address has been removed."));

        LogHelper.info("Account Setting Page -Step 73 : Verify address is removed");
        Assert.assertTrue(accountSettingPage.isAddressUndisplayed(driver, fullNameAuto));


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
