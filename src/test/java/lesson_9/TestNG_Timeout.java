package lesson_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Timeout {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test(timeOut = 1500)
    public void pageTitleAmazon(){
        driver.get("https://www.amazon.com");
        String PageTitle = driver.getTitle();
        System.out.println("Page Title is: " + PageTitle);
    }
    @Test(timeOut = 500)
    public void pageTitleOrion(){
        driver.get("https://www.orioninc.com/");
        String PageTitle = driver.getTitle();
        System.out.println("Page Title is: " + PageTitle);
    }

    @AfterClass
    public void closeTests(){
        //driver.quit();
    }
}
