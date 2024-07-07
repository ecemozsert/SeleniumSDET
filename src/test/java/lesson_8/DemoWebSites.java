package Lesson_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebSites {
 /*   public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.get("https://linkedin.com");
    }*/

    static WebDriver driver;
    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
    }

    @BeforeEach
    public void maximizeBrowser(){
        driver.manage().window().maximize();
    }

    @org.junit.jupiter.api.Test
    public void GooglePage(){
        driver.navigate().to("https://www.google.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void LinkedinPage(){
        driver.get("https://linkedin.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void getTitle(){
        String PageTitle =  driver.getTitle();
        System.out.println("Page title is " + PageTitle);
    }

    @Disabled("Tarayıcının kapanması yok sayıldı")
    public void tearDown(){
        driver.quit();
    }
}
