package lesson_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class iFrame_SwitchFrameById {
    WebDriver driver = new EdgeDriver();
    @Test
    public void frameByID(){
        driver.get("https://demoqa.com/frames");

        //Switch by Index
        driver.switchTo().frame("frame1");
    }
}
