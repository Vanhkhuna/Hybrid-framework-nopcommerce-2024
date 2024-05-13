import commons.BaseTest;
import commons.LogHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Sample extends BaseTest {
    WebDriver driver;

     @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://www.pharmacity.vn/");

    }

    @Test
    public void Employee_01_Add_New_Employee() {
        LogHelper.info("PIM Page -Step 01 : open PIM Link");
    }

    @Test
    public void Employee_02_Upload_Avatar() {

    }

    @Test
    public void Employee_03_Personal_Details() {

    }

    @Test
    public void Employee_04_Contact_Details() {

    }

    @Test
    public void Employee_05_Emergency_Contacts() {


    }

    @Test
    public void Employee_06_Assigned_Dependents() {


    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
