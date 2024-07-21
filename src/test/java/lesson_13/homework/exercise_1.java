package lesson_13.homework;

import lesson_13.utilities.driverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class exercise_1 {
    @BeforeClass
    public static void gotoLoginPage(){
        driverUtils.initDriver();
        driverUtils.getDriver();
        driverUtils.openUrl("http://webdriveruniversity.com/IFrame/index.html");
        driverUtils.getDriver().manage().window().maximize();
    }
    @Test
    public void clickButton(){
        WebDriverWait wait = new WebDriverWait(driverUtils.getDriver(), Duration.ofSeconds(10));

        WebElement iframe =  driverUtils.getDriver().findElement(By.id("frame"));
        driverUtils.getDriver().switchTo().frame(iframe);

        // Perform the click action
        driverUtils.getDriver().findElement(By.xpath("//a[normalize-space()='Our Products']")).click();
        driverUtils.getDriver().findElement(By.id("container-product6")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Close']"))).click();
        // Switch back to the main content
        driverUtils.getDriver().switchTo().defaultContent();

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='WebdriverUniversity.com (IFrame)']")));
        button.click();

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
