package lesson_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTables_Example {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver =new ChromeDriver();
        driver.get("https://demo.guru99.com/test/web-table-element.php");
    }
    @Test
    public void DynamicTable(){
        WebElement baseTable = driver.findElement(By.tagName("table"));
        WebElement tableRow = baseTable.findElement(By.xpath("//table//tr[td[contains(text(), 'Equitas Holdings')]]"));
        String rowText = tableRow.getText();
        System.out.println("Second row of the table : "+ rowText);
       Assert.assertEquals(rowText,"Equitas Holdings Ltd A 827.2 381.4 + 4.1");

        WebElement groupA = baseTable.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        System.out.println(groupA.getText());
        Assert.assertEquals("A",groupA.getText());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
