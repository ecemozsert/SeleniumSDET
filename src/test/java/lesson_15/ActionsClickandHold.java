package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsClickandHold {
    @Test
    public void ActionsClickAndHoldMethods() {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/menu.php#");

        // identify element with xpath for click and hold
        WebElement m = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/nav/div/a"));

        // get element color in rgba format
        String s = m.getCssValue("color");
        System.out.println("rgba code for color element: " + s );

        // object of Actions class to click and hold
        Actions a = new Actions(driver);
        a.clickAndHold(m).build().perform();

        // get element color in rgba format
        String c = m.getCssValue("color");
        System.out.println("rgba code for color for element after click and hold: " + c);

        //control for the colors are not same
        Assert.assertNotEquals(c,s);
        // Closing browser
        //driver.quit();
    }}
