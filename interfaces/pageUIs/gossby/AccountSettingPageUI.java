package pageUIs.gossby;

public class AccountSettingPageUI {
    public static final String EMAIL_DISPLAYED = "xpath=//div[text()='Email:']/following-sibling::div//span";
    public static final String INPUT_TEXTBOX_BY_NAME = "xpath=//input[@name='%s']";
    public static final String DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
    public static final String ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_NAME_MY_PROFILE = "xpath=//input[@name='%s']/following-sibling::span[text()]";
    public static final String SAVE_BUTTON = "xpath=//button[text()='Save']";
    public static final String MESSAGE_AFTER_CHANGE_INFORMATION_DISPLAYED = "xpath=(//div[contains(@class,'Alert_alert__success')]//span[text()])[2]";
    public static final String EDIT_EMAIL_LINK = "xpath=//div[text()='Email:']/following-sibling::div//u";
    public static final String CHANGE_EMAIL_POPUP = "xpath=//div[contains(@class,'AccountSetting_change-email-modal')]";
    public static final String BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
    public static final String RADIO_BUTTON_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::div//input";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@name='new_email']";
    public static final String ERROR_MESSAGE_AT_EMAIL_FIELD = "xpath=//input[@id='email']/parent::div/following-sibling::span";
    public static final String CHANGE_PASSWORD_LINK = "xpath=//span[text()='Change password']";
    public static final String CHANGE_MY_PASSWORD_HEADER = "xpath=//button[@type='button']/following-sibling::span";
    public static final String ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_NAME_CHANGE_PASSWORD = "xpath=//input[@name='%s']/parent::div/following-sibling::span[text()]";
    public static final String BACK_BUTTON = "xpath=//span[text()='Back']";
    public static final String ADD_NEW_ADDRESS_POPUP = "css=div.AccountSetting_editAddressModal__8Ywx6";
    public static final String ADD_NEW_ADDRESS_BUTTON = "xpath=//span[text()='Add New Address']";
    public static final String ERROR_MESSAGE_AT_FULL_NAME_FIELD = "xpath=//input[@id='new_address.city']/parent::div/preceding-sibling::span";
    public static final String ERROR_MESSAGE_AT_PHONE_FIELD = "xpath=//span[text()='Phone']/parent::div/following-sibling::div[1]/span";
    public static final String ERROR_MESSAGE_AT_PROVINCE_FIELD = "xpath=//input[@id='new_address.zip']/parent::div/parent::div/preceding-sibling::div//span[text()]";
    public static final String ERROR_MESSAGE_AT_DYNAMIC_FIELD_BY_ID = "xpath=//input[@id='%s']/parent::div/following-sibling::span";
    public static final String DEFAULT_CHECKBOX = "xpath=//div[contains(@class,'Checkbox_checkbox')]/parent::label";
    public static final String DYNAMIC_TEXTBOX_BY_NAME = "xpath=//input[@name='%s']";
    public static final String SAVE_BUTTON_AT_ADD_ADDRESS_POPUP = "xpath=//div[contains(@class,'AccountSetting_editAddressModal')]//button[text()='Save']";
    public static final String CHANGE_COUNTRY_DROPDOWN = "xpath=//select[@name='new_address.country_code']";
    public static final String PROVINCE_DROPDOWN = "xpath=//select[@name='new_address.province_code']";
    public static final String VERIFY_DEFAULT_STATE = "xpath=//p[text()='%s']/parent::div/following-sibling::div//span";
    public static final String DELETE_DEFAULT_ADDRESS = "xpath=//span[text()='Default Address']/parent::div/following-sibling::div";
    public static final String REMOVE_ADDRESS_POPUP = "xpath=//div[text()='Do you want to remove this address?']/parent::div[contains(@class,'AccountSetting_modal')]";
    public static final String CHANGE_DEFAULT_ADDRESS = "xpath=//span[text()='Default Address']/parent::div/following-sibling::button";
    public static final String CHANGE_BUTTON_AT_CHANGE_ADDRESS_POPUP = "xpath=//label[@for='new_address.city']/parent::div/following-sibling::div//button[text()='Change']";
    public static final String DELETE_ADDRESS_AFTER_CHANGE_STATE = "xpath=//p[text()='%s']/parent::div/following-sibling::div//div";
    public static final String CHANGE_BUTTON_AFTER_CHANGE_STATE = "xpath=//p[text()='%s']/parent::div/following-sibling::div//button";
    public static final String ADDRESS_DISPLAY_AFTER_DELETE = "xpath=//p[text()='%s']";
    public static final String DELETE_BUTTON = "xpath=//button[text()='Delete']";
}