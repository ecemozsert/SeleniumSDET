package lesson_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Homework1_robotClass {
    @Test
            public void selectFile() throws AWTException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize(); // maximizing window

        driver.get("http://webdriveruniversity.com/File-Upload/index.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// for Implicit wait
        WebElement chooseFile= driver.findElement(By.id("myFile"));
        wait.until(ExpectedConditions.elementToBeClickable(chooseFile));
        StringSelection str = new StringSelection("C:\\Users\\ecozsert\\training\\training\\src\\test\\java\\lesson_14\\file-sample_1MB.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // creating object of Robot class
        Robot robot = new Robot();

        // press Control+V for pasting
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        // release Control+V for pasting
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("Test");
        driver.quit();


    }

}
