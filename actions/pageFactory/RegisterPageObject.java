package pageFactory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "FirstName")
    private WebElement firstNameTextbox;
    @FindBy(id = "LastName")
    private WebElement lastNameTextbox;
    @FindBy(id = "Email")
    private WebElement emailTextbox;
    @FindBy(id = "Password")
    private WebElement passwordTextbox;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextbox;
    @FindBy(id = "register-button")
    private WebElement registerButton;
    @FindBy(id = "FirstName-error")
    private WebElement firstNameErrorMessage;
    @FindBy(id = "LastName-error")
    private WebElement lastNameErrorMessage;
    @FindBy(id = "Email-error")
    private WebElement emailErrorMessage;
    @FindBy(id = "Password-error")
    private WebElement passwordMessage;
    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmPasswordMessage;
    @FindBy(xpath = "//div[@class='result']")
    private WebElement registerSuccessMessage;
    @FindBy(xpath = "//div[contains(@class,'message-error')]")
    private WebElement emailExistingErrorMessage;

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public String getErrorMessageAtFirstnameTextbox() {
        waitForElementVisible(driver, firstNameErrorMessage);
        return getElementText(driver, firstNameErrorMessage);
    }

    public String getErrorMessageAtLastnameTextbox() {
        waitForElementVisible(driver, lastNameErrorMessage);
        return getElementText(driver, lastNameErrorMessage);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, emailErrorMessage);
        return getElementText(driver, emailErrorMessage);
    }

    public String getErrorMessageAtPasswordTextbox() {
        waitForElementVisible(driver, passwordMessage);
        return getElementText(driver, passwordMessage);
    }

    public String getErrorMessageAtConfirmTextbox() {
        waitForElementVisible(driver, confirmPasswordMessage);
        return getElementText(driver, confirmPasswordMessage);
    }

    public void senkeyToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, firstNameTextbox);
        senkeyToElement(driver, firstNameTextbox, firstName);
    }

    public void senkeyToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastNameTextbox);
        senkeyToElement(driver, lastNameTextbox, lastName);
    }

    public void senkeyToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        senkeyToElement(driver, emailTextbox, emailAddress);
    }

    public void senkeyToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        senkeyToElement(driver, passwordTextbox, password);
    }

    public void senkeyToConfirmTextbox(String password) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        senkeyToElement(driver, confirmPasswordTextbox, password);
    }

    public String getSuccessMessageDisplayed() {
        waitForElementVisible(driver, registerSuccessMessage);
        return getElementText(driver, registerSuccessMessage);
    }

    public String getEmailExistErrorMessageDisplayed() {
        waitForElementVisible(driver, emailExistingErrorMessage);
        return getElementText(driver, emailExistingErrorMessage);
    }
}
