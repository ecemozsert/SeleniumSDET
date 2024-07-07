package lesson_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_InvocationCountRepeatableTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test(invocationCount = 3)
    public void goToLinkedin() {
        driver.get("https://linkedin.com/");
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);
    }

    @Test(invocationCount = 2)
    public void goToGoogle() {
        driver.get("https://google.com/");
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
