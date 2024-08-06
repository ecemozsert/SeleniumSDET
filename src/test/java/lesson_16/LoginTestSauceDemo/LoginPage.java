package lesson_16.LoginTestSauceDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    //Locators
    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By submitButtonLocator = By.id("login-button");

    By dropdown = By.xpath("//dropdown");

    //Constructor(yapıcı method)
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickSubmitButton(){
        driver.findElement(submitButtonLocator).click();
    }
}
