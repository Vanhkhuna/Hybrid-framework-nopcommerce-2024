package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_01_Register {
    WebDriver driver = new ChromeDriver();

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;

    private String firstName, lastName, emailAddress, password;


    @BeforeClass
    public void beforeClass() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        homePage = new UserHomePageObject(driver);
        firstName = "Amazing";
        lastName = "Thailand";
        emailAddress = "jadeyy" + getRandomNumber() + "@gmail.com";
        password = "555555";
    }

    @Test
    public void Register_01_Empty_Data() {
        System.out.println("Register_01 - Step 1 : Click to Register link");
        homePage.clickToRegisterLink();

        registerPage = new UserRegisterPageObject(driver);
        System.out.println("Register_01 - Step 2 : Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_01 - Step 3 : Verify errors message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmTextbox(), "Password is required.");

    }

    @Test
    public void Register_02_Invalid_Email() {
        System.out.println("Register_02 - Step 1 : Click to Register link");
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_02 - Step 2 : Input to First Name Textbox");
        registerPage.senkeyToFirstNameTextbox(firstName);

        System.out.println("Register_02 - Step 3 : Input to Last Name Textbox");
        registerPage.senkeyToLastNameTextbox(lastName);

        System.out.println("Register_02 - Step 4 : Input to Email Textbox");
        registerPage.senkeyToEmailTextbox("dddddd@@gmail.com");

        System.out.println("Register_02 - Step 5 : Input to Password Textbox");
        registerPage.senkeyToPasswordTextbox(password);

        System.out.println("Register_02 - Step 6 : Input to Confirm Password Textbox");
        registerPage.senkeyToConfirmTextbox(password);

        System.out.println("Register_02 - Step 7 : Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_02 - Step 8 : Verify errors message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

    }

    @Test
    public void Register_03_Success() {
        System.out.println("Register_03 - Step 1 : Click to Register link");
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_03 - Step 2 : Input to First Name Textbox");
        registerPage.senkeyToFirstNameTextbox(firstName);

        System.out.println("Register_03 - Step 3 : Input to Last Name Textbox");
        registerPage.senkeyToLastNameTextbox(lastName);

        System.out.println("Register_03 - Step 4 : Input to Email Textbox");
        registerPage.senkeyToEmailTextbox(emailAddress);

        System.out.println("Register_03 - Step 5 : Input to Password Textbox");
        registerPage.senkeyToPasswordTextbox(password);

        System.out.println("Register_03 - Step 6 : Input to Confirm Password Textbox");
        registerPage.senkeyToConfirmTextbox(password);

        System.out.println("Register_03 - Step 7 : Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_03 - Step 8 : Verify success message displayed");
        Assert.assertEquals(registerPage.getSuccessMessageDisplayed(), "Your registration completed");
    }

    @Test
    public void Register_04_Email_Existing() {
        System.out.println("Register_04 - Step 1 : Click to Register link");
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_04 - Step 2 : Input to First Name Textbox");
        registerPage.senkeyToFirstNameTextbox(firstName);

        System.out.println("Register_04 - Step 3 : Input to Last Name Textbox");
        registerPage.senkeyToLastNameTextbox(lastName);

        System.out.println("Register_04 - Step 4 : Input to Email Textbox");
        registerPage.senkeyToEmailTextbox(emailAddress);

        System.out.println("Register_04 - Step 5 : Input to Password Textbox");
        registerPage.senkeyToPasswordTextbox(password);

        System.out.println("Register_04 - Step 6 : Input to Confirm Password Textbox");
        registerPage.senkeyToConfirmTextbox(password);

        System.out.println("Register_04 - Step 7 : Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_04 - Step 8 : Verify error message displayed");
        Assert.assertEquals(registerPage.getEmailExistErrorMessageDisplayed(), "The specified email already exists");
    }

    @Test
    public void Register_05_Password_Below_6_Characters() {
        System.out.println("Register_05 - Step 1 : Click to Register link");
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_05 - Step 2 : Input to First Name Textbox");
        registerPage.senkeyToFirstNameTextbox(firstName);

        System.out.println("Register_05 - Step 3 : Input to Last Name Textbox");
        registerPage.senkeyToLastNameTextbox(lastName);

        System.out.println("Register_05 - Step 4 : Input to Email Textbox");
        registerPage.senkeyToEmailTextbox(emailAddress);

        System.out.println("Register_05 - Step 5 : Input to Password Textbox");
        registerPage.senkeyToPasswordTextbox("6666");

        System.out.println("Register_05 - Step 6 : Input to Confirm Password Textbox");
        registerPage.senkeyToConfirmTextbox("6666");

        System.out.println("Register_05 - Step 7 : Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_05 - Step 8 : Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_06_Confirm_Password_Invalid() {
        System.out.println("Register_06 - Step 1 : Click to Register link");
        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_06 - Step 2 : Input to First Name Textbox");
        registerPage.senkeyToFirstNameTextbox(firstName);

        System.out.println("Register_06 - Step 3 : Input to Last Name Textbox");
        registerPage.senkeyToLastNameTextbox(lastName);

        System.out.println("Register_06 - Step 4 : Input to Email Textbox");
        registerPage.senkeyToEmailTextbox(emailAddress);

        System.out.println("Register_06 - Step 5 : Input to Password Textbox");
        registerPage.senkeyToPasswordTextbox(password);

        System.out.println("Register_06 - Step 6 : Input to Confirm Password Textbox");
        registerPage.senkeyToConfirmTextbox("666666");

        System.out.println("Register_06 - Step 7 : Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_06 - Step 8 : Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmTextbox(), "The password and confirmation password do not match.");
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
