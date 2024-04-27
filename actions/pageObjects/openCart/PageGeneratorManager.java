package pageObjects.openCart;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {


    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
        return new MyAccountPageObject(driver);
    }


    public static LaptopPageObject getLaptopPage(WebDriver driver) {
        return new LaptopPageObject(driver);
    }

    public static DesktopsPageObject getDesktopsPage(WebDriver driver) {
        return new DesktopsPageObject(driver);
    }

    public static WishlistPageObject getWishlistPage(WebDriver driver) {
        return new WishlistPageObject(driver);
    }

    public static YourStorePageObject getYourStorePage(WebDriver driver) {
        return new YourStorePageObject(driver);
    }

    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
        return new ShoppingCartPageObject(driver);
    }

    public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
        return new CheckoutPageObject(driver);
    }

    public static ProductComparisionPageObject getProductComparisionPage(WebDriver driver) {
        return new ProductComparisionPageObject(driver);
    }


}

