package Lesson_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RepeatedTestAnnotationJUnit5 {

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://linkedin.com/");
    }

    @RepeatedTest(5)
    public void goToLinkedin() {
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);
    }

}
