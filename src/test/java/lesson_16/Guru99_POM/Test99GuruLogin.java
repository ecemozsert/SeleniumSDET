package lesson_16.Guru99_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test99GuruLogin {

    WebDriver driver;

    Guru99Login objLogin;

    Guru99HomePage objHomePage;

    @BeforeTest

    public void setup() {


        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://demo.guru99.com/V4/");

    }

    /**
     * This test case will login in http://demo.guru99.com/V4/
     * <p>
     * Verify login page title as guru99 bank
     * <p>
     * Login to application
     * <p>
     * Verify the home page using Dashboard message
     */

    @Test(priority = 0)

    public void test_login_invalid_creentials() {

        //Create Login Page object

        objLogin = new Guru99Login(driver);

        //Verify login page title

        String loginPageTitle = objLogin.getLoginTitle();

        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        //login to application


        objLogin.loginToGuru99("mgr123", "mgr!23");

        // go the next page

        objHomePage = new Guru99HomePage(driver);

        //Verify home page

        //Assert.assertFalse(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

        String ActualAlert = driver.switchTo().alert().getText();
        System.out.println(ActualAlert);
        Assert.assertEquals(ActualAlert,"User or Password is not valid");

    }
}
