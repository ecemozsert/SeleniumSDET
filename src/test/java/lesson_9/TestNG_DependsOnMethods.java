package lesson_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_DependsOnMethods {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(dependsOnMethods = "goToLinkedin")
    public void getTitleForLinkedin() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);
        //Assert.assertTrue(PageTitle.isEmpty());
        Assert.assertEquals(PageTitle,"LinkedIn: Log In or Sign Up");
    }

    @Test(invocationCount = 1)
    public void goToLinkedin() {
        driver.get("https://linkedin.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
