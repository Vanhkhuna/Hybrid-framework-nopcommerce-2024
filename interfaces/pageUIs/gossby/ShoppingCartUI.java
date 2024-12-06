package pageUIs.gossby;

public class ShoppingCartUI {
    public static final String PRODUCT_NAME = "xpath=//div[contains(text(),'Product type')]/preceding-sibling::a";
    public static final String PRODUCT_TYPE = "xpath=//a[@title='Vanh - Auto test (please ko chỉnh sửa)']/following-sibling::div";
    public static final String PRODUCT_PRICE = "xpath=//div[contains(text(),'Product type')]/ancestor::div/following-sibling::div//strong";
    public static final String ADDED_PRODUCT_TO_YOUR_CART = "xpath=//div[contains(@class,'Alert_alert__success')]//span";
    public static final String QUANITY_SHOPPING_CART_DISPLAY = "xpath=//div[@id='content-page']//h3[contains(text(),'Shopping Cart')]";
    public static final String QUANITY_PRODUCT_IN_CART = "xpath=//a[@data-title='Cart']//div//div";
    public static final String ADD_GIFT_PACK_CHECKBOX = "xpath=//p[text()='This is our attached service']/preceding-sibling::label//input";
    public static final String TOTAL_PRICE = "xpath=//div[text()='Total:']//span";
    public static final String CHANGE_COUNTRY_LINK = "xpath=//span[text()='Change']";
    public static final String CHANGE_COUNTRY_DROPDOWN = "xpath=//div[text()='Select your shipping country']/following-sibling::div[1]";
    public static final String CHOOSE_COUNTRY = "css=div.SearchSelect_dropdownMenu__MaqSx div";
    public static final String SAVE_BUTTON = "xpath=//button[@type='button' and text()='Save & Continue']";
    public static final String COUNTRY_AFTER_CHANGED_DISPLAYED = "xpath=//span[text()='Change']/preceding-sibling::span";
    public static final String PLUS_BUTTON = "xpath=//input[@id='quantity-input']/following-sibling::div";
    public static final String MINUS_BUTTON = "xpath=//input[@id='quantity-input']/preceding-sibling::div";
    public static final String PRODUCT_UPDATED_MESSAGE = "xpath=//div[contains(@class,'Alert_alert__success')]//span";
    public static final String PRODUCT_PRICE_ORIGINAL = "xpath=//input[@id='quantity-input']/ancestor::div//strong";
    public static final String PROMO_CODE_TEXTBOX = "xpath=//input[@placeholder='Enter your Promo Code']";
    public static final String APPLY_BUTTON = "xpath=//div[text()='Apply']";
    public static final String ERROR_MESSAGE_DISPLAYED = "xpath=//div[text()='Apply']/preceding-sibling::div";
    public static final String DISCOUNT_PRICE = "xpath=//div[text()='Promo code:']/following-sibling::div";
    public static final String SECURE_CHECKOUT = "xpath=//div[text()='Secure Checkout']";
    public static final String COUNTRY_NOT_SUPPORT_MESSAGE = "xpath=//button[text()='Remove']/preceding-sibling::p//span";
    public static final String PRODUCT_QUANTITY = "xpath=//div[text()='Promo code:']/parent::div/preceding-sibling::div[1]";
    public static final String DISCOUNT_CODE_APPLIED_MESSAGE = "xpath=//div[contains(@class,'text-green')]";
    public static final String PRICE_GIFT = "xpath=//input[@type='checkbox']/ancestor::label//div//div//span[@class='font-semibold']";


}
