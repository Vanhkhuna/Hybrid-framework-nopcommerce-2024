package pageObjects.gossby;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {


    public static ProductObject getProductPage(WebDriver driver) {
        return new ProductObject(driver);
    }

    public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
        return new CheckoutPageObject(driver);
    }

    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
        return new ShoppingCartPageObject(driver);
    }

    public static ThankyouPageObject getThankyouPage(WebDriver driver) {
        return new ThankyouPageObject(driver);
    }

    public static TrackOderPageObject getTrackOderPage(WebDriver driver) {
        return new TrackOderPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);

    }

    public static AccountSettingPageObject getAccountSettingPage(WebDriver driver) {
        return new AccountSettingPageObject(driver);

    }
}
