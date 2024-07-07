package Lesson_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebExamples {

    static WebDriver driver;
    @BeforeClass
    public static void preparation(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void loginValidCredentials(){
        driver.get("https://www.amazon.com");
        String PageTitle = driver.getTitle();
        System.out.println("Page Title is: " + PageTitle);
    }
    @Test
    public void Test2(){
        driver.get("https://www.orioninc.com/");
        String PageTitle = driver.getTitle();
        System.out.println("Page Title is: " + PageTitle);
    }

    @AfterClass
    public static void closeTests(){
        driver.quit();
    }

}
