package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Homework_JavascriptExecutor {
    @Test
    public void Homework4_JavascriptExecutor(){
        WebDriver driver =new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Click-Buttons/index.html");
        WebElement clickButton = driver.findElement(By.cssSelector("#button2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickButton);
        driver.quit();
    }
    @Test
    public void Homework5_JavascriptExecutor(){
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement aboutSelenium = driver.findElement(By.xpath("//a[@href='/about/']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", aboutSelenium);

driver.quit();
    }
}
