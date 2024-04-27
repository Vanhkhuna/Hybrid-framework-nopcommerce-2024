package com.wordpress.admin;

import commons.BaseTest;
import commons.LogHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.wordpress.admin.*;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
    WebDriver driver;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private AdminPostSearchPO adminPostSearchPage;
    private AdminPostAddNewPO adminPostAddNewPage;
    private UserHomePO userHomePage;
    private UserPostDetailPO userPostDetailPage;
    private UserSearchPostPO userSearchPostPage;
    String adminUrl = "http://localhost:8080/wordpress/wp-admin/";
    String endUserUrl = "http://localhost:8080/wordpress/";
    String searchPostUrl;
    String authorName = "Thuydood";
    String adminUsername = "Thuydood";
    String adminPassword = "Kevildebruyne@55";
    String postTitle = "Amazing Thailand Title " + getRandomNumber();
    String editPostTitle = "Edit Amazing Thailand Title " + getRandomNumber();
    String currentDay = getCurrentDay();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        LogHelper.info("Precondition - Step 01 : Open browser and Admin site");
        driver = getBrowserDriver(browserName);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        driver.get(adminUrl);
        LogHelper.info("Precondition - Step 02 : Enter Username textbox");
        adminLoginPage.inputToUsernameTextbox(adminUsername);
        LogHelper.info("Precondition - Step 03 : Enter Password textbox");
        adminLoginPage.inputToPasswordTextbox(adminPassword);
        LogHelper.info("Precondition - Step 04 : Click Login button");
        adminDashboardPage = adminLoginPage.clickToLoginButton();
    }

    @Test
    public void Post_01_Create_New_Post() {
        LogHelper.info("Create_Post - Step 01 : Click to 'Post' menu link");
        adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

        LogHelper.info("Create_Post - Step 02 :Get 'Search Posts' page Url");
        searchPostUrl = adminPostSearchPage.getPageUrl(driver);

        LogHelper.info("Create_Post - Step 03 : Click to 'Add New' button");
        adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

        LogHelper.info("Create_Post - Step 04 : Input to Post Title");
        adminPostAddNewPage.inputToAddNewPostTitle(postTitle);

        LogHelper.info("Create_Post - Step 05 : Input to body");
        //adminPostAddNewPage.inputToAddNewPostBody(postBody);

        LogHelper.info("Create_Post - Step 06 : Click to 'Publish' button");
        adminPostAddNewPage.clickToPublishOrUpdateButton();


        LogHelper.info("Create_Post - Step 07 : Verify 'Post published' message is displayed");
        verifyTrue(adminPostAddNewPage.isPostPublishOrUpdateMessageDisplayed("Post published."));
    }

    @Test
    public void Post_02_Search_View_Post() {
        LogHelper.info("Search_Post - Step 01 : Open 'Search Post' page");
        adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

        LogHelper.info("Search_Post - Step 02 : Enter to Search textbox");
        adminPostSearchPage.inputToSearchTextbox(postTitle);

        LogHelper.info("Search_Post - Step 03 : Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        LogHelper.info("Search_Post - Step 04 : Verify Search table contains '" + postTitle + "'");
        verifyTrue(adminPostSearchPage.isPostTitleDisplayed(postTitle));

        LogHelper.info("Search_Post - Step 05 : Verify Author name contains '" + authorName + "'");
        verifyTrue(adminPostSearchPage.isAuthorNameDisplayed(authorName));

        LogHelper.info("Search_Post - Step 06 : Open End user site");
        userHomePage = adminPostSearchPage.openEndUserSite(driver, endUserUrl);

        LogHelper.info("Search_Post - Step 07 : Verify Post info displayed at Home page");
        verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
        verifyTrue(userHomePage.isPostInforDisplayedCurrentDay(postTitle, currentDay));

        LogHelper.info("Search_Post - Step 08 : Click to Post title");
        userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

        LogHelper.info("Search_Post - Step 09 : Verify Post info displayed at Post detail page");
        verifyTrue(userPostDetailPage.isPostTitleDisplayed(postTitle));
        verifyTrue(userPostDetailPage.isAuthorDisplayed(authorName));
        verifyTrue(userPostDetailPage.isCurrentDayDisplayed(currentDay));

    }

    @Test
    public void Post_03_Edit_Post() {
        LogHelper.info("Edit_Post - Step 01 : Open Admin site");
        adminDashboardPage = userPostDetailPage.openAdminSite(driver, adminUrl);

        LogHelper.info("Edit_Post - Step 02 : Click to 'Posts' menu link");
        adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

        LogHelper.info("Edit_Post - Step 03 : Click to 'Posts' menu link");
        adminPostSearchPage.inputToSearchTextbox(postTitle);

        LogHelper.info("Edit_Post - Step 04 : Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        LogHelper.info("Edit_Post - Step 05 : Click to Post title link and navigate to Edit Post page");
        adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

        LogHelper.info("Edit_Post - Step 06 : Enter to post title");
        adminPostAddNewPage.inputToAddNewPostTitle(editPostTitle);

        LogHelper.info("Edit_Post - Step 07 : Enter to post body");

        LogHelper.info("Edit_Post - Step 08 : Click to 'Update' button");
        adminPostAddNewPage.clickToPublishOrUpdateButton();

        LogHelper.info("Edit_Post - Step 09 :Verify 'Post updated.' message is displayed");
        verifyTrue(adminPostAddNewPage.isPostPublishOrUpdateMessageDisplayed("Post updated."));

        LogHelper.info("Edit_Post - Step 10 : Open 'Search Post' page");
        adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

        LogHelper.info("Edit_Post - Step 11 : Enter to Search textbox");
        adminPostSearchPage.inputToSearchTextbox(editPostTitle);

        LogHelper.info("Edit_Post - Step 12 : Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        LogHelper.info("Edit_Post - Step 13 : Verify Search table contains '" + editPostTitle + "'");
        //verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));

        LogHelper.info("Edit_Post - Step 14 : Verify Search table contains '" + authorName + "'");
        // verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

        LogHelper.info("Edit_Post - Step 15 : Open End User site");
        userHomePage = adminPostSearchPage.openEndUserSite(driver, endUserUrl);

        LogHelper.info("Edit_Post - Step 16 : Verify Post Infor displayed at Home page");
        verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(editPostTitle));
        // verifyTrue(userHomePage.isPostInforDisplayedWithAuthorName(editPostTitle, authorName));
        verifyTrue(userHomePage.isPostInforDisplayedCurrentDay(editPostTitle, currentDay));

        LogHelper.info("Edit_Post - Step 17 : Click to Post title");
        userPostDetailPage = userHomePage.clickToPostTitle(editPostTitle);

        LogHelper.info("Edit_Post - Step 18 : Verify Post info displayed at Post detail page");
        verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editPostTitle));
        verifyTrue(userPostDetailPage.isPostInforDisplayedWithAuthorName(authorName));
        verifyTrue(userPostDetailPage.isPostInforDisplayedCurrentDay(currentDay));
    }


    @Test
    public void Post_04_Delete_Post() {
        LogHelper.info("Delete_Post - Step 01 : Open Admin site");
        adminDashboardPage = userPostDetailPage.openAdminSite(driver, adminUrl);

        LogHelper.info("Delete_Post - Step 02 : Click to 'Posts' menu link");
        adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

        LogHelper.info("Delete_Post - Step 03 : Click to 'Posts' menu link");
        adminPostSearchPage.inputToSearchTextbox(editPostTitle);

        LogHelper.info("Delete_Post - Step 04 : Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        LogHelper.info("Delete_Post - Step 05 : Select Post detail checkbox");
        adminPostSearchPage.selectPostCheckboxByTitle(editPostTitle);

        LogHelper.info("Delete_Post - Step 06 : Select 'Move to Trash' item in dropdown");
        adminPostSearchPage.selectTextItemInActionDropdown("Move to Trash");

        LogHelper.info("Delete_Post - Step 07 : Click to 'Apply' button");
        adminPostSearchPage.clickToApplyButton();

        LogHelper.info("Delete_Post - Step 08 : Verify '1 post moved to the Trash.' message is displayed");
        verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));

        LogHelper.info("Delete_Post - Step 09 : Enter to Search textbox");
        adminPostSearchPage.inputToSearchTextbox(editPostTitle);

        LogHelper.info("Delete_Post - Step 10 : Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        LogHelper.info("Delete_Post - Step 11 : Verify 'No posts found.' message is displayed");
        verifyTrue(adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));

        LogHelper.info("Delete_Post - Step 12 : Open End User site");
        userHomePage = adminPostSearchPage.openEndUserSite(driver, endUserUrl);

        LogHelper.info("Delete_Post - Step 13 : Verify Post title undisplayed at Home page");
        verifyTrue(userHomePage.isPostInforUndisplayedWithPostTitle(editPostTitle));

        LogHelper.info("Delete_Post - Step 14 : Enter to Search textbox");
        userHomePage.clickToSearchIcon();
        userHomePage.inputToSearchTextbox(editPostTitle);

//        LogHelper.info("Delete_Post - Step 15 : Click to 'Search' button");
//        userSearchPostPage = userHomePage.clickToSearchButton();
//
//        LogHelper.info("Delete_Post - Step 16 : Verify 'Nothing Found' message is displayed");
//        verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed(
//                "Sorry, but nothing matched your search terms. Please try again with some different keywords."));

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
