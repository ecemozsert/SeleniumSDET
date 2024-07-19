package lesson_13.steps;

import lesson_13.utilities.driverUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class steps {
    @BeforeClass
    public static void gotoLoginPage(){
        driverUtils.initDriver();
        driverUtils.getDriver();
        driverUtils.openUrl("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void Login(){
        String TitleNameLogin= driverUtils.getDriver().getTitle();
        System.out.println("Login page title Name is: " + TitleNameLogin);
        driverUtils.getDriver().findElement(By.cssSelector("#username")).sendKeys("student");
        driverUtils.getDriver().findElement(By.id("password")).sendKeys("Password123");
        driverUtils.getDriver().findElement(By.xpath("//button[@id='submit']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String TitleNameLoggedIn= driverUtils.getDriver().getTitle();
        System.out.println("After Login process, page title name is: " + TitleNameLogin);
    }
    @AfterClass
    public static void tearDown(){
        driverUtils.quitDriver();
    }
}
