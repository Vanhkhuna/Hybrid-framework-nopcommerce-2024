package pageUIs.wordpress.admin;

public class AdminPostAddNewPageUI {
    public static final String POST_TITLE = "xpath=//input[@name='post_title']";
    public static final String CONTENT_TEXTBOX = "xpath=//iframe[@id='content_ifr']";
    public static final String CONTENT_AFTER_CLICK_TEXTBOX = "css=p.block-editor-block-list__block";
    public static final String PUBLISH_BUTTON = "xpath=//input[@id='publish']";
    public static final String POST_PUBLISHED_MESSAGE_DISPLAYED = "xpath=//div[contains(@class,'notice-success')]";
}
