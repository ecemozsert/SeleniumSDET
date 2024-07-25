package lesson_14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class FileUpload_RobotClassExample2 {

    @Test
    public void fileUpload() throws InterruptedException, AWTException {
        // TODO Auto-generated method stub
        WebDriver driver = new FirefoxDriver(); // starting Firefox browser
        driver.manage().window().maximize(); // maximizing window
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit. SECONDS);//for page load
        driver.get("https://www.grammarly.com/plagiarism-checker");//open testing websiteC:\Users\barisa\IdeaProjects\Lesson_2_Methods\src\test\java\Lesson_14\file-sample_1MB.docx

        driver.manage().timeouts().implicitlyWait(10, TimeUnit. SECONDS);// for Implicit wait

        JavascriptExecutor js = (JavascriptExecutor)driver; // Scroll operation using Js Executor
        js.executeScript("window.scrollBy(0,200)"); // Scroll Down(+ve) upto browse option
        Thread.sleep(2000); // suspending execution for specified time period

        WebElement browse = driver.findElement(By.xpath("//span[normalize-space()='Upload a file']"));
        // using linkText, to click on browse element
        browse.click(); // Click on browse option on the webpage
        Thread.sleep(2000); // suspending execution for specified time period

        // creating object of Robot class
        Robot robot = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection("C:\\Users\\ecozsert\\training\\training\\src\\test\\java\\lesson_14\\file-sample_1MB.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

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
        Thread.sleep(2000); // Wait to see the result
        driver.quit();
    }
}
