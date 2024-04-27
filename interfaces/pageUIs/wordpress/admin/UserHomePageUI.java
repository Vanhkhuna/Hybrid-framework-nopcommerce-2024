package pageUIs.wordpress.admin;

public class UserHomePageUI {
    public static final String POST_INFO_DISPLAYED_POST_TITLE = "xpath=//h2[@class='wp-block-post-title']/a[text()='%s']";

    public static final String POST_INFO_DISPLAYED_CURRENT_DAY = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='wp-block-post-date']//a";
    public static final String SEARCH_ICON = "xpath=//input[@class='adminbar-input']";
}
