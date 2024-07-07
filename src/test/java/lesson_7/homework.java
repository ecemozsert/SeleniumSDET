package lesson_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class homework
{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bstackdemo.com/");
        List<WebElement> MobilePhoneItems = driver.findElements(By.cssSelector(".shelf-item"));
        System.out.println("Number of the mobile phone devices are: " + MobilePhoneItems.size());
        System.out.println(driver.findElement(By.xpath("//small/span")).getText());
        try {
            Assert.assertEquals(MobilePhoneItems.size(), 25);
            System.out.println("true");
        } catch (AssertionError e) {
            System.out.println("false");
        }
        //driver.quit();

    }
}
