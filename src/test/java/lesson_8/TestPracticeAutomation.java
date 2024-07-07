package Lesson_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPracticeAutomation {
    static WebDriver driver;

    @BeforeClass
    public static void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Login(){
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        String TitleNameLogin= driver.getTitle();
        System.out.println("Login page title Name is: " + TitleNameLogin);
        driver.findElement(By.cssSelector("#username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String TitleNameLoggedIn= driver.getTitle();
        System.out.println("After Login process, page title name is: " + TitleNameLogin);
    }

    @Test
    public void LogOut(){
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        String TitleNameLogin= driver.getTitle();
        System.out.println("Login page title Name is: " + TitleNameLogin);
        driver.findElement(By.cssSelector("#username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String TitleNameLoggedIn= driver.getTitle();
        System.out.println("After Login process, page title name is: " + TitleNameLogin);
        driver.findElement(By.xpath("//a[text()='Log out']")).click();

        String TitleNameLoggedOut = driver.getTitle();
        System.out.println("After Logout process, page title name is: " + TitleNameLoggedOut);

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();

    }
}
