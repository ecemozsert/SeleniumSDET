package lesson_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown_Examples1 {
    @Test
    public void selectCountry() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        WebElement country = driver.findElement(By.name("country"));
        Select dropCountry = new Select(country);
        dropCountry.selectByVisibleText("CANADA");

        // driver.quit();}
    }
    @Test
    public void selectFruit(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://output.jsbin.com/osebed/2");

        WebElement fruits = driver.findElement(By.id("fruits"));
        Select dropFruits = new Select(fruits);
        dropFruits.selectByIndex(3);
    /*    dropFruits.selectByVisibleText("Grape");
        dropFruits.selectByVisibleText("Orange");
        dropFruits.selectByVisibleText("Apple");*/
        //dropFruits.deselectAll();

        // driver.quit();
    }
}
