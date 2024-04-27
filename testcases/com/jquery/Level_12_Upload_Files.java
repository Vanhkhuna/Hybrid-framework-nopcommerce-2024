package com.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.uploadFile.HomePageObject;
import pageObjects.jquery.uploadFile.PageGeneratorManager;


public class Level_12_Upload_Files extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    String gpName = "GP.jpg";
    String iosName = "iOS.png";
    String loName = "LO_R4.png";
    String rcyName = "RCY_R3.png";
    String[] multipleFileName = {gpName, iosName, loName, rcyName};


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        homePage = PageGeneratorManager.getHomePage(driver);
    }


    @Test
    public void Upload_01_One_File_Per_Time() {
        homePage.uploadMultipleFiles(driver, gpName);
        Assert.assertTrue(homePage.isFileLoadedByName(gpName));
        homePage.clickToStartButton();
        Assert.assertTrue(homePage.isFileLinkUploadedByName(gpName));
        Assert.assertTrue(homePage.isFileImageUploadedByName(gpName));
    }

    @Test
    public void Upload_02_Multiple_File_Per_Time() {
        homePage.refreshCurrentPage(driver);
        homePage.uploadMultipleFiles(driver, multipleFileName);
        Assert.assertTrue(homePage.isFileLoadedByName(gpName));
        Assert.assertTrue(homePage.isFileLoadedByName(iosName));
        Assert.assertTrue(homePage.isFileLoadedByName(loName));
        Assert.assertTrue(homePage.isFileLoadedByName(rcyName));
        homePage.clickToStartButton();
        Assert.assertTrue(homePage.isFileLinkUploadedByName(gpName));
        Assert.assertTrue(homePage.isFileLinkUploadedByName(iosName));
        Assert.assertTrue(homePage.isFileLinkUploadedByName(loName));
        Assert.assertTrue(homePage.isFileImageUploadedByName(rcyName));
        Assert.assertTrue(homePage.isFileImageUploadedByName(gpName));
        Assert.assertTrue(homePage.isFileImageUploadedByName(iosName));
        Assert.assertTrue(homePage.isFileImageUploadedByName(loName));
        Assert.assertTrue(homePage.isFileImageUploadedByName(rcyName));
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
