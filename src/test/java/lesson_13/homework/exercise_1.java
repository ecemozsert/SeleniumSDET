package lesson_13.homework;

import lesson_13.utilities.driverUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
wait.until();






    }
}
