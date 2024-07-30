package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework2_KeyboardActions {

    @Test
    public void Homework2_KeyboardActions(){
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));

        driver.get("https://html.com/tags/iframe/");
        // Find the iframe element
        WebElement element = driver.findElement(By.xpath("//iframe[@sandbox='allow-same-origin allow-scripts allow-popups allow-forms']"));



        // Scroll the iframe into view
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);

        element.click();
        WebElement iframe = driver.findElement(By.cssSelector("iframe[src*='youtube.com']"));

        // Switch to the iframe
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Pause (k)']"))).isDisplayed();

    }

    }


