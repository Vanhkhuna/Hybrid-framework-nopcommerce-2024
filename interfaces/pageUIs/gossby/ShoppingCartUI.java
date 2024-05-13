package pageUIs.gossby;

public class ShoppingCartUI {
    public static final String PRODUCT_NAME = "xpath=//a[@title='Sisters/Besties Mug - I Wish You Lived Next Door (43133)']";
    public static final String PRODUCT_PRICE = "xpath=//a[@title='Sisters/Besties Mug - I Wish You Lived Next Door (43133)']/ancestor::div//strong";
    public static final String ADDED_PRODUCT_TO_YOUR_CART = "xpath=//div[contains(@class,'Alert_alert__success')]//span";
    public static final String QUANITY_SHOPPING_CART_DISPLAY = "xpath=//div[@id='content-page']//h3[text()='Shopping Cart (1)']";
    public static final String QUANITY_PRODUCT_IN_CART = "xpath=//a[@data-title='Cart']//div//div";
    public static final String REMOVE_BUTTON = "xpath=//div[text()='Remove']";
    public static final String REMOVE_BUTTON_IN_DIALOG = "xpath=//h3[text()='Remove this item?']/following-sibling::div//button[text()='Remove']";
    public static final String PLUS_BUTTON = "xpath=//input[@id='quantity-input']/parent::div//following-sibling::div";
    public static final String CART_EMPTY_MESSAGE = "xpath=//img[@alt='image cart empty']/preceding-sibling::div";


}
