package pageObjects.wordpress.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
    WebDriver driver;

    public AdminPostAddNewPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToAddNewPostTitle(String postTitle) {
        waitForElementClickable(driver, AdminPostAddNewPageUI.POST_TITLE);
        clickToElement(driver, AdminPostAddNewPageUI.POST_TITLE);
        waitForElementVisible(driver, AdminPostAddNewPageUI.POST_TITLE);
        sendkeyToElement(driver, AdminPostAddNewPageUI.POST_TITLE, postTitle);

    }

    public void inputToAddNewPostBody(String postBody) {
        waitForElementClickable(driver, AdminPostAddNewPageUI.CONTENT_TEXTBOX);
        clickToElement(driver, AdminPostAddNewPageUI.CONTENT_TEXTBOX);
        sleepInSecond(3);
        waitForElementVisible(driver, AdminPostAddNewPageUI.CONTENT_TEXTBOX);
        sendkeyToElement(driver, AdminPostAddNewPageUI.CONTENT_TEXTBOX, postBody);
    }

    public void clickToPublishOrUpdateButton() {
        waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
        clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
    }

    public boolean isPostPublishOrUpdateMessageDisplayed(String postPublishedMessage) {
        waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MESSAGE_DISPLAYED, postPublishedMessage);
        return isElementDisplayed(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MESSAGE_DISPLAYED, postPublishedMessage);
    }

    public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
        openPageUrl(driver, searchPostUrl);
        return PageGeneratorManager.getAdminPostSearchPage(driver);
    }
}
