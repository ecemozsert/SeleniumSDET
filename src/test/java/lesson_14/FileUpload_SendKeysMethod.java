package lesson_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload_SendKeysMethod {
    @Test
    public void FileUploadTest() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile= driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.sendKeys("C:\\Users\\ecozsert\\training\\training\\src\\test\\java\\lesson_14\\white.screen.png");
        WebElement uploadButton =driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement fileUploadTest = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(fileUploadTest.getText(),"File Uploaded!");
    }

}
