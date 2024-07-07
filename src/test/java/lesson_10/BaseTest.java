package lesson_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        softAssert.assertAll();
    }
}
