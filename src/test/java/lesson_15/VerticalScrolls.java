package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerticalScrolls {
    @Test
    public void VerticalScrollMethod(){

        //Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Opening the webpage where we will perform vertical scroll
        driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-top.php");

        // JavascriptExecutor to perform vertical scroll by 0, and 1200 pixels
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,1200)", "");

        // identify text
        WebElement t = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/h3[3]"));
        System.out.println("Text found on vertical scroll");
    }
}
