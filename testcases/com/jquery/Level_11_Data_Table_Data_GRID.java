package com.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.dataTable.HomePageObject;
import pageObjects.jquery.dataTable.PageGeneratorManager;


import java.util.List;

public class Level_11_Data_Table_Data_GRID extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    List<String> allValues;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        // driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
        homePage = PageGeneratorManager.getUserHomePage(driver);

    }

    // @Test
    public void Table_01_Paging() {
        homePage.openPagingByPageNumber("10");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("10"));

        homePage.openPagingByPageNumber("5");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("5"));

        homePage.openPagingByPageNumber("19");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("19"));
    }

    //@Test
    public void Table_02_Enter_To_Header() {
        homePage.refreshCurrentPage(driver);
        homePage.enterToHeaderTextboxByLabel("Country", "AFRICA");
        homePage.enterToHeaderTextboxByLabel("Females", "12253515");
        homePage.enterToHeaderTextboxByLabel("Total", "24853148");


    }

    // @Test
    public void Table_03_Enter_To_Header() {
        homePage.refreshCurrentPage(driver);
        allValues = homePage.getValueEachRowAtPage();


    }

    @Test
    public void Table_04_Action_At_Any_Row() {
        driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.clickToLoadButton();
        homePage.sleepInSecond(5);
        homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "Play");
        homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "1", "Tank");
        homePage.slectDropdownByColumnNameAtRowNumber("Country", "1", "Japan");
        homePage.sleepInSecond(2);
        homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
        homePage.sleepInSecond(2);
        homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
        homePage.sleepInSecond(2);
        homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "1", "555");
        homePage.sleepInSecond(2);
        homePage.clickToIconBAtRowNumber("1", "Insert Row Above");
        homePage.sleepInSecond(2);
        homePage.clickToIconBAtRowNumber("3", "Remove Current Row");
        homePage.sleepInSecond(2);
        homePage.clickToIconBAtRowNumber("5", "Move Up");
        homePage.sleepInSecond(2);
        homePage.clickToIconBAtRowNumber("4", "Move Down");
        homePage.sleepInSecond(2);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
