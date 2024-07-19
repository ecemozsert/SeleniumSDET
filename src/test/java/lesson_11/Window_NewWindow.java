package lesson_11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Window_NewWindow {
    WebDriver driver = new EdgeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @Test
    public void NewWindow() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");

        // Open new window by clicking the button
        WebElement windowButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("windowButton")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", windowButton);

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        Set<String> s1 = driver.getWindowHandles();

        System.out.println("Child window handle is" + s1);
        // Click on the new window element and read the text displayed on the window
        WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sampleHeading")));

        // Fetching the text using method and printing it
        System.out.println("Element found using text: " + text.getText());
        driver.quit();
    }
    @Test
    public void NewWindow2() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");

        // Open new child window within the main window
        WebElement windowButton= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("windowButton")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", windowButton);


        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main window ID: " + mainWindowHandle);
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!mainWindowHandle.equalsIgnoreCase(windowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Child Window: "+windowHandle);
                WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sampleHeading")));
                System.out.println("Heading of child window is " + text.getText());
                // Close the child window after verifying the heading
                driver.close();
                // Switch back to the main window
                driver.switchTo().window(mainWindowHandle);
                driver.quit();
            }
        }
    }

    @Test
    public void getWindowHandle(){
        driver.get("https://www.google.com");
        System.out.println(driver.getWindowHandle());
    }


}
