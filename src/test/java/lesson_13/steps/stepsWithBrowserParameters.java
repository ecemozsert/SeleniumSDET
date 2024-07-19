package lesson_13.steps;

import lesson_13.utilities.driverUtilsWithBrowserParameters;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class stepsWithBrowserParameters {
    @BeforeClass
    public static void gotoLoginPage(){
        driverUtilsWithBrowserParameters.initDriver("CHROME");
        driverUtilsWithBrowserParameters.getDriver();
        driverUtilsWithBrowserParameters.openUrl("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void Login(){
        String TitleNameLogin= driverUtilsWithBrowserParameters.getDriver().getTitle();
        System.out.println("Login page title Name is: " + TitleNameLogin);
        driverUtilsWithBrowserParameters.getDriver().findElement(By.cssSelector("#username")).sendKeys("student");
        driverUtilsWithBrowserParameters.getDriver().findElement(By.id("password")).sendKeys("Password123");
        driverUtilsWithBrowserParameters.getDriver().findElement(By.xpath("//button[@id='submit']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String TitleNameLoggedIn= driverUtilsWithBrowserParameters.getDriver().getTitle();
        System.out.println("After Login process, page title name is: " + TitleNameLogin);

    }
    @AfterClass
    public static void tearDown(){
        driverUtilsWithBrowserParameters.quitDriver();
    }
}
