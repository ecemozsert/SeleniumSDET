package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

public class Homework3_DownloadAndFileExists {

    WebDriver driver;
    String downloadPath = "C:\\Users\\ecozsert\\Downloads"; // İndirilen dosyaların bulunduğu dizin

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void downloadTest() {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement downloadLink = driver.findElement(By.xpath("//a[text()='image.jpg']"));
        downloadLink.click();

        // Dosya indirme işleminin tamamlanmasını beklemek için
        waitForDownloadToComplete("image.jpg");
    }

    @Test(priority = 2)
    public void isExist() {
        // İndirilen dosyanın tam yolunu belirtin
        File file = Paths.get(downloadPath, "image.jpg").toFile();

        // Dosyanın var olup olmadığını kontrol edin
        if (file.exists()) {
            System.out.println("File downloaded successfully.");
        } else {
            System.out.println("File download failed.");
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void waitForDownloadToComplete(String fileName) {
        File file = Paths.get(downloadPath, fileName).toFile();
        int attempts = 0;
        while (attempts < 10) { // 10 saniyeye kadar bekler
            if (file.exists()) {
                break;
            }
            try {
                Thread.sleep(1000); // 1 saniye bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }
}
