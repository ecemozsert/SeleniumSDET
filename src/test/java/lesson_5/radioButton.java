package lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class radioButton {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.edgedriver().setup();

        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        //driver = new EdgeDriver();

        String baseURL = "https://demo.guru99.com/test/radio.html";
        driver.get(baseURL);
        driver.manage().window().maximize();
        Thread.sleep(2000);


        WebElement radioButton1 = driver.findElement(By.cssSelector("#vfb-7-2"));
        //radioButton1.click();
        radioButton1.sendKeys(Keys.SPACE);


        /*WebElement radioButton1 = driver.findElement(By.id("vfb-7-1"));
        radioButton1.click();

        WebElement radioButton2 = driver.findElement(By.id("vfb-7-2"));
        radioButton2.click();

        WebElement radioButton3 = driver.findElement(By.id("vfb-7-3"));
        radioButton3.click();
*/



    }
}
