import commons.BaseTest;
import commons.LogHelper;
import org.openqa.selenium.By;
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
        driver.get("https://demo.nopcommerce.com/notebooks?pagenumber=2&viewmode=grid&orderby=0&pagesize=3&fbclid=IwAR3qWrHxOuCc8DQpGe_UX3QqeZktkhCrXL096Bb1AaUNY3VBwnJh-_AyOjs");

    }

    @Test
    public void Employee_01_Add_New_Employee() {
        LogHelper.info("PIM Page -Step 01 : open PIM Link");
        driver.findElement(By.cssSelector("li.current-page")).click();
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
