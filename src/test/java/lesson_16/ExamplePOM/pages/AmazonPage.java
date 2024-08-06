package lesson_16.ExamplePOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AmazonPage {

    WebDriver driver;
    // bir page sayfasi olusturuldugunda mutlaka yapmamiz gereken sey
    // bir constructor olusturup driver'a ilk degeri atamaktir (instantiate)
    public AmazonPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(tagName = "img")
    public WebElement urunGorseli;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;

    @FindBy(id="searchDropdownBox")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public WebElement ilkUrunIsim;


    //1. yöntem
//    WebElement searchBox2 = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

    //2. yöntem - Page Object Model'de locator bulduk.
    By searchBox3 = By.cssSelector("#twotabsearchtextbox");
    public void searchBox3()
    {driver.findElement(searchBox3).sendKeys("nutella");}

    //3. yöntem - PageFactory yöntemi
    @FindBy(css = "#twotabsearchtextbox")
    public WebElement searchBox;







}
