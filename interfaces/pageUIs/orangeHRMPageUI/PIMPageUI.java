package pageUIs.orangeHRMPageUI;

public class PIMPageUI {
    public static final String ADD_EMPLOYEE_BUTTON = "xpath=//a[text()='Add Employee']";
    public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@name='firstName']";
    public static final String LASTNAME_TEXTBOX = "xpath=//input[@name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String SAVE_BUTTON = "xpath=//button[contains(string(),' Save ')]";
    public static final String SUCCESSFULLY_MESSAGE = "css=div.oxd-toast-content--success p.oxd-text--toast-message";
    public static final String PROFILE_PICTURE = "css=div.orangehrm-edit-employee-image";
    public static final String ADD_ICON = "xpath=//i[@class='oxd-icon bi-plus']";
    public static final String DEFAULT_PHOTO = "xpath=//img[contains(@src,'default-photo')]";
    public static final String TABS_ITEM_BY_NAME = "xpath=//a[contains(@class,'orangehrm-tabs-item') and text()='%s']";
    public static final String INPUT_TO_TEXTBOX_BY_NAME = "xpath=//label[text()=\"%s\"]/parent::div/following-sibling::div//input";
    public static final String SELECT_DROPDOWN_BY_NAME = "xpath=//label[text()='%s']/parent::div/following-sibling::div//div[@class='oxd-select-text-input' and text()='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']";
    public static final String ADD_BUTTON = "xpath=//h6[text()='%s']/following-sibling::button";

}
