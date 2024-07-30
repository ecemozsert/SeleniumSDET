package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsDragAndDrop {


    @Test
    public  void ActionsDragAndDropOption1(){
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // URL launch for accessing drag and drop elements
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");

        // identify source and target elements for drag and drop
        WebElement sourceElement= driver.findElement(By.id("draggable"));
        WebElement targetElement= driver.findElement(By.id("droppable"));

        // drag and drop operations without build and perform methods
        Actions a = new Actions(driver);
        a.dragAndDrop(sourceElement, targetElement).build().perform();

        // identify text after element is dropped
        WebElement text = driver.findElement(By.xpath("//*[@id='droppable']/p"));
        System.out.println("Text is : " + text.getText());

        // quitting browser after drag and drop operations completed
        //driver.quit();
    }

    @Test
    public  void ActionsDragAndDropOption2(){
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // URL launch for accessing drag and drop elements
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");

        // identify source and target elements for drag and drop
        WebElement sourceElement= driver.findElement(By.id("draggable"));
        WebElement targetElement= driver.findElement(By.id("droppable"));

        // performing drag and drop operations
        Actions a = new Actions(driver);
        a.clickAndHold(sourceElement)
                .moveToElement(targetElement)
                .release(targetElement)
                .build().perform();

        // identify text after element is dropped
        WebElement text = driver.findElement(By.xpath("//*[@id='droppable']/p"));
        System.out.println("Text is : " + text.getText());

        // quitting browser after drag and drop
        //driver.quit();
    }

    @Test
    public  void ActionsDragAndDropOption3() throws InterruptedException {
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        // adding implicit wait of 15 secs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // URL launch for accessing drag and drop elements
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");

        // identify source and target elements for drag and drop
        WebElement sourceElement= driver.findElement(By.id("draggable"));
        WebElement targetElement= driver.findElement(By.id("droppable"));

        // get x coordinates of source element
        int x = sourceElement.getLocation().getX();

        // get y coordinates of target element
        int y =  targetElement.getLocation().getY();

        // get x coordinates of target element
        int x1 = targetElement.getLocation().getX();

        // get y coordinates of source element
        int y1 =  sourceElement.getLocation().getY();

        // off set difference between target and source
        int locX = x1 - x;
        int locY = y1 - y;

        Thread.sleep(5000);

        // drag and drop with offset
        Actions act = new Actions(driver);
        act.dragAndDropBy(sourceElement, locX, locY).build().perform();


        // identify text after element is dropped
        WebElement text = driver.findElement(By.xpath("//*[@id='droppable']/p"));
        System.out.println("Text is : " + text.getText());

        // quitting browser after drag and drop operations completed
        //driver.quit();
    }


}

