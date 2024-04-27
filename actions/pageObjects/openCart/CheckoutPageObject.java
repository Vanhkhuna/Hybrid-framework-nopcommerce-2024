package pageObjects.openCart;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageUIs.openCartPageUI.CheckoutPageUI;
import pageUIs.openCartPageUI.ShoppingCartPageUI;

public class CheckoutPageObject extends BasePage {
    WebDriver driver;

    public CheckoutPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToCheckbox() {
        WebElement element = driver.findElement(By.id("agree"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
//        waitForElementClickable(driver, CheckoutPageUI.AGREE_CHECKBOX);
//        clickToElement(driver, CheckoutPageUI.AGREE_CHECKBOX);
//    }

    public void clickToPaymentAddressButton() {
        driver.findElement(By.cssSelector("div#bitnami-banner")).click();
        WebElement element = driver.findElement(By.id("button-payment-address"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void clickToShippingAddressButton() {
        WebElement element = driver.findElement(By.id("button-shipping-address"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void clickToShippingMethodButton() {
        WebElement element = driver.findElement(By.id("button-shipping-method"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void clickToPaymentMethodButton() {
        WebElement element = driver.findElement(By.id("button-payment-method"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void clickToRadioButton() {
        waitForElementClickable(driver, CheckoutPageUI.PAYMENT_RADIO_BUTTON);
        clickToElement(driver, CheckoutPageUI.PAYMENT_RADIO_BUTTON);
    }

    public void inputToDynamicTextboxByID(WebDriver driver, String textbox, String value) {
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXTBOX, textbox);
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX, value, textbox);
    }

    public void selectItemDropdownByName(WebDriver driver, String dropdown, String value) {
        waitForElementClickable(driver, CheckoutPageUI.SELECT_DROPDOWN, dropdown);
        selectItemDefaultDropdown(driver, CheckoutPageUI.SELECT_DROPDOWN, value, dropdown);
    }
}
