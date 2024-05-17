package pageUIs.gossby;

public class ShoppingCartUI {
    public static final String PRODUCT_NAME = "xpath=//a[@title='Sisters/Besties Mug - I Wish You Lived Next Door (43133)']";
    public static final String PRODUCT_PRICE = "xpath=//a[@title='Sisters/Besties Mug - I Wish You Lived Next Door (43133)']/ancestor::div//strong";
    public static final String ADDED_PRODUCT_TO_YOUR_CART = "xpath=//div[contains(@class,'Alert_alert__success')]//span";
    public static final String QUANITY_SHOPPING_CART_DISPLAY = "xpath=//div[@id='content-page']//h3[contains(text(),'Shopping Cart')]";
    public static final String QUANITY_PRODUCT_IN_CART = "xpath=//a[@data-title='Cart']//div//div";
    public static final String ADD_GIFT_PACK_CHECKBOX = "xpath=//input[@type='checkbox']";
    public static final String TOTAL_PRICE = "xpath=//div[text()='Total:']//span";
    public static final String CHANGE_COUNTRY_LINK = "xpath=//span[text()='Change']";
    public static final String CHANGE_COUNTRY_DROPDOWN = "xpath=//div[text()='Select your shipping country']/following-sibling::div[1]";
    public static final String CHOOSE_COUNTRY = "xpath=//div[text()='%s']";
    public static final String SAVE_BUTTON = "xpath=//button[@type='button' and text()='Save & Continue']";
    public static final String ADD_ONS_GIFT_UNDISPLAYED = "css=div.AddOns_addons_img__hYOUM";
    public static final String COUNTRY_AFTER_CHANGED_DISPLAYED = "xpath=//span[text()='Change']/preceding-sibling::span";
    public static final String PLUS_BUTTON = "xpath=//input[@id='quantity-input']/following-sibling::div";
    public static final String PRODUCT_UPDATED_MESSAGE = "xpath=//div[contains(@class,'Alert_alert__success')]//span";
    public static final String PRODUCT_PRICE_ORIGINAL = "xpath=//input[@id='quantity-input']/ancestor::div//strong";
    public static final String PROMO_CODE_TEXTBOX = "xpath=//input[@placeholder='Enter your Promo Code']";
    public static final String APPLY_BUTTON = "xpath=//div[text()='Apply']";
    public static final String ERROR_MESSAGE_DISPLAYED = "xpath=//div[text()='Apply']/preceding-sibling::div";
    public static final String DISCOUNT_PRICE = "xpath=//div[text()='Promo code:']/following-sibling::div";

}
