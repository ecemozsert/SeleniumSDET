package lesson_13.homework;

import lesson_13.utilities.driverUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class exercise_2 {
    @BeforeClass
    public static void gotoLoginPage(){
        driverUtils.initDriver();
        driverUtils.getDriver();
        driverUtils.openUrl("http://webdriveruniversity.com/");
        driverUtils.getDriver().manage().window().maximize();
    }
    @Test
    public void clickButton(){
        JavascriptExecutor js = (JavascriptExecutor)  driverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait( driverUtils.getDriver(), Duration.ofSeconds(10));

        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0, 700);");
        driverUtils.getDriver().findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();

        ArrayList<String> tabs = new ArrayList<String> (driverUtils.getDriver().getWindowHandles());
        driverUtils.getDriver().switchTo().window(tabs.get(1));
        driverUtils.getDriver().findElement(By.id("text")).sendKeys("Ecem");
        driverUtils.getDriver().findElement(By.id("password")).sendKeys("Ecem123.");
        driverUtils.getDriver().findElement(By.id("login-button")).click();
        // Switch to the alert and accept it
        Alert alert =  driverUtils.getDriver().switchTo().alert();
        System.out.println("Alert message is : "+ alert.getText());
        alert.accept();
        driverUtils.getDriver().close();
        driverUtils.getDriver().switchTo().window(tabs.get(0));


        WebElement afterOpenElement = driverUtils.getDriver().findElement(By.xpath("//a[text()='API Testing in detail using Postman - Test Automation']"));
        String actualResult = afterOpenElement.getText();
        String expectedResult = "API Testing in detail using Postman - Test Automation";
        System.out.println("Actual Result: " +actualResult);
        System.out.println("Expected Result: "+ expectedResult);

        Assert.assertEquals(actualResult,expectedResult);
    }
    @AfterClass
    public static void tearDown(){
        driverUtils.quitDriver();
    }
}
