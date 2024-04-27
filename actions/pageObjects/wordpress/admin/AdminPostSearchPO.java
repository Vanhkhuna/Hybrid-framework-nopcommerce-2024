package pageObjects.wordpress.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.admin.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
    WebDriver driver;

    public AdminPostSearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPostAddNewPO clickToAddNewButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_POST_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_POST_BUTTON);
        return PageGeneratorManager.getAdminPostAddNewPage(driver);
    }

    public void inputToSearchTextbox(String searchValue) {
        waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
        sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, searchValue);
    }

    public void clickToSearchPostsButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
    }


    public boolean isPostTitleDisplayed(String postTitle) {
        waitForElementVisible(driver, AdminPostSearchPageUI.POST_TITLE_DISPLAYED, postTitle);
        return isElementDisplayed(driver, AdminPostSearchPageUI.POST_TITLE_DISPLAYED, postTitle);
    }

    public boolean isAuthorNameDisplayed(String authorName) {
        waitForElementVisible(driver, AdminPostSearchPageUI.AUTHOR_NAME_DISPLAYED, authorName);
        return isElementDisplayed(driver, AdminPostSearchPageUI.AUTHOR_NAME_DISPLAYED, authorName);
    }

    public AdminPostAddNewPO clickToPostTitleLink(String postTitle) {
        waitForElementClickable(driver, AdminPostSearchPageUI.POST_TITLE_DISPLAYED, postTitle);
        clickToElement(driver, AdminPostSearchPageUI.POST_TITLE_DISPLAYED, postTitle);
        return PageGeneratorManager.getAdminPostAddNewPage(driver);
    }

    public void selectPostCheckboxByTitle(String editPostTitle) {
        waitForElementClickable(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
        checkToDefaultCheckboxOrRadio(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);

    }

    public void selectTextItemInActionDropdown(String dropdownItem) {
        waitForElementClickable(driver, AdminPostSearchPageUI.ACTION_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTION_DROPDOWN, dropdownItem);
    }

    public void clickToApplyButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
    }

    public boolean isMoveToTrashMessageDisplayed(String message) {
        waitForElementVisible(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
        return isElementDisplayed(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
    }

    public boolean isNoPostFoundMessageDisplayed(String message) {
        waitForElementVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
        return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
    }
}
