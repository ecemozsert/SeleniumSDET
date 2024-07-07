package lesson_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupsExamples {
    WebDriver driver;

    @Test(groups = "contactFormPage")
    public void test01(){
        System.out.println("Only is work for contact form");
    }

    @Test(groups = {"homePage","regression"})
    public void test02(){
        System.out.println("Only works for home page");
    }
    @Test(groups = "regression")
    public void test03(){
        System.out.println("Only works for Regression Testing");
    }

    @Test(groups = "sustainabilityPage")
    public void test04(){
        System.out.println("Only works for sustainability page");
    }

    @Test(groups = "Subpages")
    public void subPages(){
        driver =new ChromeDriver();
        driver.get("https://www.trendyol.com/butik/l");
        driver.navigate().to("https://www.trendyol.com/butik/liste/9/ayakkabi-canta");
        driver.navigate().back();
        driver.navigate().to("https://www.trendyol.com/butik/liste/5/elektronik");
    }
}
