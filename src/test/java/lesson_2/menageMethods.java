package lesson_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class menageMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        //URL e erişmek için
        driver.get("https://demoqa.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        System.out.println("Screen Size:" + driver.manage().window().getSize());
        driver.manage().window().setSize(new Dimension(600,600));
        System.out.println("Current Position :" + driver.manage().window().getPosition());
        driver.manage().window().setPosition(new Point(200,300));

    }
    }
