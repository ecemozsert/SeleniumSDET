package lesson_14;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework1_sendKeys {
    @Test
    public void selectFile() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://webdriveruniversity.com/File-Upload/index.html");
        WebElement chooseFile= driver.findElement(By.id("myFile"));
        chooseFile.sendKeys("C:\\Users\\ecozsert\\training\\training\\src\\test\\java\\lesson_14\\white.screen.png");
        driver.findElement(By.id("submit-button")).click();

        Alert alert = driver.switchTo().alert();

        // Get the text of the alert
        String alertText = alert.getText();
        System.out.println("Popup text: " + alertText);
        alert.accept();
        Assert.assertEquals("Your file has now been uploaded!",alertText);


        driver.quit();


    }
}
