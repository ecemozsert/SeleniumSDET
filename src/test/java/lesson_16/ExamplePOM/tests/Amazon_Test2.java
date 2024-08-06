package lesson_16.ExamplePOM.tests;

import lesson_16.ExamplePOM.pages.AmazonPage;
import lesson_16.ExamplePOM.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Amazon_Test2 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // amazon sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown menuden book kategorisini secin
        AmazonPage amazonPage=new AmazonPage(driver);
        Select select=new Select(amazonPage.dropdownMenu);
        select.selectByVisibleText("Books");


        // java icin arama yapin
        amazonPage.aramaKutusu.sendKeys("java"+ Keys.ENTER);
        // bulunan sonuc sayisini yazin
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        // ilk urunun isminde Java gectigini test edin
        Assert.assertTrue(amazonPage.ilkUrunIsim.getText().contains("Java"));


    }
}
