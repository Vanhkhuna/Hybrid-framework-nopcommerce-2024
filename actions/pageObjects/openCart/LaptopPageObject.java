package pageObjects.openCart;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.openCartPageUI.LaptopPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopPageObject extends BasePage {
    WebDriver driver;

    public LaptopPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemInSortByDropdown(String textValue) {
        waitForElementClickable(driver, LaptopPageUI.SORT_BY_DROPDOWN);
        selectItemInDefaultDropdown(driver, LaptopPageUI.SORT_BY_DROPDOWN, textValue);
    }

    public boolean isProductPriceSortByAscending() {
        ArrayList<Float> productUIList = new ArrayList<Float>();
        List<WebElement> productPriceText = getListWebElement(driver, LaptopPageUI.PRODUCT_PRICE_TEXT);

        for (WebElement productPrice : productPriceText) {
            productUIList.add(Float.parseFloat(productPrice.getText().replace("[^0-9.]", "")));
            System.out.println("Product name trên UI: " + productPrice.getText());
        }

        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productSortList);
        for (Float productPrice : productSortList) {
            System.out.println("Product Price sau khi sort ASC:" + productPrice);
        }
        return productSortList.equals(productUIList);
    }

    public boolean isProductNameSortByAscending() {
        ArrayList<String> productUIList = new ArrayList<String>();

        List<WebElement> productNameText = getListWebElement(driver, LaptopPageUI.PRODUCT_NAME_TEXT);

        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
            System.out.println("Product name trên UI: " + productName.getText());
        }

        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productSortList);

        for (String productName : productSortList) {
            System.out.println("Product Name sau khi sort ASC:" + productName);
        }

        Collections.reverse(productSortList);

        for (String productName : productSortList) {
            System.out.println("Product Name sau khi sort DES:" + productName);
        }

        return productSortList.equals(productUIList);
    }

    public void clickToAddToCompareListButtonByText(WebDriver driver, String productName) {
        waitForElementClickable(driver, LaptopPageUI.DYNAMIC_BUTTON_BY_TEXT, productName);
        clickToElement(driver, LaptopPageUI.DYNAMIC_BUTTON_BY_TEXT, productName);
    }

    public boolean isAddProductToYourComparisionMessageDisplayed(String message) {
        waitForElementVisible(driver, LaptopPageUI.ADD_PRODUCT_TO_COMPARISION, message);
        return isElementDisplayed(driver, LaptopPageUI.ADD_PRODUCT_TO_COMPARISION, message);
    }

    public ProductComparisionPageObject clickToProductCompareLink() {
        waitForElementClickable(driver, LaptopPageUI.PRODUCT_COMPARE_LINK);
        clickToElement(driver, LaptopPageUI.PRODUCT_COMPARE_LINK);
        return PageGeneratorManager.getProductComparisionPage(driver);
    }
}
