package pageObjects.wordpress.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.admin.UserHomePageUI;

public class UserHomePO extends BasePage {
    WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
        waitForElementClickable(driver, UserHomePageUI.POST_INFO_DISPLAYED_POST_TITLE, postTitle);
        return isElementDisplayed(driver, UserHomePageUI.POST_INFO_DISPLAYED_POST_TITLE, postTitle);
    }

    public boolean isPostInforDisplayedCurrentDay(String postTitle, String currentDay) {
        waitForElementVisible(driver, UserHomePageUI.POST_INFO_DISPLAYED_POST_TITLE, postTitle, currentDay);
        return isElementDisplayed(driver, UserHomePageUI.POST_INFO_DISPLAYED_POST_TITLE, postTitle, currentDay);
    }

    public UserPostDetailPO clickToPostTitle(String postTitle) {
        waitForElementClickable(driver, UserHomePageUI.POST_INFO_DISPLAYED_POST_TITLE, postTitle);
        clickToElement(driver, UserHomePageUI.POST_INFO_DISPLAYED_POST_TITLE, postTitle);
        return PageGeneratorManager.getUserPostDetailPage(driver);
    }


    public boolean isPostInforUndisplayedWithPostTitle(String editPostTitle) {
        return isElementUnDisplayed(driver, UserHomePageUI.POST_INFO_DISPLAYED_POST_TITLE, editPostTitle);
    }

    public void inputToSearchTextbox(String editPostTitle) {
    }

//    public UserSearchPostPO clickToSearchButton() {
//    }

    public void clickToSearchIcon() {
        waitForElementClickable(driver, UserHomePageUI.SEARCH_ICON);
        clickToElement(driver, UserHomePageUI.SEARCH_ICON);
    }
}
