package pageObjects.gossby;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {


    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static MugCollectionPageObject getMugCollectionPage(WebDriver driver) {
        return new MugCollectionPageObject(driver);
    }

    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
        return new ShoppingCartPageObject(driver);
    }


}
