package lesson_11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTypes {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

    }
    @Test
    public void getAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement clickMeButton =  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alertButton")));

        clickMeButton.click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
    }

    @Test
    public void promptBoxAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement promptButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("promtButton")));
        // Element click intercepted error message is displayed when click() method is used.
        //promptButton.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", promptButton);

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().sendKeys("Ecem");
        driver.switchTo().alert().accept();
        WebElement promptResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("promptResult")));
        System.out.println("Prompt result: " + promptResult.getText());
    }

    @Test
    public void confirmBoxAccept(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement confirmButton =  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmButton")));
        // Element click intercepted error message is displayed when click() method is used.
        //confirmButton.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", confirmButton);

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();
    }

    @Test
    public void confirmBoxCancel(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmButton")));
        // Element click intercepted error message is displayed when click() method is used.
        //confirmButton.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", confirmButton);

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().dismiss();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
