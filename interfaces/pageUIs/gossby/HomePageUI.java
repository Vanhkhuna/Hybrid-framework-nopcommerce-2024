package pageUIs.gossby;

public class HomePageUI {
    public static final String SIGNIN_SIGNUP_BUTTON = "xpath=//span[@title='%s']";
    public static final String CREAT_YOUR_ACCOUNT_BUTTON = "xpath=//span[text()='Create Your Account']";
    public static final String ERROR_MESSAGE_AT_EMAIL_FIELD = "xpath=//input[@id='email']/parent::div//following-sibling::span[1]";
    public static final String ERROR_MESSAGE_AT_PASSWORD_FIELD_SIGN_UP = "xpath=//input[@id='password']/parent::div/parent::div/following-sibling::span[1]";
    public static final String ERROR_MESSAGE_AT_CONFIRM_FIELD_SIGN_UP = "xpath=//input[@id='confirm_password']/parent::div/parent::div/following-sibling::span";
    public static final String DYNAMIC_TEXTBOX_FIELD = "xpath=//input[@id='%s']";
    public static final String VERIFICATION_BUTTON = "xpath=//button[text()='%s']";
    public static final String SIGN_IN_LINK = "xpath=//button[text()='Resend Verification Email']/parent::div/following-sibling::div/span";
    public static final String ERROR_MESSAGE_AT_EMAIL_FIELD_SIGN_IN = "xpath=//input[@id='password']/ancestor::div[@class='relative']/preceding-sibling::span";
    public static final String ERROR_MESSAGE_AT_PASS_FIELD_SIGN_IN = "xpath=//input[@id='password']/ancestor::div[@class='relative']/following-sibling::span";
    public static final String SIGN_IN_POPUP = "css=div.ReactModal__Content--after-open";
    public static final String ACCOUNT_BUTTON = "xpath=//a[@title='Account']//p";

}
