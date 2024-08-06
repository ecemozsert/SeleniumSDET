package lesson_16.TrendyolHomework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;


    @FindBy(id = "login-email")
    WebElement emailInput;

    @FindBy(id = "login-password-input")
    WebElement passwordInput;

    @FindBy(css = ".q-primary")
    WebElement loginButton;

    @FindBy(xpath = "//p[@class='link-text' and text() ='Hesabım']")
    WebElement hesabimText;

    @FindBy(xpath = "//span[@class='message' and text() ='E-posta adresiniz ve/veya şifreniz hatalı.']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 seconds timeout
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getHesabimText() {
        wait.until(ExpectedConditions.visibilityOf(hesabimText));

        return hesabimText.getText();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
