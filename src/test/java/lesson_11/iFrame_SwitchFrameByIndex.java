package lesson_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class iFrame_SwitchFrameByIndex {
    WebDriver driver = new EdgeDriver();
    @Test()
    public void frameByIndex(){
        driver.get("https://demoqa.com/frames");

        //Switch by Index
        driver.switchTo().frame(0);

    }
    @AfterClass
    public void tearDown (){
        driver.quit();
    }
}
