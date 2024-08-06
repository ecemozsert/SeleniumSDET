package lesson_16.HepsiBurada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class BaseTestDriver {
    WebDriver driver;

    SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
        softAssert.assertAll();
    }
}
