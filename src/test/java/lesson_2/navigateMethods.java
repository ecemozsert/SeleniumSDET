package lesson_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class navigateMethods {
    public static void main(String[] args) {

    WebDriver driver ;
    WebDriverManager.chromedriver().setup();

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(chromeOptions);

    //sayfaya gitmek
    driver.navigate().to("https://demoqa.com/");
    //sayfayı refresh
    driver.navigate().refresh();
    //sayfaya geri dönme
    driver.navigate().back();

}
}
