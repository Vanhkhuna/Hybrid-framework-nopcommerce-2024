package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_03_Multibrowser extends BaseTest {

    WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;

    private String firstName, lastName, emailAddress, password;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
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

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    @AfterClass
    public void afterClass() {
        // driver.quit();
    }
}
