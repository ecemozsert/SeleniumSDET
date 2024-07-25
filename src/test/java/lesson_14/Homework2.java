package lesson_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

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
        if(dropdown.isDisplayed()){
            System.out.println("Java is selected.");
            String selectedOption = dropdown.getText();
            System.out.println(selectedOption);
            Assert.assertEquals("Java", selectedOption);
        }
        else {
            System.out.println("Element is not selected.");
        }


    }

    @Test
    public void task_2(){
        WebElement language = driver.findElement(By.id("lang"));
        Select dropLanguage = new Select(language);
        dropLanguage.selectByValue("java");

        if (language.isDisplayed()) {
            System.out.println("Element is selected.");

            String selectedOption = dropLanguage.getFirstSelectedOption().getText();
            System.out.println("Expected Option is: "+ selectedOption);
            System.out.println("Actual Option is: Java ");
            Assert.assertEquals("Java", selectedOption);
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
        if(languages.isDisplayed()){
            System.out.println("Elements are selected.");

            // Getting all selected options
            List<WebElement> selectedOptions = dropLanguages.getAllSelectedOptions();
            for (WebElement option : selectedOptions) {
                System.out.println("Actual Selected Options: " + option.getText());
            }

            // Extracting text from selected options
            List<String> actualSelectedOptions = selectedOptions.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());

            // Expected selected options
            List<String> expectedSelectedOptions = List.of("PHP", "C#", "Python");
            System.out.println("Expected Selected Options:"+expectedSelectedOptions);

            // Asserting that the actual selected options match the expected selected options
            Assert.assertEquals(expectedSelectedOptions, actualSelectedOptions);


        }else {
            System.out.println("Non of them not selected.");

        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
