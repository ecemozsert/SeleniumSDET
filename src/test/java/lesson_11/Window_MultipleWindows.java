package lesson_11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Window_MultipleWindows {
    WebDriver driver = new ChromeDriver();

    @Test
    public void multipleWindows() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        // Opening all the child window

        WebElement windowButton= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("windowButton")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", windowButton);

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("messageWindowButton"))).click();

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // To handle all new opened window
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();

        // Here we will check if child window has other child windows and when child window
        //is the main window it will come out of loop.
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sampleHeading"))).getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }
        driver.quit();
    }
}

