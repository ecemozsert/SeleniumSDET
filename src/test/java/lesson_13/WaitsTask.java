package lesson_13;

import lesson_13.utilities.driverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class WaitsTask {
    private static WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }
    @Test
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();
        WebElement removeMessageElement = driver.findElement(By.xpath("//p[@id='message']"));
        String removeMessageElementText = removeMessageElement.getText();
        String expectedRemoveMessageElementText = "It's gone!";
        System.out.println("Message is: " + removeMessageElementText);
        Assert.assertEquals(expectedRemoveMessageElementText,removeMessageElementText);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()'][@type='button']"));
        addButton.click();
        WebElement addMessageElement = driver.findElement(By.xpath("//p[@id='message']"));
        String addMessageElementText = addMessageElement.getText();
        String expectedAddMessageElementText = "It's back!";
        System.out.println("Message is: " + addMessageElementText);
        Assert.assertEquals(expectedAddMessageElementText,addMessageElementText);
    }
    @Test
    public void explicitWait(){
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();
        WebElement removeMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String removeMessageElementText = removeMessageElement.getText();
        String expectedRemoveMessageElementText = "It's gone!";
        System.out.println("Message is: " + removeMessageElementText);
        System.out.println("expected Message is: " + expectedRemoveMessageElementText);
        Assert.assertEquals(expectedRemoveMessageElementText, removeMessageElementText);
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()'][@type='button']"));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
        WebElement addMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String addMessageElementText = addMessageElement.getText();
        String expectedAddMessageElementText = "It's back!";
        System.out.println("Message is: " + addMessageElementText);
        Assert.assertEquals(expectedAddMessageElementText,addMessageElementText);

    }
    @AfterClass
    public static void tearDown(){
        driverUtils.quitDriver();
    }
}
 
 