package pageObjects.jquery.dataTable;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObject getUserHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }


}
