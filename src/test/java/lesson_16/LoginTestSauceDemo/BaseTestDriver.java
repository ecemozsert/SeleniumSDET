package lesson_16.LoginTestSauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestDriver {

    WebDriver driver;

    LoginPage loginPage;

    @BeforeClass
    public void setup(){
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

/*    @AfterClass
    public void tearDown(){
        driver.quit();
    }*/
}
