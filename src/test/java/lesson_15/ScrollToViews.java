package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollToViews {

    @Test
    public void ScrollToViewsMethod() {
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Opening the webpage where we will perform the scroll
        driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-top.php");
        WebElement text = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/p[7]"));

        // JavascriptExecutor to scrolling to view of an element
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", text);

        // get text after scrolling
        System.out.println("Get text on after scrolling to element visibility: " + text.getText());

        // quitting the browser
        //driver.quit();

    }
}
