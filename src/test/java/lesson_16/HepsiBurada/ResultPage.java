package lesson_16.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
    private final WebDriver driver;
    private final By resultTestLocator = By.className("searchResultSummaryBar-CbyZhv5896ASVcYBLKmx");
    private final  By productNameLocator = By.xpath("//h3[@data-test-id='product-card-name']");

    public ResultPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getNumberOfSearchResults(){
        return driver.findElement(resultTestLocator);
    }

    public void clickToFirstProduct(){
        driver.findElement(productNameLocator).click();
    }
}
