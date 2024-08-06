package lesson_16.TrendyolHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    @FindBy(css = ".modal-close")
    WebElement closeModal;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookies;

    @FindBy(xpath = "//p[text()='Giriş Yap']")
    WebElement loginButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closeModal() {
        closeModal.click();
    }

    public void acceptCookies() {
        acceptCookies.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}