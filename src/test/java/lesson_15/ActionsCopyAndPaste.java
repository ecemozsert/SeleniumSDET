package lesson_15;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsCopyAndPaste {
    @Test
    public void ActionsCopyAndPasteMethods(){
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the webpage where we will identify an element
        driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");

        // Identify the first input box with xpath locator
        WebElement e = driver.findElement(By.xpath("//*[@id='firstname']"));

        // enter some text
        e.sendKeys("Baris1234");

        // chose the key as per platform
        Keys k = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        // object of Actions class to copy then paste
        Actions a = new Actions(driver);
        a.keyDown(k);
        a.sendKeys("a");
        a.keyUp(k);
        a.build().perform();

        // Actions class methods to copy text
        a.keyDown(k);
        a.sendKeys("c");
        a.keyUp(k);
        a.build().perform();

        // Action class methods to tab and reach to next input box
        a.sendKeys(Keys.TAB);
        a.build().perform();

        // Actions class methods to paste text
        a.keyDown(k);
        a.sendKeys("v");
        a.keyUp(k);
        a.build().perform();

        // Identify the second input box with xpath locator
        WebElement s = driver.findElement(By.xpath("//*[@id='lastname']"));

        // Getting text in the second input box
        String text = s.getAttribute("value");
        System.out.println("Value copied and pasted: " + text);

        // Closing browser
        //  driver.quit();
    }

    @Test
    public void CopyAndPasteMethodsWithoutActions(){
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the webpage where we will identify an element
        driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");

        // Identify the first input box with xpath locator
        WebElement firstname = driver.findElement(By.xpath("//*[@id='firstname']"));

        // Identify the second input box with xpath locator
        WebElement lastname = driver.findElement(By.xpath("//*[@id='lastname']"));

        // chose the key as per platform
        Keys k = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND :  Keys.CONTROL;

        // enter some text
        firstname.sendKeys("JavaSelenium");

        // select the whole entered text
        firstname.sendKeys(Keys.chord(k, "a"));

        // copy the whole entered text
        firstname.sendKeys(Keys.chord(k, "c"));

        // tab and reach to next input box
        firstname.sendKeys(Keys.TAB);

        // paste the whole entered text
        lastname.sendKeys(Keys.chord(k, "v"));

        // Getting text in the second input box
        String text = lastname.getAttribute("value");
        System.out.println("Value copied and pasted: " + text);

        // Closing browser
        // driver.quit();
    }

}
