package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.Reporter;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName) {
        if (browserName.equals("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();

        } else if (browserName.equals("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else if (browserName.equals("chrome")) {
            driver = WebDriverManager.chromedriver().create();
//            ChromeOptions options = new ChromeOptions();
//            File extension = new File("Google-Translate.crx");
//            options.addExtensions(extension);

        } else if (browserName.equals("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if (browserName.equals("edge")) {
            driver = WebDriverManager.edgedriver().create();
            // driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser Name invalid");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        return driver;
    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            LogHelper.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            LogHelper.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            LogHelper.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            LogHelper.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            LogHelper.info(" -------------------------- PASSED -------------------------- ");

        } catch (Throwable e) {
            LogHelper.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            LogHelper.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            LogHelper.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            LogHelper.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public WebDriver getDriverInstance() {
        return this.driver;
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected String getCurrentDate() {
        DateTime nowUTC = new DateTime();
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return String.valueOf(day);
    }

    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return String.valueOf(month);
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime();
        return String.valueOf(now.getYear());
    }

    protected String getCurrentDay() {
        return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
    }


}
