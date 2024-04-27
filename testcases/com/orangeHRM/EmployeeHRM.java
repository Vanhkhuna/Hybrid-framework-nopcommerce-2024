package com.orangeHRM;

import commons.BaseTest;
import commons.LogHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.PIMPageObject;
import pageObjects.orangeHRM.PageGeneratorManager;

import java.util.Random;


public class EmployeeHRM extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    PIMPageObject pimPage;
    String firstName = "Jade " + getRandomNumber();
    String lastName = "Do";
    Random rand = new Random();
    String employeeID = String.valueOf(rand.nextInt(99999));
    String gpName = "GP.jpg";
    String driverLicenseNumber = "5566778899";
    String licenseExpiryDate = "2032-10-08";
    String dateofBirth = "1995-30-11";
    String nationality = "American";
    String maritalStatus = "Single";
    String street1 = "Thailand1";
    String postalCode = "55555";
    String phone1 = "0966833566";
    String phone2 = "0966833567";
    String phone3 = "0966833568";
    String workEmail = "PlayStudios@gmail.com";
    String name = "Rosen";
    String relationship = "Boy Friend";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.inputToUsernameTextbox("Admin");
        loginPage.inputToPasswordTextbox("admin123");
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Employee_01_Add_New_Employee() {
        LogHelper.info("PIM Page -Step 01 : open PIM Link");
        pimPage = dashboardPage.openPIMLink();
        sleepInSecond(3);
        LogHelper.info("PIM Page -Step 02 : click to Add Employee Button");
        pimPage.clickAddEmployeeButton();
        LogHelper.info("PIM Page -Step 03 : input to FirstName textbox");
        pimPage.inputToFirstNameTextbox(firstName);
        LogHelper.info("PIM Page -Step 04 : input to LastName textbox");
        pimPage.inputToLastNameTextbox(lastName);
        LogHelper.info("PIM Page -Step 05 : input to LastName textbox");
        pimPage.inputToEmployeeIDTextbox(employeeID);
        LogHelper.info("PIM Page -Step 06 : click to Save button");
        pimPage.clickSaveButton();
        LogHelper.info("PIM Page -Step 07 : verify success message displayed");
        Assert.assertTrue(pimPage.isSuccessMessageDisplayed("Successfully Saved"));
        LogHelper.info("PIM Page -Step 08 : verify information of firstname textbox displayed");
        Assert.assertTrue(pimPage.isFirstNameTextboxDisplayed(driver, firstName));
        LogHelper.info("PIM Page -Step 09 : verify information of lastname textbox displayed");
        Assert.assertTrue(pimPage.isLastNameTextboxDisplayed(driver, lastName));
        LogHelper.info("PIM Page -Step 10 : verify information of employee ID textbox displayed");
        Assert.assertTrue(pimPage.isEmployeeIDTextboxDisplayed(driver, employeeID));
    }

    @Test
    public void Employee_02_Upload_Avatar() {
        LogHelper.info("PIM Page -Step 01 : Click to Profile picture");
        pimPage.clickToProfilePicture();
        LogHelper.info("PIM Page -Step 02 : Upload file");
        // pimPage.clickToAddIcon();
        LogHelper.info("PIM Page -Step 03 : Upload file");
        pimPage.uploadMultipleFiles(driver, gpName);
        LogHelper.info("PIM Page -Step 04 : Verify file uploaded");
        Assert.assertTrue(pimPage.isDefaultPhotoUndisplayed());
        LogHelper.info("PIM Page -Step 05 : Click Save Button");
        pimPage.clickSaveButton();
        LogHelper.info("PIM Page -Step 06 : verify success message displayed");
        Assert.assertTrue(pimPage.isSuccessMessageDisplayed("Successfully Updated"));
    }

    @Test
    public void Employee_03_Personal_Details() {
        LogHelper.info("Personal Details -Step 01 : Open Personal Details Item");
        pimPage.openTabsItemByName(driver, "Personal Details");
        LogHelper.info("Personal Details -Step 02 : verify information of firstname textbox displayed");
        Assert.assertTrue(pimPage.isFirstNameTextboxDisplayed(driver, firstName));
        LogHelper.info("Personal Details -Step 03 : verify information of lastname textbox displayed");
        Assert.assertTrue(pimPage.isLastNameTextboxDisplayed(driver, lastName));
        LogHelper.info("Personal Details -Step 04 : verify information of employee ID textbox displayed");
        Assert.assertTrue(pimPage.isEmployeeIDTextboxDisplayed(driver, employeeID));
        LogHelper.info("Personal Details -Step 05 : Input to Textbox By Name");
        pimPage.inputToTextboxByName(driver, "Driver's License Number", driverLicenseNumber);
        pimPage.inputToTextboxByName(driver, "License Expiry Date", licenseExpiryDate);
        pimPage.inputToTextboxByName(driver, "Date of Birth", dateofBirth);
        LogHelper.info("Personal Details -Step 06 : Select dropdown by name");
        //pimPage.selectDropdownByName(driver, "Nationality", nationality);
        //pimPage.selectDropdownByName(driver, "Marital Status", maritalStatus);
        LogHelper.info("Personal Details -Step 07 : Click To Radio button");
        //pimPage.clickToRadioButtonByName(driver, "Female");
        LogHelper.info("Personal Details -Step 08 : Click to Save button");
        pimPage.clickSaveButton();
        LogHelper.info("Personal Details -Step 09 : verify success message displayed");
        Assert.assertTrue(pimPage.isSuccessMessageDisplayed("Successfully Updated"));
        LogHelper.info("Personal Details -Step 10 : verify all information displayed after update");
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Driver's License Number"), driverLicenseNumber);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "License Expiry Date"), licenseExpiryDate);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Date of Birth"), dateofBirth);
    }

    @Test
    public void Employee_04_Contact_Details() {
        LogHelper.info("Contact Details -Step 01 : Open Contact Details Item");
        pimPage.openTabsItemByName(driver, "Contact Details");
        LogHelper.info("Contact Details -Step 02 : Input to Textbox By Name");
        pimPage.inputToTextboxByName(driver, "Street 1", street1);
        pimPage.inputToTextboxByName(driver, "City", street1);
        pimPage.inputToTextboxByName(driver, "State/Province", street1);
        pimPage.inputToTextboxByName(driver, "Zip/Postal Code", postalCode);
        pimPage.inputToTextboxByName(driver, "Home", phone1);
        pimPage.inputToTextboxByName(driver, "Mobile", phone2);
        pimPage.inputToTextboxByName(driver, "Work", street1);
        pimPage.inputToTextboxByName(driver, "Work Email", workEmail);
        LogHelper.info("Contact Details -Step 03 : Select dropdown by name");
        //pimPage.selectDropdownByName(driver, "Country", nationality);
        LogHelper.info("Contact Details -Step 04 : Click to Save button");
        pimPage.clickSaveButton();
        LogHelper.info("Contact Details -Step 05 : verify success message displayed");
        Assert.assertTrue(pimPage.isSuccessMessageDisplayed("Successfully Updated"));
        LogHelper.info("Contact Details -Step 06 : verify all information displayed after update");
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Street 1"), street1);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "City"), street1);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "State/Province"), street1);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Zip/Postal Code"), postalCode);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Home"), phone1);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Mobile"), phone2);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Work"), street1);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Work Email"), workEmail);
    }

    @Test
    public void Employee_05_Emergency_Contacts() {
        LogHelper.info("Emergency Contacts -Step 01 : Open Emergency Contacts Item");
        pimPage.openTabsItemByName(driver, "Emergency Contacts");
        LogHelper.info("Emergency Contacts -Step 02 : Click to Add button");
        pimPage.clickToAddButtonByLabel(driver, "Assigned Emergency Contacts");
        LogHelper.info("Emergency Contacts -Step 03 : Input to Textbox By Name");
        pimPage.inputToTextboxByName(driver, "Name", name);
        pimPage.inputToTextboxByName(driver, "Relationship", relationship);
        pimPage.inputToTextboxByName(driver, "Home Telephone", phone3);
        LogHelper.info("Emergency Contacts -Step 04 : Click to Save button");
        pimPage.clickSaveButton();
        LogHelper.info("Emergency Contacts -Step 05 : verify success message displayed");
        Assert.assertTrue(pimPage.isSuccessMessageDisplayed("Successfully Saved"));
        LogHelper.info("Emergency Contacts -Step 06 : verify all information displayed after update");
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Name"), name);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Relationship"), relationship);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Home Telephone"), phone3);

    }

    @Test
    public void Employee_06_Assigned_Dependents() {
        LogHelper.info("Dependents -Step 01 : Open Employee_06_Dependents Item");
        pimPage.openTabsItemByName(driver, "Dependents");
        LogHelper.info("Dependents -Step 02 : Click to Add button");
        pimPage.clickToAddButtonByLabel(driver, "Assigned Dependents");
        LogHelper.info("Dependents -Step 03 : Input to Textbox By Name");
        pimPage.inputToTextboxByName(driver, "Name", name);
        pimPage.inputToTextboxByName(driver, "Date of Birth", dateofBirth);
        LogHelper.info("Dependents -Step 04 : Select dropdown by name");
        // pimPage.selectDropdownByName(driver, "Relationship", "Child");
        LogHelper.info("Dependents -Step 05 : Click to Save button");
        pimPage.clickSaveButton();
        LogHelper.info("Dependents -Step 06 : verify success message displayed");
        Assert.assertTrue(pimPage.isSuccessMessageDisplayed("Successfully Saved"));
        LogHelper.info("Dependents -Step 07 : verify all information displayed after update");
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Name"), name);
        Assert.assertEquals(pimPage.getTextboxValueByName(driver, "Date of Birth"), dateofBirth);


    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}

