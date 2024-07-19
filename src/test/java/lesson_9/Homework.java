package lesson_9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.openqa.selenium.By.*;
import static org.testng.Assert.assertEquals;

public class Homework {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {
     //   WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.trendyol.com/");
        Thread.sleep(2000);
        driver.findElement(cssSelector(".modal-close")).click();
        driver.findElement(id("onetrust-accept-btn-handler")).click();
        Thread.sleep(2000);
    }

    //Verify successful login after trying with valid user credentials.

    @Test
    void verifyLogin() throws InterruptedException {
        driver.findElement(xpath("//p[text()='Giriş Yap']")).click(); //Girişyap butonu
        driver.findElement(id("login-email")).sendKeys("ValidUserMail");
        driver.findElement(id("login-password-input")).sendKeys("ValidPassword");
        driver.findElement(cssSelector(".q-primary")).click();
        Thread.sleep(2000);
        WebElement hesabim = driver.findElement(xpath("//p[@class='link-text' and text() ='Hesabım']"));
        String hesabimMessageElementText = hesabim.getText();
        Assert.assertEquals(hesabimMessageElementText,"Hesabım");
    }


    //Verify error message is shown after trying with invalid username.
    @Test
    public void invalidUsername() throws InterruptedException {
        driver.findElement(xpath("//p[text()='Giriş Yap']")).click(); //Girişyap butonu
        driver.findElement(id("login-email")).sendKeys("InvalidUserMail");
        driver.findElement(id("login-password-input")).sendKeys("ValidPassword");
        driver.findElement(cssSelector(".q-primary")).click();
        Thread.sleep(2000);
        WebElement error =driver.findElement(xpath("//span[@class='message' and text() ='E-posta adresiniz ve/veya şifreniz hatalı.']"));
        String errorText =error.getText();
        String expectedMessage ="E-posta adresiniz ve/veya şifreniz hatalı.";
        Assert.assertEquals(errorText,expectedMessage);

    }
    //Verify Searching for an “Elbise” Item.
    @Test
    public void searchDress() throws InterruptedException {
        WebElement searchBar = driver.findElement(cssSelector(".V8wbcUhU"));
        searchBar.sendKeys("Elbise", Keys.ENTER);
        Thread.sleep(2000);
        WebElement afterSearch = driver.findElement(xpath("//h1[text()='Elbise']"));
        String actualText = afterSearch.getText(); //Elbise kelimesi
        System.out.println("Actual Text : "+ actualText);
        System.out.println("Expected Text : "+ "Elbise");
        Assert.assertEquals(actualText,"Elbise");
    }
    //Verify the number results of "Elbise" items
    @Test()
            public void dressSize() {

        WebElement searchBar = driver.findElement(cssSelector(".V8wbcUhU"));
        searchBar.sendKeys("Elbise", Keys.ENTER);
       // List<WebElement> DressItems = driver.findElements(By.xpath("//div[@class ='p-card-wrppr with-campaign-view']"));
       String numberOFdress =  driver.findElement(xpath("//div[@class ='dscrptn dscrptn-V2' and text() = '100.000+']")).getText();
        System.out.println( numberOFdress);
    }
    @Test
    public void addToChart() throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "https://www.trendyol.com/cool-sexy/kadin-siyah-tek-omuz-burumcuk-midi-elbise-ey2830-p-832983164?boutiqueId=662462&merchantId=425");

        WebElement searchBar = driver.findElement(cssSelector(".V8wbcUhU"));
        searchBar.sendKeys("Elbise", Keys.ENTER);
        WebElement dress= driver.findElement(xpath("//*[@id='search-app']/div/div[1]/div[2]/div[4]/div[1]/div/div[2]/div[1]/a"));
        dress.click();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //driver.get("https://www.trendyol.com/kameya/cicek-desen-gupurlu-elbise-24s40476-p-825990089?boutiqueId=61&merchantId=134749");
        WebElement sepeteEkle = driver.findElement(By.xpath("//button[@component-id='1']"));
        sepeteEkle.click();

        Thread.sleep(2000);
        WebElement basketItemCountContainer = driver.findElement(By.xpath("//div[@class='basket-item-count-container visible']"));
        String dressNumber = basketItemCountContainer.getText();
        String expected = "1";
        Assert.assertEquals(dressNumber, expected);



        //List<WebElement> DressItems =
//        driver.findElement(By.xpath("//*[@id='search-app']/div/div[1]/div[2]/div[4]/div[1]/div/div[2]/div[1]/a")).click(); //Elbiseye tıklama
//        driver.findElement(By.cssSelector(".i-cancel"));
//        WebElement sepeteEkle = driver.findElement(By.xpath("//button[@class='add-to-basket']"));
//        String dressNumber = driver.findElement(By.xpath("//div[@class ='basket-item-count-container visible']")).getText();
        //String expected= "1";
        //Assert.assertEquals(dressNumber,expected);

    }








   // @AfterClass
//    void tearDown(){
//        driver.quit();
//    }
}
