package lesson_13.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class driverUtilsWithBrowserParameters {
    private static WebDriver driver;

    // Method to initialize the WebDriver
    public static void initDriver(String browser) {
        if (driver == null) {
            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
            else if(browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            else if(browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
            else {
                throw new IllegalArgumentException("Browser type is not supported" + browser);
            }
        }
        driver.manage().deleteAllCookies();
        //Implicitly Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Explicit Wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized, call initDriver() first.");
        }
        return driver;
    }

    // Example utility method to open a URL
    public static void openUrl(String url) {
        getDriver().get(url);
    }

    // Method to quit the WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Method to close the browser tab
    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
