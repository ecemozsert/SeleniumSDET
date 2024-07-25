package lesson_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework2 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://pynishant.github.io/dropdown-selenium-python-select.html");
    }

    @Test
    public void task_1(){
        WebElement language = driver.findElement(By.xpath("//div[@class='custom-select']"));
        language.click();
        //Select dropLanguage = new Select(language);// I can not use select class because WebElement under div tag.
        WebElement dropdown = driver.findElement(By.xpath("//div[normalize-space()='Java']"));
        dropdown.click();
        if(dropdown.isSelected()){
            System.out.println("Java is selected.");
        }
        else {
            System.out.println("Element is not selected.");
        }

    }

    @Test
    public void task_2(){
        WebElement language = driver.findElement(By.id("lang"));
        Select dropLanguage = new Select(language);

        if (language.isSelected()) {
            dropLanguage.selectByVisibleText("Python");
            System.out.println("Element is selected.");
        } else {
            System.out.println("Element is not selected. Because it's disable.");
        }
    }

    @Test
    public void task_3(){
        WebElement languages = driver.findElement(By.id("lang2"));
        Select dropLanguages = new Select(languages);
        dropLanguages.selectByIndex(0);
        dropLanguages.selectByValue("c#");
        dropLanguages.selectByVisibleText("Python");
        if(languages.isSelected()){
            System.out.println("Elements are selected.");
        }else {
            System.out.println("Non of them not selected.");

        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
