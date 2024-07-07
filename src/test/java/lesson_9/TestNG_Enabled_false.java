package lesson_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Enabled_false {
    static WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

    }
    //1. Verify successful login after trying with valid user credentials.
    @Test(priority = 2)
    public void validCredentialsLogin(){
        WebElement validUsername = driver.findElement(By.id("username"));
        validUsername.sendKeys("student");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement postTitleElement = driver.findElement(By.xpath("//h1[text()='Logged In Successfully']"));

        String postTitleElementText = postTitleElement.getText();

        String expectedPostTitleText = "Logged In Successfully";


        WebElement postContentElement = driver.findElement(By.cssSelector(".has-text-align-center strong"));

        String postContentText = postContentElement.getText();

        String expectedPostContentText = "Congratulations student. You successfully logged in!";

        System.out.println("Post Title Element Text is: " + postTitleElementText);
        System.out.println("Post Content Text is: " + postContentText);
        Assert.assertEquals(expectedPostTitleText,postTitleElementText);
        Assert.assertEquals(expectedPostContentText,postContentText);
    }

    // 2. Verify error message is shown after trying with invalid username.
    @Test(priority = 3)
    public void invalidUsernameAndValidPasswordLogin(){
        WebElement invalidUsername = driver.findElement(By.id("username"));
        invalidUsername.sendKeys("inValidUsername");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement errorMessageElement = driver.findElement(By.id("error"));
        String errorMessageElementText = errorMessageElement.getText();

        System.out.println("Error message is: " + errorMessageElementText);


        String expectedErrorMessageElementText = "Your username is invalid!";

        boolean firstErrorMessageElementCondition = errorMessageElementText.contains("Your username is invalid!");

        boolean secondErrorMessageElementCondition = errorMessageElement.isDisplayed();


        System.out.println("boolean Condition of text contains is: " + firstErrorMessageElementCondition);
        System.out.println("boolean Condition of element is Displayed: " + secondErrorMessageElementCondition);


        Assert.assertEquals(expectedErrorMessageElementText, errorMessageElementText);

        Assert.assertTrue(firstErrorMessageElementCondition,"Please check first boolean");

        Assert.assertTrue(secondErrorMessageElementCondition,"Please check second boolean");

        System.out.println("location" + errorMessageElement.getLocation());

    }

    //3. Verify error message is shown after trying with invalid password.
    @Test(priority = 1,enabled=false)
    public void validUsernameAndInValidPasswordLogin(){
        WebElement invalidUsername = driver.findElement(By.id("username"));
        invalidUsername.sendKeys("student");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("InvalidPassword");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement errorMessageElement = driver.findElement(By.id("error"));
        String errorMessageElementText = errorMessageElement.getText();

        System.out.println("Error message is: " + errorMessageElementText);


        String expectedErrorMessageElementText = "Your password is invalid!";

        boolean firstErrorMessageElementCondition = errorMessageElementText.contains("Your password is invalid!");

        boolean secondErrorMessageElementCondition = errorMessageElement.isDisplayed();


        System.out.println("boolean Condition of text contains is: " + firstErrorMessageElementCondition);
        System.out.println("boolean Condition of element is Displayed: " + secondErrorMessageElementCondition);



        Assert.assertEquals(expectedErrorMessageElementText, errorMessageElementText);

        Assert.assertTrue(firstErrorMessageElementCondition,"Please check first boolean");

        Assert.assertTrue(secondErrorMessageElementCondition,"Please check second boolean");

        System.out.println("location" + errorMessageElement.getLocation());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

}
