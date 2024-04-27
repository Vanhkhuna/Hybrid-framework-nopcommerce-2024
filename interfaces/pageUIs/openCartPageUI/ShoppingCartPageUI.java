package pageUIs.openCartPageUI;

public class ShoppingCartPageUI {
    public static final String PRODUCT_NAME = "css=div.table-responsive td.text-left a";
    public static final String PRODUCT_COLOR = "xpath=//div[@class='table-responsive']//td[@class='text-left']//small[1]";
    public static final String PRODUCT_PRICE = "xpath=//div[@class='table-responsive']//tbody//td[@class='text-right'][1]";
    public static final String CHECKOUT_BUTTON = "xpath=//div[@class='pull-right']/a[text()='Checkout']";
    public static final String CONTIUNE_SHOPPING_BUTTON = "css=div.pull-left a";
    public static final String LAPTOP_LINK = "xpath=//a[text()='Laptops & Notebooks']";
    public static final String SEE_ALL_LAPTOP_PRODUCT = "xpath=//a[text()='Show All Laptops & Notebooks' and @class='see-all']";
    public static final String DYNAMIC_TEXTBOX = "name=%s";
    public static final String SELECT_DROPDOWN = "xpath=//select[@name='%s']";
    public static final String DYNAMIC_CONTINUE_BUTTON = "xpath=//input[@id='%s']";
    public static final String PAYMENT_ADDRESS_BUTTON = "css=input#button-payment-address";
    public static final String AGREE_CHECKBOX = "id=agree";


}
