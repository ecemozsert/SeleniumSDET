package lesson_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iFrame_switchingBackMainPage {
    WebDriver driver = new ChromeDriver();

    @Test
    public void switchingBackMainPage() {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame(0);
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
