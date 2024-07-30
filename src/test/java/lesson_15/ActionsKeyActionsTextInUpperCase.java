package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsKeyActionsTextInUpperCase {

    @Test
    public void KeyActionsTextInUpperCaseMethods(){
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 10 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Opening the webpage where we will identify an element
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");

        // Identify the first input box
        WebElement e = driver.findElement(By.xpath("//*[@id='fullname']"));

        // Actions class
        Actions act = new Actions(driver);

        // moving to element and clicking on it
        act.moveToElement(e).click();

        // key UP and DOWN action for SHIFT
        act.keyDown(Keys.SHIFT);
        act.sendKeys("Selenium").keyUp(Keys.SHIFT).build().perform();

        // get value entered
        System.out.println("Text entered: " + e.getAttribute("value"));

        // Close browser
        // driver.quit();
    }
}
