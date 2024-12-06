package pageUIs.gossby;

public class CheckoutPageUI {
    public static final String PLACE_YOUR_ORDER_BUTTON = "xpath=//button[@aria-label='Place Your Order']";
    public static final String ERROR_MESSAGE_AT_EMAIL_ADDRESS_FIELD = "xpath=//input[@name='shipping_address.phone']/parent::div/preceding-sibling::span";
    public static final String ERROR_MESSAGE_AT_PHONE_FIELD = "xpath=//span[text()='Phone']/parent::div/following-sibling::div[1]/span";
    public static final String ERROR_MESSAGE_AT_PROVINCE_FIELD = "xpath=//select[@name='shipping_address.province_code']/ancestor::div/following-sibling::span";
    public static final String ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_ID = "xpath=//input[@id='%s']/parent::div/following-sibling::span[1]";
    public static final String DYNAMIC_TEXTBOX_BY_NAME = "xpath=//input[@name='%s']";
    public static final String PROVINCE_DROPDOWN = "xpath=//select[@name='shipping_address.province_code']";
    public static final String ERROR_MESSAGE_AT_CARD_FIELD = "xpath=//div[@id='stripe-card-element']/following-sibling::span";
    public static final String CARD_TEXTBOX = "xpath=//input[@name='cardnumber']";
    public static final String IFRAME_ELEMENT = "xpath=//iframe[@title='Secure card payment input frame']";
    public static final String EXPIRED_DATE_TEXTBOX = "xpath=//input[@placeholder='MM / YY']";
    public static final String CVC_TEXTBOX = "xpath=//input[@placeholder='CVC']";
    public static final String CHECKOUT_SUCCESSFULLY_MESSAGE = "css=div#content-page h4";
    public static final String PRODUCT_NAME = "xpath=//a[@title='Vanh - Auto test (please ko chỉnh sửa)']";
    public static final String PRODUCT_TYPE = "xpath=//a[@title='Vanh - Auto test (please ko chỉnh sửa)']/following-sibling::div//span";
    public static final String PRODUCT_QUANTITY_COMPARE = "xpath=//div[text()='Shipping:']/parent::div/preceding-sibling::div[2]";
    public static final String SHIPPING_COUNTRY = "xpath=//div[text()='Billing Address']/preceding-sibling::div[1]";
    public static final String STANDARD_SHIPPING_CHECKBOX = "xpath=//input[@id='radio-standard_shipping']";
    public static final String TAX_PRICE_UI = "xpath=//div[text()='Tax:']/following-sibling::div";
    public static final String SUBTOTAL_PRICE = "xpath=//div[text()='Shipping:']/parent::div/preceding-sibling::div[2]//div[2]";
    public static final String SHIPPING = "xpath=//div[text()='Shipping:']/following-sibling::div";
    public static final String TIP_OPTION = "xpath=//div[text()='Custom']/parent::div/preceding-sibling::div[2]//div[@class='font-semibold']";
    public static final String TIP_UI = "xpath=//div[text()='Tip:']/following-sibling::div";
    public static final String DISCOUNT_UI = "xpath=//div[text()='Promo code:']/following-sibling::div";
    public static final String TOTAL_UI = "xpath=//b[text()='Total:']/following-sibling::div/b";
    public static final String PRODUCT_PRICE_ORIGINAL = "xpath=//h2[text()='Order Summary']/parent::div/following-sibling::div//strong";
    public static final String PRODUCT_QUANTITY = "xpath=//div[text()='Subtotal:']//span";
    public static final String GUARANTEED_DELIVERY_DATE = "xpath=//div[text()='Delivery']/following-sibling::div";
    public static final String GUARANTEED_DELIVERY_PRICE = "xpath=//span[text()='late delivery']/preceding-sibling::span[2]";
    public static final String PROMO_CODE = "xpath=//div[text()='Promo code:']/following-sibling::div";
    public static final String PHONE_COMPARE = "xpath=//input[@name='shipping_address.phone']/preceding-sibling::div//div//div";

}
