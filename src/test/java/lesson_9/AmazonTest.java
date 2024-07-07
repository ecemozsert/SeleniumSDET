package lesson_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchProduct(){
        driver.get("https://www.amazon.com/");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchArea = driver.findElement(By.id("twotabsearchtextbox"));
        searchArea.click();
        searchArea.sendKeys("Quality Assurance"+ Keys.ENTER);
    }

    @AfterClass
    public void tearDown(){
        // driver.quit();
    }
}


