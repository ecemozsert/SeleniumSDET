package lesson_16.HepsiBurada;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HepsiBuradaRegression extends BaseTestDriver {

    TabBarPage tabBarPage;
    ResultPage resultPage;
    ProductDetailPage productDetailPage;

    @Test(priority = 1)
    public void searchTest() {
        driver.get("https://www.hepsiburada.com/");
        tabBarPage = new TabBarPage(driver);
        tabBarPage.search("telefon");
    }
    @Test(priority = 2)
    public void resultPageTest(){
        driver.get("https://www.hepsiburada.com/");
        resultPage= new ResultPage(driver);
        WebElement resultWebElement = resultPage.getNumberOfSearchResults();
        softAssert.assertTrue(resultWebElement.isDisplayed());
        resultPage.clickToFirstProduct();
    }
    @Test(priority = 3)
    public void addToCartTest(){
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addToCart();}
}