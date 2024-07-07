package Lesson_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestAssertions {
    static WebDriver driver;

    @BeforeClass
    public static void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test(timeout = 10)
    public void testconsole(){
        System.out.println("Hello World");
    }

    @Test(timeout = 5000)
    public void getURL(){
        driver.get("https://netrd.orioninc.com.tr/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "NetRD";
 /*       if(actualTitle.equals(expectedTitle)){
            System.out.println("Title is shown as expected");
        }
        else {
            System.out.println("Title is wrong");
        }*/

        // Assert.assertEquals(expectedTitle,actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Ignore("Test is disabled for blocking issue.")
    @Test
    public void checkTitle(){
        System.out.println("check title");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
