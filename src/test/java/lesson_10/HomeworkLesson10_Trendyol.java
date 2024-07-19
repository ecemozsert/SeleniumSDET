package lesson_10;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.By.xpath;

public class HomeworkLesson10_Trendyol {

    WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass

    public void setup(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get("https://www.trendyol.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(cssSelector(".modal-close"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(id("onetrust-accept-btn-handler"))).click();


}
    //Verify successful login after trying with valid user credentials.
    @Test(priority = 5)
    public void verifyLogin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.trendyol.com/");
        WebElement signIn =wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//p[text()='Giriş Yap']")));
                signIn.click(); //Girişyap butonu
        wait.until(ExpectedConditions.presenceOfElementLocated(id("login-email"))).sendKeys("validUser@hotmail.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(id("login-password-input"))).sendKeys("validPassword");
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(cssSelector(".q-primary")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        WebElement hesabim = wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//p[@class='link-text' and text() ='Hesabım']")));
        String hesabimMessageElementText = hesabim.getText();
        Assert.assertEquals(hesabimMessageElementText,"Hesabım");
    }

    //Verify error message is shown after trying with invalid username.
    @Test(priority = 1)
    public void invalidUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//p[text()='Giriş Yap']")));//Girişyap butonu
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInButton);

        wait.until(ExpectedConditions.presenceOfElementLocated(id("login-email"))).sendKeys("invalidUserMail@hotmail.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(id("login-password-input"))).sendKeys("ValidPassword");
        wait.until(ExpectedConditions.presenceOfElementLocated(cssSelector(".q-primary"))).click();
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//span[@class='message' and text() ='E-posta adresiniz ve/veya şifreniz hatalı.']")));
        String errorText =error.getText();
        String expectedMessage ="E-posta adresiniz ve/veya şifreniz hatalı.";
        Assert.assertEquals(errorText,expectedMessage);

    }

    //Verify Searching for an “Elbise” Item.
    @Test(priority = 2)
    public void searchDress() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(cssSelector(".V8wbcUhU")));
        searchBar.sendKeys("Elbise", Keys.ENTER);
        WebElement afterSearch = wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//h1[text()='Elbise']")));
        String actualText = afterSearch.getText(); //Elbise kelimesi
        System.out.println("Actual Text : "+ actualText);
        System.out.println("Expected Text : "+ "Elbise");
        Assert.assertEquals(actualText,"Elbise");
        searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(cssSelector(".V8wbcUhU"))); // Re-locate the search bar
        searchBar.clear();

    }

    //Verify the number results of "Elbise" items
    @Test(priority = 3)
    public void dressSize() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(cssSelector(".V8wbcUhU")));

        searchBar.sendKeys("Elbise", Keys.ENTER);
        // List<WebElement> DressItems = driver.findElements(By.xpath("//div[@class ='p-card-wrppr with-campaign-view']"));
        String numberOFdress =  driver.findElement(cssSelector(".dscrptn")).getText();
        System.out.println( numberOFdress);
    }
    //Verify Adding one of the "Elbise" Item to the Cart.

    @Test()
    public void addToChart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".V8wbcUhU")));
        element.click();
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(cssSelector(".V8wbcUhU")));
        searchBar.sendKeys("Elbise", Keys.ENTER);
        WebElement dress=  wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//*[@id='search-app']/div/div[1]/div[2]/div[4]/div[1]/div/div[2]/div[1]/a")));
        dress.click();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //driver.get("https://www.trendyol.com/kameya/cicek-desen-gupurlu-elbise-24s40476-p-825990089?boutiqueId=61&merchantId=134749");
        //WebElement sepeteEkle = driver.findElement(By.xpath("//button[@component-id='1']"));
        WebElement sepeteEkle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@component-id='1']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sepeteEkle);


        WebElement basketItemCountContainer =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='basket-item-count-container visible']")));
        String dressNumber = basketItemCountContainer.getText();
        String expected = "1";
        Assert.assertEquals(dressNumber, expected);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
