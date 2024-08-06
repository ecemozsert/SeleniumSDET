package lesson_16.TrendyolHomework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".V8wbcUhU")
    WebElement searchBar;

    @FindBy(xpath = "//h1[text()='Elbise']")
    WebElement searchResultText;

    @FindBy(xpath = "//div[@class ='dscrptn dscrptn-V2' and text() = '100.000+']")
    private WebElement searchResultCount;

    @FindBy(xpath = "//*[@id='search-app']/div/div[1]/div[2]/div[4]/div[1]/div/div[2]/div[1]/a")
    WebElement firstProduct;

    @FindBy(xpath = "//button[@component-id='1']")
    WebElement addButton;

    @FindBy(xpath = "//div[@class='basket-item-count-container visible']")
    WebElement basketItemCountContainer;

    @FindBy(xpath = "//div[@class='sp-itm'][1]")
    WebElement size;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait with a 10-second timeout
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String item) {
        searchBar.sendKeys(item);
        searchBar.sendKeys(Keys.ENTER);
    }

    public String getSearchResultText() {
        wait.until(ExpectedConditions.visibilityOf(searchResultText)); // Ensure the search result text is visible
        return searchResultText.getText();
    }

    public void selectFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)); // Ensure the first product is clickable
        firstProduct.click();
    }

    public void addToChart() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }
    public void selectSize(){
        wait.until(ExpectedConditions.visibilityOf(size));
        size.click();
    }

    public String getItemCount() {
        wait.until(ExpectedConditions.visibilityOf(basketItemCountContainer));
        return basketItemCountContainer.getText();
    }

    public String getSearchResultCount() {
        wait.until(ExpectedConditions.visibilityOf(searchResultCount)); // Ensure the search result count is visible
        return searchResultCount.getText();
    }
}
