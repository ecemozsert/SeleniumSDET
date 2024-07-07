package lesson_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findElement {
    public static void main(String[] args) {

    WebDriver driver ;
    WebDriverManager.chromedriver().setup();

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(chromeOptions);

    //URL e erişmek için
    driver.get("https://demoqa.com/");
    driver.findElements(By.className("home-content"));

    driver.findElements(By.id("fixedban"));
    System.out.println(driver.findElement(By.linkText("https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css")).getText());
}}
