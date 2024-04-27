package pageUIs.openCartPageUI;

public class LaptopPageUI {
    public static final String SORT_BY_DROPDOWN = "css=select#input-sort";
    public static final String PRODUCT_PRICE_TEXT = "css=p.price-tax";
    public static final String PRODUCT_NAME_TEXT = "css=div.caption a";
    public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//a[text()='%s']/ancestor::div[@class='caption']//following-sibling::div//button[@data-original-title='Compare this Product']";
    public static final String ADD_PRODUCT_TO_COMPARISION = "css=div.alert-success";
    public static final String PRODUCT_COMPARE_LINK = "css=a#compare-total";
}
