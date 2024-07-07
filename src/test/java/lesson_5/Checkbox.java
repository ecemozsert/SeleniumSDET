package lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Checkbox {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        // WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();

        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--remote-allow-origins=*");
        // driver = new ChromeDriver();
        driver = new EdgeDriver();



        String baseURL = "https://demo.guru99.com/test/radio.html";
        driver.get(baseURL);
        driver.manage().window().maximize();
        Thread.sleep(2000);

    /*    WebElement onaykutusu1 = driver.findElement(By.id("vfb-6-0"));
        System.out.println("checkbox seÃ§ili durumdadır: " + onaykutusu1.isSelected());
        onaykutusu1.click();
        Thread.sleep(5000);
        onaykutusu1.click();
        System.out.println("Checkbox1 görünebilir durumdadÄ±r: "+ onaykutusu1.isDisplayed());
        System.out.println("Checkbox1 enable durumdadÄ±r: "+onaykutusu1.isEnabled());
        System.out.println("checkbox seçili durumdadÄ±r: " + onaykutusu1.isSelected());*/


        WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        checkBox1.click();
        System.out.println(checkBox1.isEnabled());
        if(checkBox1.isSelected()==true) {
            checkBox1.click();
            System.out.println("checkbox seçili olmaktan çıktı");
        }else{
            System.out.println("checkbox hiç seçili değildi");
        }

        System.out.println(driver.findElements(By.name("webform")).size());
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for(int i=0; i<checkboxes.size(); i++)
        {
            checkboxes.get(i).click();

        }
    }
    }
