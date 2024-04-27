package pageObjects.wordpress.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.admin.UserHomePageUI;
import pageUIs.wordpress.admin.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage {
    WebDriver driver;

    public UserPostDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPostTitleDisplayed(String postTitle) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE, postTitle);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE, postTitle);

    }

    public boolean isAuthorDisplayed(String authorName) {
        waitForElementVisible(driver, UserPostDetailPageUI.AUTHOR_NAME, authorName);
        return isElementDisplayed(driver, UserPostDetailPageUI.AUTHOR_NAME, authorName);
    }

    public boolean isCurrentDayDisplayed(String currentDay) {
        waitForElementVisible(driver, UserPostDetailPageUI.CURRENT_DATE, currentDay);
        return isElementDisplayed(driver, UserPostDetailPageUI.CURRENT_DATE, currentDay);
    }

    public boolean isPostInforDisplayedWithPostTitle(String editPostTitle) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE, editPostTitle);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE, editPostTitle);
    }

    public boolean isPostInforDisplayedWithAuthorName(String authorName) {
        waitForElementVisible(driver, UserPostDetailPageUI.AUTHOR_NAME, authorName);
        return isElementDisplayed(driver, UserPostDetailPageUI.AUTHOR_NAME, authorName);
    }

    public boolean isPostInforDisplayedCurrentDay(String currentDay) {
        waitForElementVisible(driver, UserPostDetailPageUI.CURRENT_DATE, currentDay);
        return isElementDisplayed(driver, UserPostDetailPageUI.CURRENT_DATE, currentDay);
    }
}
