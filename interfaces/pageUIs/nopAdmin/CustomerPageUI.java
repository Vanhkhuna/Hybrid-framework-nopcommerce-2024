package pageUIs.nopAdmin;

public class CustomerPageUI {
    public static final String ADD_NEW_BUTTON = "xpath=//h1[contains(text(),'Customers')]/following-sibling::div//a";
    public static final String DYNAMIC_TEXTBOX = "xpath=//input[@id='%s']";
    public static final String RADIO_CHECKBOX = "xpath=//input[@id='%s']";
    public static final String ROLE_TEXTBOX = "css=div.input-group-required input";
    public static final String COMMENT_TEXTBOX = "xpath=//textarea[@id='AdminComment']";
    public static final String SAVE_BUTTON = "name=save";
    public static final String DYNAMIC_SUCCESS_MESSAGE = "css=div.alert-success";
    public static final String EMAIL_TEXTBOX_AT_CUSTOMER_LIST = "id=SearchEmail";
    public static final String SEARCH_BUTTON = "id=search-customers";
    public static final String ALL_ROW_ELEMENT_AT_TABLE = "xpath=//tbody/tr";
    public static final String EDIT_BUTTON = "css=i.fa-pencil-alt";
    public static final String DELETE_BUTTON = "id=customer-delete";
    public static final String DELETE_DIALOG = "css=div#customermodel-Delete-delete-confirmation div.modal-content";
    public static final String DELETE_BUTTON_AT_DIALOG = "xpath=//button[contains(@class,'btn-danger')]";
    public static final String NO_DATA_MESSAGE = "css=td.dataTables_empty";
}
