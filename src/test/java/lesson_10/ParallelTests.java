package lesson_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTests {
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) {
        switch (browser){
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                //driver.manage().window().maximize();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                //driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Check browser name");
        }

    }

    @Test()
    public void getTitleForLinkedin() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.get("https://linkedin.com/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String PageTitle = driver.getTitle();

        System.out.println("Actual Page Title: "+ PageTitle);
        System.out.println("Expected Page Title: LinkedIn: Log In or Sign Up");
        //Assert.assertTrue(PageTitle.isEmpty());
        Assert.assertEquals(PageTitle,"LinkedIn: Log In or Sign Up");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
