package com.nopAdmin;

import commons.BaseTest;
import commons.LogHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopAdmin.CustomerPageObject;
import pageObjects.nopAdmin.DashboardPageObject;
import pageObjects.nopAdmin.LoginPageObject;
import pageObjects.nopAdmin.PageGeneratorManager;


public class NopAdminTestcase extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    CustomerPageObject customerPage;
    String actualRowValues;
    String email = "jee" + getRandomNumber() + "@gmail.com";
    String firstName = "Happy";
    String lastName = "Doo" + getRandomNumber();
    String companyName = "Plays";
    String expectRowValues = email + " " + firstName + " " + lastName + " Registered " + companyName + " Edit";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        LogHelper.info("Precondition -Step 01 : Input to Email textbox");
        loginPage.inputToEmailTextbox("admin@yourstore.com");
        LogHelper.info("Precondition -Step 02 : Input to Password textbox");
        loginPage.inputPasswordTextbox("admin");
        LogHelper.info("Precondition -Step 03 : Click to Login Button");
        dashboardPage = loginPage.clickToLoginButton();
        Assert.assertTrue(dashboardPage.waitForAjaxBusyLoadingInvisible());

    }

    @Test
    public void TC_01_Customer_Add_New() {
        LogHelper.info("Customer Page -Step 01 : Open Customer Page");
        dashboardPage.clickToCustomerMenu();
        customerPage = dashboardPage.clickToCustomerListLink();
        Assert.assertTrue(customerPage.waitForAjaxBusyLoadingInvisible());
        LogHelper.info("Customer Page -Step 02 : Open Customer Page");
        customerPage.clickToAddNewButton();
        LogHelper.info("Customer Page -Step 03 : Input information to textbox by ID");
        customerPage.inputToTextboxByID(driver, "Email", email);
        customerPage.inputToTextboxByID(driver, "Password", "Huongmuahe");
        customerPage.inputToTextboxByID(driver, "FirstName", firstName);
        customerPage.inputToTextboxByID(driver, "LastName", lastName);
        customerPage.clickToRadioCheckboxByID(driver, "Gender_Female");
        customerPage.inputToTextboxByID(driver, "DateOfBirth", "11/30/1994");
        customerPage.inputToTextboxByID(driver, "Company", companyName);
        customerPage.inputToCustomerTextbox("Administrators");
        customerPage.inputToCommentTextbox("Add New Customer: " + firstName + lastName);
        customerPage.clickToSaveButton();
        Assert.assertTrue(customerPage.waitForAjaxBusyLoadingInvisible());
        LogHelper.info("Customer Page -Step 04 : Verify Added New Customer Success Message Displayed");
        Assert.assertTrue(customerPage.isAddedNewCustomerSuccessMessageDisplayed("The new customer has been added successfully."));
        LogHelper.info("Customer Page -Step 05 : Input To Email textbox at Customer List Page");
        customerPage.inputEmailTextbox(email);
        LogHelper.info("Customer Page -Step 06 : Click To Search button");
        customerPage.clickToSearchButton();
        Assert.assertTrue(customerPage.waitForAjaxBusyLoadingInvisible());
        LogHelper.info("Customer Page -Step 07 : Verify New Cutomer Information is correctly");
        Assert.assertTrue(customerPage.waitForAjaxBusyLoadingInvisible());
        actualRowValues = String.valueOf(customerPage.getValueRowAtTable());
        Assert.assertEquals(actualRowValues, expectRowValues);
        LogHelper.info("Customer Page -Step 08 : Click to Edit button");
        customerPage.clickToEditButton();
        Assert.assertTrue(customerPage.waitForAjaxBusyLoadingInvisible());
        LogHelper.info("Customer Page -Step 09 : Click to Delete button");
        customerPage.clickToDeleteButton();
        Assert.assertTrue(customerPage.waitForAjaxBusyLoadingInvisible());
        LogHelper.info("Customer Page -Step 10 : Verify Delete dialog displayed");
        Assert.assertTrue(customerPage.isDeleteDialogDisplayed());
        LogHelper.info("Customer Page -Step 11 : Verify Delete dialog displayed");
        customerPage.clickToDeleteButtonAtDialog();
        LogHelper.info("Customer Page -Step 12 : Verify Delete Customer Success Message Displayed");
        Assert.assertTrue(customerPage.isDeletedCustomerSuccessMessageDisplayed("The customer has been deleted successfully."));
        LogHelper.info("Customer Page -Step 13 : Input To Email textbox at Customer List Page");
        customerPage.inputEmailTextbox(email);
        LogHelper.info("Customer Page -Step 14 : Click To Search button");
        customerPage.clickToSearchButton();
        Assert.assertTrue(customerPage.waitForAjaxBusyLoadingInvisible());
        LogHelper.info("Customer Page -Step 15 : Verify Data Table empty");
        Assert.assertTrue(customerPage.isNoDataMessageDisplayed("No data available in table"));

    }

    
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserDriver();
    }
}
