package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Homework1_MouseActions {
    @Test
    public void homework1(){
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement AREA = driver.findElement(By.id("hot-spot"));
        Actions a = new Actions(driver);
        a.moveToElement(AREA).contextClick().build().perform();
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Expected Alert Text: " + alertText);
        System.out.println("Actual Alert Text: You selected a context menu");
        Assert.assertEquals("You selected a context menu",alertText);
        driver.switchTo().alert().accept();
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[@target='_blank']"));
        elementalSelenium.click();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement logo = driver.findElement(By.xpath("//h1[text()='Elemental Selenium']"));
        logo.isDisplayed();
        driver.quit();
    }

}
