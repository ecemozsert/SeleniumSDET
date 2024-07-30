package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsMouse {
    @Test
    public void ActionsMouseMethods() {

        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");

        // identify element with xpath for click
        WebElement m = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

        // object of Actions class to move then click
        Actions a = new Actions(driver);
        a.moveToElement(m).click().build().perform();


        // get text after click
        WebElement t = driver.findElement(By.xpath("//*[@id='welcomeDiv']"));
        System.out.println("Text after click: " + t.getText());
        Assert.assertEquals(t.getText(),"You have done a dynamic click");

        // identify element with xpath for double click
        WebElement n = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/button[3]"));

        // double click
        a.moveToElement(n).doubleClick().build().perform();

        // get text after double click
        WebElement x = driver.findElement(By.xpath("//*[@id='doublec']"));
        System.out.println("Text after double click: " + x.getText());

        // identify element with xpath for right click
        WebElement y = driver.findElement
                (By.xpath("/html/body/main/div/div/div[2]/button[2]"));

        // right click
        a.moveToElement(y).contextClick().build().perform();

        // Closing browser
        // driver.quit();
    }}
