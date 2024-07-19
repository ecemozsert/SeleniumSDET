package lesson_11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class iFramesCalculating {
    WebDriver driver = new ChromeDriver();
    @Test
    public void iFrameCalculation(){
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/guru99home/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        //First Way - By finding all the web elements using iframe tag
      /*  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());*/

        //Second Way - By executing a java script
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);
    }
}
