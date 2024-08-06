package lesson_16.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private final WebDriver driver;

    private final By addToBasketLocator= By.id("addToCart");

    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        driver.findElement(addToBasketLocator).click();
    }
}
