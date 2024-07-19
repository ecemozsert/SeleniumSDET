package lesson_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Window_SwitchBackParentWindow {
    WebDriver driver = new ChromeDriver();

    @Test
    public void switchBack() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");

        driver.findElement(By.id("windowButton")).click();
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }

        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainwindow);
        driver.quit();
    }

}
