package lesson_16.ExamplePOM.tests;

import lesson_16.ExamplePOM.pages.AmazonPage;
import lesson_16.ExamplePOM.utilities.ConfigReader;
import lesson_16.ExamplePOM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Amazon_Test1 {
    // amazon.com
    // search nutella
    // search product results
    @Test(priority = 1)
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        WebElement aramaKutusu =  Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("telefon"+ Keys.ENTER);
        WebElement sonucYazisiElementi=  Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());
        Assert.assertTrue(sonucYazisiElementi.getText().equals("1-16 of 126 results for \"telefon\""));

    }

    @Test(priority = 2)
    public void testPOM(){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage( Driver.getDriver());
        amazonPage.aramaKutusu.sendKeys("nutella"+Keys.ENTER);
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        Assert.assertTrue(amazonPage.sonucYazisiElementi.getText().contains("nutella"));

    }

}
