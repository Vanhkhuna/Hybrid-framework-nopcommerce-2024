package pageUIs.wordpress.admin;

public class AdminPostSearchPageUI {
    public static final String ADD_NEW_POST_BUTTON = "css=a.page-title-action";
    public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
    public static final String SEARCH_POSTS_BUTTON = "css=input#search-submit";
    public static final String POST_TITLE_DISPLAYED = "xpath=//a[@class='row-title' and text()='%s']";
    public static final String AUTHOR_NAME_DISPLAYED = "xpath=//td[contains(@class,'column-author')]/a";
    public static final String ROW_CHECKBOX_BY_TITLE_NAME = "xpath=//div[@class='post_title' and text()='%s']/ancestor::td/preceding-sibling::th/input";

    public static final String APPLY_BUTTON = "xpath=//input[@id='doaction']";
    public static final String ACTION_DROPDOWN = "css=select#bulk-action-selector-top";
    public static final String MOVE_TO_TRASH_MESSAGE = "xpath=//div[@id='message']/p";
    public static final String NO_POST_FOUND_MESSAGE = "css=tr.no-items>td";
}
