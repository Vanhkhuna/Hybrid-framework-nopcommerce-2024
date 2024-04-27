package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelab.ProductPageUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPageObject extends BasePage {
    WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemInProductSortDropdown(String textItem) {
        waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
    }

    public boolean isProductNameSortByAscending() {
        //Khai báo ra 1 ArrayList để chứa các product name trên UI
        ArrayList<String> productUIList = new ArrayList<String>();

        //Lấy ra hết tất cả các text product name
        List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

        //Dùng vòng lặp để getText và add vào ArrayList trên
        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }

        //Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay không
        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }

        //Sort cái productSortList
        Collections.sort(productSortList);

        //So sánh 2 List đã bằng nhau
        return productSortList.equals(productUIList);

    }

    public boolean isProductNameSortByDescending() {
        ArrayList<String> productUIList = new ArrayList<String>();
        List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }
        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }
        Collections.sort(productSortList);
        Collections.reverse(productSortList);
        return productSortList.equals(productUIList);
    }

    public boolean isProductPriceSortByAscending() {
        ArrayList<Float> productUIList = new ArrayList<Float>();
        List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
        for (WebElement productPrice : productPriceText) {

            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
        }
        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productSortList);
        return productSortList.equals(productUIList);


    }

    public boolean isProductNameSortByAscendingLambda() {
        List<WebElement> elementLists = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
        List<String> names = elementLists.stream().map(n -> n.getText()).collect(Collectors.toList());
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        return names.equals(sortedNames);
    }

    public boolean isProductNameSortByDescendingLambda() {
        List<WebElement> elementLists = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
        List<String> names = elementLists.stream().map(n -> n.getText()).collect(Collectors.toList());
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        Collections.reverse(sortedNames);
        return names.equals(sortedNames);
    }

    public boolean isProductPriceSortByDescending() {
        ArrayList<Float> productUIList = new ArrayList<Float>();
        List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
        for (WebElement productPrice : productPriceText) {
            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));

        }
        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }
        Collections.sort(productSortList);
        Collections.reverse(productSortList);
        return productSortList.equals(productUIList);
    }


}
