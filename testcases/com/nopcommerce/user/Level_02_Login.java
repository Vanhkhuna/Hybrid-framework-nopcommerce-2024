package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_02_Login {
    WebDriver driver = new ChromeDriver();

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;

    private String existingEmailAddress, invalidEmailAddress, incorrectEmailAddress, firstName, lastName, password, incorrectPassword;


    @BeforeClass
    public void beforeClass() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        homePage = new UserHomePageObject(driver);
        homePage.clickToRegisterLink();
        firstName = "Jade";
        lastName = "Do";
        existingEmailAddress = "jadeyy" + getRandomNumber() + "@gmail.com";
        incorrectEmailAddress = "jadey@gmail.com";
        invalidEmailAddress = "jade@@mail.com";
        password = "555555";
        incorrectPassword = "555556";
        registerPage = new UserRegisterPageObject(driver);
        registerPage.senkeyToFirstNameTextbox(firstName);
        registerPage.senkeyToLastNameTextbox(lastName);
        registerPage.senkeyToEmailTextbox(existingEmailAddress);
        registerPage.senkeyToPasswordTextbox(password);
        registerPage.senkeyToConfirmTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getSuccessMessageDisplayed(), "Your registration completed");

    }

    @Test
    public void Login_01_Empty_Data() {
        System.out.println("Login_01 - Step 1 : Click to Login link");
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);
        System.out.println("Login_01 - Step 2 : Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_01 - Step 3 : Verify errors message displayed");
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

    }

    @Test
    public void Login_02_Invalid_Email() {
        System.out.println("Login_02 - Step 1 : Click to Login link");
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);
        System.out.println("Login_02 - Step 2 : Input to Email textbox");
        loginPage.inputToEmailTextbox(invalidEmailAddress);

        System.out.println("Login_02 - Step 3 : Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_02 - Step 4 : Verify errors message displayed");
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),
                "Wrong email");
    }

    @Test
    public void Login_03_Incorrect_Email() {
        System.out.println("Login_03 - Step 1 : Click to Login link");
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);
        System.out.println("Login_03 - Step 2 : Input to Email textbox");
        loginPage.inputToEmailTextbox(incorrectEmailAddress);

        System.out.println("Login_03 - Step 3 : Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_03 - Step 4 : Verify errors message displayed");
        Assert.assertEquals(loginPage.getErrorMessageDisplayed(),
                "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

    }

    @Test
    public void Login_04_Email_Existing() {
        System.out.println("Login_04 - Step 1 : Click to Login link");
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);
        System.out.println("Login_04 - Step 2 : Input to Email textbox");
        loginPage.inputToEmailTextbox(existingEmailAddress);

        System.out.println("Login_04 - Step 3 : Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_04 - Step 4 : Verify errors message displayed");
        Assert.assertEquals(loginPage.getErrorMessageDisplayed(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void Login_05_Invalid_Password() {
        System.out.println("Login_04 - Step 1 : Click to Login link");
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);
        System.out.println("Login_04 - Step 2 : Input to Email textbox");
        loginPage.inputToEmailTextbox(existingEmailAddress);

        System.out.println("Login_04 - Step 3 : Input to Password textbox");
        loginPage.inputToPasswordTextbox(incorrectPassword);

        System.out.println("Login_04 - Step 4 : Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_04 - Step 5 : Verify errors message displayed");
        Assert.assertEquals(loginPage.getErrorMessageDisplayed(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void Login_06_Success() {
        System.out.println("Login_04 - Step 1 : Click to Login link");
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);
        System.out.println("Login_04 - Step 2 : Input to Email textbox");
        loginPage.inputToEmailTextbox(existingEmailAddress);

        System.out.println("Login_04 - Step 3 : Input to Password textbox");
        loginPage.inputToPasswordTextbox(password);

        System.out.println("Login_04 - Step 4 : Click to Login button");
        loginPage.clickToLoginButton();


    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
