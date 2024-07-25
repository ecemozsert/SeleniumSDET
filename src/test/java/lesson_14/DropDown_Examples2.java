package lesson_14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown_Examples2 {
    //Method 1: By storing all the options in List and iterating through it
    @Test
    public void selectByList() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bstackdemo.com/");

        driver.findElement(By.xpath("//select")).click();

        List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));

        String option = "Highest to lowest";

        // Iterate the list using for loop

        for (int i = 0; i < allOptions.size(); i++) {

            if (allOptions.get(i).getText().contains(option)) {

                allOptions.get(i).click();

                System.out.println("clicked");

                break;

            }

        }

    }



    @Test
    // Method 2: By creating Custom Locator and without iterating the List
    public void list() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bstackdemo.com/");

        driver.findElement(By.xpath("//select")).click();

        String option = "Highest to lowest";

        WebElement dropdown = driver.findElement(By.xpath("//select/option[contains(text(), '" + option + "')]"));

        dropdown.click();

        System.out.println("clicked");

    }

    //Method 3: By using JavaScriptExecutor class
    @Test
    public void JavascriptExecutorlist() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bstackdemo.com/");

        WebElement dd = driver.findElement(By.xpath("//select"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].value='highestprice'", dd);

    }

    @Test

    public void  ByUsingSendKeysMethodlist() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bstackdemo.com/");

        driver.findElement(By.xpath("//select")).sendKeys("highestprice");

    }


    //@Test

    /*public void ByUsingActionsClasslist() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.browserstack.com/");

        WebElement dd = driver.findElement(By.xpath("//span[@class='nav_item_name' and contains(text(), 'Developers')]"));

        Actions action=new Actions(driver);

        action.moveToElement(dd).perform();

        String option="Support";

        WebElement customOption=driver.findElement(By.xpath("//li[@class='developers-menu-control']/a[contains(text(), '"+option+"')]"));

        customOption.click();

    }*/
}
