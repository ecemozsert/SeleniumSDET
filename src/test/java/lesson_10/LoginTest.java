package lesson_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void login(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement validUsername = driver.findElement(By.id("username"));
        validUsername.sendKeys("student");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement postTitleElement = driver.findElement(By.xpath("//h1[text()='Logged In Successfully']"));

        String postTitleElementText = postTitleElement.getText();

        String expectedPostTitleText = "Logged In Successfully";
        softAssert.assertEquals("2",2);
        softAssert.assertEquals(expectedPostTitleText,postTitleElementText);
    }
}
