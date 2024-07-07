package lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.LocalDate.of;

public class AutomationPracticeForm {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Thread.sleep(2000);


        //Edge'de test calistirmak icin
/*        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();*/

        try {
            // Navigate to the form page
            URL url = new URL("https://demoqa.com/automation-practice-form");
            driver.navigate().to(url);


            Thread.sleep(2000);
            WebElement firstName = driver.findElement(By.id("firstName"));
            firstName.sendKeys("Ecem");

            WebElement lastName = driver.findElement(By.id("lastName"));
            lastName.sendKeys("Özsert");

            WebElement userEmail = driver.findElement(By.id("userEmail"));
            userEmail.sendKeys("ecemozsert@hotmail.com");

            WebElement femaleRadioButton = driver.findElement(By.id("gender-radio-2"));
            femaleRadioButton.sendKeys(Keys.SPACE);

            WebElement userNumber = driver.findElement(By.id("userNumber"));
            userNumber.sendKeys("0555555555");

     /*   WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();
        LocalDate birthDate =LocalDate.of(2002,5,7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd, MM, yyyy");
        String formattedDate = birthDate.format(formatter);
        dateOfBirthInput.clear();
        dateOfBirthInput.sendKeys(formattedDate);
        dateOfBirthInput.click();*/

            // Subjects
            WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
            subjectsInput.sendKeys("Maths");
            subjectsInput.sendKeys("\n");

            WebElement hobbiesRadio1 = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", hobbiesRadio1);
            WebElement hobbiesCheck1 = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
            hobbiesCheck1.click();


      /*      WebElement hobbiesRadio3 = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")); // Select Music
            ((JavascriptExecutor) driver).executeScript("arguments[2].checked = true;, hobbiesRadio3");*/


            WebElement currentAddress = driver.findElement(By.id("currentAddress"));
            currentAddress.sendKeys("mahallesi no sokak");

           //WebElement submitButton = (WebElement) driver.findElements(By.xpath("//button[@id='submit']"));
           // submitButton.submit();
            WebElement submitButton = driver.findElement(By.id("submit"));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
            submitButton.click();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("There is a some error!!!");
        } finally {
            // Close the browser
            // driver.quit();
        }
    }
}
