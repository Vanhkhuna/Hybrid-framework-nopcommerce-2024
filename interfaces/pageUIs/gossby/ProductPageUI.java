package pageUIs.gossby;

public class ProductPageUI {
    public static final String SIGNIN_BUTTON = "xpath=//span[@title='Sign in']";
    public static final String EMAIL_TEXTBOX = "css=input#username";
    public static final String PASSWORD_TEXTBOX = "css=input#password";
    public static final String SUBMIT_BUTTON = "xpath=//button[@type='submit' and text()='Sign In']";
    public static final String CHANGE_COUNTRY_BUTTON = "xpath=//a[@title='Blog']/following-sibling::div";
    public static final String DROPDOWN = "xpath=//span[text()='Vietnam']/ancestor::div[@class='relative']";
    public static final String DROPDOWN_CONTRIBUTE = "css=div#US";
    public static final String SAVE_BUTTON = "xpath=//button[text()='Save & Continue']";
    public static final String PRODUCT_NAME = "css=div.relative h1";
    public static final String PRODUCT_PRICE = "xpath=//button[@title='More like this']/parent::div/following-sibling::div//h2";
    public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@aria-label='Cat']";
    public static final String ADD_TO_CART_BUTTON = "xpath=//button[@id='gtag_preview_at_product_normal']/following-sibling::button";
    public static final String CLOSE_BUTTON_IN_POPUP = "xpath=//div[@aria-label='POPUP Form']//button[@aria-label='Close dialog 3']";
    public static final String PRODUCT_GIFT = "xpath=//input[@type='checkbox']/ancestor::label//div//div//span[@class='font-semibold']";

}
