package pageUIs.nopCommerce.user;

public class BasePageUI {
    public static final String ADDRESSES_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
    public static final String MY_PRODUCT_REVIEWS_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
    public static final String REWARD_POINTS_PAGE = "XPath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
    public static final String ORDERS_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Orders']";
    public static final String UPLOAD_FILE = "xpath=//input[@type='file']";

    public static final String LOGOUT_LINK_AT_USER_PAGE = "class=ico-logout";
    public static final String LOGOUT_LINK_AT_ADMIN_PAGE = "XPATH=//a[text()='Logout']";


    //Patter Object
    public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
    public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
    public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
}
