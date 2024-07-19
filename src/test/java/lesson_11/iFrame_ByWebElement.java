package lesson_11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class iFrame_ByWebElement {
    WebDriver driver = new EdgeDriver();
    @Test
    public void frameByWebElement(){

        driver.get("https://demoqa.com/frames");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@width='100px']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", iframe);

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);

    }
    @AfterClass
    public void tearDown (){
        driver.quit();
    }
}

