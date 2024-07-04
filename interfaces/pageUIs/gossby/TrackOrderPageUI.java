package pageUIs.gossby;

public class TrackOrderPageUI {
    public static final String GURANTEED_DELIVERY_DATE = "xpath=//div[text()='Estimated delivery time']//span";
    public static final String GURANTEED_DELIVERY_PRICE = "xpath=//strong[text()='Shipping method']/following-sibling::div";
    public static final String PRODUCT_NAME = "xpath=//a[@title='Vanh - Auto test (please ko chỉnh sửa)']";
    public static final String PRODUCT_TYPE = "xpath=//a[@title='Vanh - Auto test (please ko chỉnh sửa)']/following-sibling::div[text()]";
    public static final String PRODUCT_PRICE = "xpath=//strong[text()='Total:']/following-sibling::strong";
    public static final String PRODUCT_QUANTITY = "xpath=//strong/preceding-sibling::span";
    public static final String EDIT_DESIGN_BUTTON = "xpath=//button[text()='Edit Design']";
    public static final String SUBTOTAL_UI = "xpath=//h3[text()='Subtotal: ']/following-sibling::span";
    public static final String PROMO_CODE_UI = "xpath=//span[text()='Promo code:']/parent::div/following-sibling::span";
    public static final String SHIPPING_UI = "xpath=//span[text()='Standard Shipping']/parent::h3/following-sibling::span";
    public static final String SHIPPING_METHOD = "xpath=//h3[text()='Shipping:']//span";
    public static final String TAX_UI = "xpath=//h3[text()='Tax:']/following-sibling::span";
    public static final String TIP_UI = "xpath=//h3[text()='Tip:']/following-sibling::span";
    public static final String EDIT_DESIGN_POPUP = "css=div.EditDesignModal_edit-design-modal__Lh37v";
    public static final String EDIT_ORDER_POPUP = "css=div.OrderDetail_modal__VO_P9";
    public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@aria-label='Cat']";
    public static final String OPTION_BY_DYNAMIC_FIELD = "xpath=//span[text()='%s']/ancestor::label/following-sibling::div[1]/div[5]//img";
    public static final String CAT_COLOR = "xpath=//span[text()='Cat Color']/ancestor::label/following-sibling::div[1]/div[5]//img";
    public static final String EXPRESSION = "xpath=//span[text()='Expression']/ancestor::label/following-sibling::div[1]/div[5]//img";
    public static final String CAT_SHIRT = "xpath=//span[text()='Cat Shirt']/ancestor::label/following-sibling::div[1]/div[5]//img";
    public static final String NAME_TEXTBOX = "xpath=//span[text()='Name']/ancestor::label/following-sibling::div//input";
    public static final String BUTTON_TEXT = "xpath=//button[text()='%s']";
    public static final String UPDATE_BUTTON = "xpath=//button[text()='Preview']/following-sibling::button";
    public static final String CONTACT_INFO = "xpath=//strong[text()='Contact information']/following-sibling::div";
    public static final String SHIPPING_ADDRESS_INDEX = "xpath=//strong[text()='Shipping address']/following-sibling::div//p[%s]";
    public static final String CLOSE_POPUP = "xpath=//strong[text()='Preview']/parent::div/preceding-sibling::div";
    public static final String INPUT_DYNAMIC_TEXTBOX_BY_NAME = "xpath=//input[@name='%s']";
    public static final String ORDER_EDITED_OR_CANCELLED_SUCCESSFULLY_MESSAGE = "xpath=//div[contains(@class,'Alert_alert__success')]//div[text()]";
    public static final String CANCEL_ORDER_DIALOG = "css=div.CancelOrderModal_modal__2Iiu9";
    public static final String REASON_DROPDOWN = "xpath=//h3[text()='Do you want to cancel the Order?']/following-sibling::div//select";
    public static final String TRACK_ORDER_BUTTON = "xpath=//button[text()='Track order']";
    public static final String ERROR_MESSAGE = "xpath=//input[@name='%s']/following-sibling::span";
    public static final String SORRY_MESSAGE = "xpath=//h3[text()='Track Order']/following-sibling::div[contains(@class,'Alert_alert__danger')]//div[text()]";
    public static final String TRACK_ORDER_ID = "xpath=//strong[text()='Track Order']/following-sibling::span[2]";
    public static final String ORDER_CANCELED_MESSAGE = "xpath=//div[contains(@class,'ShippingTimeLine_success')]/following-sibling::div//div[text()]";
    public static final String CONTINUE_SHOPPING_LINK = "xpath=//div[text()='Continue Shopping']";


}
