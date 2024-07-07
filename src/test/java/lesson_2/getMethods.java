package lesson_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class getMethods {
    public static void main(String[] args) {

        WebDriver driver ;
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        //URL e erişmek için
        driver.get("https://demoqa.com/");
        //Sayfanın source kodu
        System.out.println("Sayfanın kaynak kodu " + driver.getPageSource());
        //Sayfanın hash kodu
        System.out.println("Hash Code " + driver.getWindowHandles());

        System.out.println("Current URL" + driver.getCurrentUrl());

        System.out.println("Title" + driver.getTitle());

        driver.get("https://www.bstackdemo.com/");
     List< WebElement > phones = driver.findElements(By.cssSelector(".shelf-item"));

     System.out.println( "Telefonların sayısı" + phones.size());
        try {
            Assert.assertEquals(phones.size(), 26);
            System.out.println("true");
        } catch (AssertionError e) {
            System.out.println("false");
        }
    }
}
