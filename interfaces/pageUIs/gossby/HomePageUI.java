package pageUIs.gossby;

public class HomePageUI {
    public static final String SIGNIN_BUTTON = "xpath=//span[@title='Sign in']";
    public static final String EMAIL_TEXTBOX = "css=input#username";
    public static final String PASSWORD_TEXTBOX = "css=input#password";
    public static final String SUBMIT_BUTTON = "xpath=//button[@type='submit' and text()='Sign In']";
    public static final String CHANGE_COUNTRY_BUTTON = "xpath=//a[@title='Blog']/following-sibling::div";
    public static final String DROPDOWN = "xpath=//div[@class='relative']//span[text()='Select your country']";
    public static final String DROPDOWN_CONTRIBUTE = "css=div#US";
    public static final String SAVE_BUTTON = "xpath=//button[text()='Save & Continue']";
    public static final String MUG_COLLECTION_LINK = "xpath=//h3[text()='Mug']";
    public static final String POPUP_DISCOUNT_DISPLAYED = "xpath=//div[@aria-label='POPUP Form']";
    public static final String CLOSE_BUTTON_IN_POPUP = "xpath=//div[@aria-label='POPUP Form']//button[@aria-label='Close dialog 3']";
}
