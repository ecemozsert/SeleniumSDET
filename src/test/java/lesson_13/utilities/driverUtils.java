package lesson_13.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class driverUtils {
    private static WebDriver driver;

    // Method to initialize the WebDriver
    public static void initDriver() {
        if (driver == null) {
            //driver = new ChromeDriver();
            driver = new EdgeDriver();
            //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }
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

    //Example utility method to navigate a URL
    public static void navigateUrl(String url){
        getDriver().navigate().to(url);
    }

    // Method to quit the WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    //Method to close the WebDriver
    public static void closeDriver(){
        if (driver !=null){
            driver.close();
            driver = null;
        }
    }
}
