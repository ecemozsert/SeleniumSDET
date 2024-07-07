package lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Xpath_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver ;
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.get("https://demoqa.com");

        //driver.manage().window().maximize();
        Thread.sleep(2000);


        WebElement form = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][2]"));
        form.click();
        Thread.sleep(2000);
        WebElement practice_form = driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]"));
        System.out.println(practice_form.isDisplayed());
        Thread.sleep(2000);


        WebElement practice_form_button = driver.findElement(By.xpath("//div[@class='element-list collapse show']"));
        practice_form_button.click();

        WebElement first_name = driver.findElement(By.cssSelector("#firstName"));
        first_name.sendKeys("Ecem");
        WebElement last_name = driver.findElement(By.cssSelector("#lastName"));
        last_name.sendKeys("Özsert");
        WebElement email = driver.findElement(By.cssSelector("#userEmail"));
        email.sendKeys("ecemozsert@hotmail.com");






        // driver.quit();
    }
}
