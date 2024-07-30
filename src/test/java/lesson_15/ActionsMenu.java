package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ActionsMenu {
    @Test
    public void MainMenuAndSubMenu(){
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/menu.php#");

        // identify element with xpath for menu
        WebElement m = driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[3]/a"));

        // object of Actions class to click and hold
        Actions a = new Actions(driver);
        a.moveToElement(m).click().build().perform();

        // identify  all sub-menu under main menu
        List<WebElement> l= driver.findElements(By.xpath("//*[@id='navbarSupportedContent']/ul/li[3]/ul/li"));
        for(int i = 0; i < l.size(); i++){
            System.out.println("Sub-menus are: " + l.get(i).getText());
        }

        // Closing browser
        //driver.quit();

    }
}
