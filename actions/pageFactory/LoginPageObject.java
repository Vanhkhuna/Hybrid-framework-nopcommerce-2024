package pageFactory;

import commons.BasePageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @CacheLookup // khong tim element lai nhieu lan trong ham
    @FindBy(id = "Email")
    private WebElement emailTextbox;
    @FindBy(id = "Password")
    private WebElement passwordTextbox;
    @FindBy(xpath = "//button[@class='button-1 login-button']")
    private WebElement loginButton;
    @FindBy(id = "Email-error")
    private WebElement emailErrorMessage;
    @FindBy(xpath = "//div[contains(@class,'message-error')]")
    private WebElement unsuccessErrorMessage;

    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(driver, loginButton);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, emailErrorMessage);
        return getElementText(driver, emailErrorMessage);
    }

    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        senkeyToElement(driver, emailTextbox, emailAddress);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        senkeyToElement(driver, passwordTextbox, password);
    }

    public String getErrorMessageDisplayed() {
        waitForElementVisible(driver, unsuccessErrorMessage);
        return getElementText(driver, unsuccessErrorMessage);
    }

}
