package lesson_16.HepsiBurada;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabBarPage {
    private final WebDriver driver;
    By searchBoxLocator = By.className("searchBoxOld-P2GCKq3V7DvEXIgWsSCP");
    By getSearchBoxLocator2 = By.xpath("//div[@class='searchBoxOld-M1esqHPyWSuRUjMCALPK']");
    By basketTotalNumberLocator = By.xpath("//div[@class='searchBoxOld-M1esqHPyWSuRUjMCALPK']");
    //div[@class='searchBoxOld-M1esqHPyWSuRUjMCALPK']
    public TabBarPage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String searchproductName){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
  /*      JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByXpath('"//div[@class='searchBoxOld-M1esqHPyWSuRUjMCALPK']')[0].click();");
        js.executeScript("document.getElementsByClassName('searchBoxOld-P2GCKq3V7DvEXIgWsSCP')[0].value='laptop';");*/
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementByXpath('//div[@class='searchBoxOld-M1esqHPyWSuRUjMCALPK']').setAttribute('value', 'new value for element')");
        driver.findElement(basketTotalNumberLocator).click();
        driver.findElement(basketTotalNumberLocator).sendKeys(searchproductName);
//driver.findElement(getSearchBoxLocator2).click();
    }
    public String getBasketTotalNumber(){
        return driver.findElement(basketTotalNumberLocator).getText();
    }
}