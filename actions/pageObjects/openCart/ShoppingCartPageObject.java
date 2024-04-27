package pageObjects.openCart;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.openCartPageUI.ShoppingCartPageUI;

import java.time.Duration;

public class ShoppingCartPageObject extends BasePage {
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplayed(String productName) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.table-responsive td.text-left a")));

        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME, productName);
        return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_NAME, productName);
    }


    public boolean isProductColorDisplayed(String productColor) {
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_COLOR, productColor);
        return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_COLOR, productColor);
    }

    public boolean isProductPriceDisplayed(String productPrice) {
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_PRICE, productPrice);
        return isElementDisplayed(driver, ShoppingCartPageUI.PRODUCT_PRICE, productPrice);
    }

    public CheckoutPageObject clickCheckoutButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        clickToElementByJS(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        return PageGeneratorManager.getCheckoutPage(driver);
    }


    public LaptopPageObject clickToContiuneShoppingButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CONTIUNE_SHOPPING_BUTTON);
        clickToElementByJS(driver, ShoppingCartPageUI.CONTIUNE_SHOPPING_BUTTON);
        return PageGeneratorManager.getLaptopPage(driver);
    }

    public void clickToLaptopLink() {
        waitForElementClickable(driver, ShoppingCartPageUI.LAPTOP_LINK);
        clickToElement(driver, ShoppingCartPageUI.LAPTOP_LINK);
    }

    public LaptopPageObject clickToSeeAllLaptopProductLink() {
        waitForElementClickable(driver, ShoppingCartPageUI.SEE_ALL_LAPTOP_PRODUCT);
        clickToElement(driver, ShoppingCartPageUI.SEE_ALL_LAPTOP_PRODUCT);
        return PageGeneratorManager.getLaptopPage(driver);
    }
}
