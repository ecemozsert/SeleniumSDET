package lesson_16.TrendyolHomework;

import lesson_16.ExamplePOM.pages.AmazonPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import lesson_16.TrendyolHomework.Driver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class TrendyolTests {

    WebDriver driver;

    MainPage mainPage;
    LoginPage loginPage;
    SearchPage searchPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

        Thread.sleep(200);
        mainPage.closeModal();
        Thread.sleep(500);

        mainPage.acceptCookies();

    }

    @AfterClass
    public void tearDown() {
        Driver.quitDriver();
    }

    @Test
    public void verifyLogin() throws InterruptedException {
        LoginPage loginPage =new LoginPage( lesson_16.TrendyolHomework.Driver.getDriver());

        mainPage.clickLoginButton();
        loginPage.enterEmail("validUserMail@hotmail.com");
        loginPage.enterPassword("ValidPassword");
        loginPage.clickLoginButton();
        System.out.println(loginPage.getHesabimText());
        Assert.assertEquals(loginPage.getHesabimText(), "Hesabım");
    }

    @Test
    public void invalidUsername() {
        mainPage.clickLoginButton();
        loginPage.enterEmail("InvalidUserMail@hotmail.com");
        loginPage.enterPassword("ınvalidPassword");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test
    public void searchDress() throws InterruptedException {
        Thread.sleep(500);
        searchPage.searchFor("Elbise");
        Thread.sleep(500);

        Assert.assertEquals(searchPage.getSearchResultText(), "Elbise");
    }

    @Test
    public void dressSize() {
        searchPage.searchFor("Elbise");
        System.out.println(searchPage.getSearchResultCount());
        Assert.assertEquals(searchPage.getSearchResultCount(), "\"\n" +
                "Elbise\n" +
                "\" araması için 100.000+ sonuç listeleniyor");
    }


    @Test
    public void addToChart() throws InterruptedException {
        searchPage.searchFor("Elbise");
        searchPage.selectFirstProduct();

        Thread.sleep(500);

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        Thread.sleep(2000); // Wait for the item to be added to the cart

        searchPage.selectSize();
        searchPage.addToChart();

        String expected = "1";
        Assert.assertEquals(searchPage.getItemCount(), expected);
    }
}