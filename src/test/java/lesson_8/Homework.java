package lesson_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class Homework {


    static WebDriver driver;

    @Before
    public void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

    }

    @Test
        public void LoginValidCredentials(){

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: "+actualTitle);
        String expectedTitle = "Logged In Successfully | Practice Test Automation";
        System.out.println("Expected Title: "+expectedTitle);

        Assert.assertEquals(expectedTitle,actualTitle);
        //driver.findElement(By.xpath("//h1[text() ='Logged In Successfully']"));

        }
        @Test
    public void InvalidUsername() throws InterruptedException {

            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("InvalidUsername");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Password123");
            WebElement submit = driver.findElement(By.id("submit"));
            submit.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='error' and contains(@class, 'show') and text()='Your username is invalid!']")));
            String expectedErrorMessage = "Your username is invalid!";
            System.out.println("Expected Error Message: "+expectedErrorMessage);

            String actualErrorMessage = errorMessage.getText();
            System.out.println("Actual Error Message: "+ actualErrorMessage);

            Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
        }
@Test
    public void InvalidPassword(){

    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("student");
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("InvalidPassword");
    WebElement submit = driver.findElement(By.id("submit"));
    submit.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='error' and contains(@class, 'show') and text()='Your password is invalid!']")));
    String expectedErrorMessage = "Your password is invalid!";
    System.out.println("Expected Error Message: "+ expectedErrorMessage);

    String actualErrorMessage = errorMessage.getText();
    System.out.println("Actual Error Message: "+ actualErrorMessage);

    Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
}
@Test
    public void VerifyTitle(){

    String PageTitle = driver.getTitle();
    System.out.println("Page Title: "+ PageTitle);

    String ExpectedPageTitle = "Test Login | Practice Test Automation";
    System.out.println("Expected Page Title: "+ ExpectedPageTitle);

    Assert.assertEquals(PageTitle,ExpectedPageTitle);

}
@Test
    public void VerifyTitleAfterLogin(){

    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("student");
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("Password123");
    WebElement submit = driver.findElement(By.id("submit"));
    submit.click();
    String actualLoginTitle = driver.getTitle();
    System.out.println("Actual Title:"+ actualLoginTitle);
    String expectedTitle = "Logged In Successfully | Practice Test Automation";
    System.out.println("Expected Title:" + expectedTitle);
    Assert.assertEquals(actualLoginTitle,expectedTitle);


}
@Test
    public void VerifyLogOut(){

    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("student");
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("Password123");
    WebElement submit = driver.findElement(By.id("submit"));
    submit.click();
    WebElement logOut = driver.findElement(By.xpath("//a[text() ='Log out']"));
    logOut.click();
    String TitleNameLoggedOut = driver.getTitle();
    System.out.println("After Logout process, page title name is: " + TitleNameLoggedOut);

    String ExpectedPageTitle = "Test Login | Practice Test Automation";
    System.out.println("After Logout process,Expected page title name is: "+ExpectedPageTitle);
    Assert.assertEquals(TitleNameLoggedOut,ExpectedPageTitle);

}
  @After
    public void closeTests(){
        driver.quit();
    }
}