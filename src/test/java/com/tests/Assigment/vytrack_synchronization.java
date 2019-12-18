package com.tests.Assigment;

import com.utils.BrowserFactory;
import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class vytrack_synchronization {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        //this setUp of explicit wait
        wait = new WebDriverWait(driver,10);

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));

        //to hover on dropdown menu
        Actions action = new Actions(driver);
        action.moveToElement(activitiesElement).perform();

        driver.findElement(By.linkText("Calendar Events")).click();

        //we need to wait until mask is gone
        WebElement mask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(mask));

    }

    @Test(description = "Verify that page subtitle \"Options\" is displayed")
    public void test1(){
        WebElement el = driver.findElement(By.cssSelector("[class=\"btn btn-link dropdown-toggle\"]"));
        String expected = "Options";
        String actual = el.getText();
        Assert.assertEquals(expected,actual,"test failed");
    }

    @Test(description = "Verify that page number is equals to \"1\"")
    public void test2(){
        String actual = driver.findElement(By.cssSelector("[type=\"number\"]")).getAttribute("value");
       String expected ="1";
       Assert.assertEquals(actual,expected);
    }

    @Test(description = "Verify that view per page number is equals to \"25\"")
    public void test3(){

        String actualResult = driver.findElement(By.cssSelector("[class=\"btn dropdown-toggle \"]")).getText();
        String expectedResult ="25";
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4(){
        //int expected = 21;
        WebElement element = driver.findElement(By.xpath("//label[@class=\"dib\"][3]"));
        String expected = element.getText();
        int actual = driver.findElements(By.cssSelector("[class=\"grid-row row-click-action\"]")).size();
        String actualSize = "Total Of "+actual+" Records";
        Assert.assertEquals(actualSize,expected);

    }
    @Test(description = "Verify that all calendar events were selected")
    public void test5(){
        //read it from top left of table
        int actualNumOfRec = driver.findElements(By.cssSelector("tr[class='grid-row row-click-action']")).size();
        //clicking on checkbox to select all records
        driver.findElement(By.cssSelector("[class='btn btn-default btn-small dropdown-toggle']>input")).click();
        //to get how many selected records are there after clicking on checkbox
        int numOfSelectedRows = driver.findElements(By.cssSelector("[class='grid-row row-click-action row-selected']")).size();

        Assert.assertEquals(numOfSelectedRows, actualNumOfRec);
    }
    @Test(description = "Verify that following data is displayed:")
    public void test6(){
        driver.findElement(By.xpath("//tr[13]")).click();

       String expected = "Title\nTesters Meeting\nDescription\nThis is a a weekly testers meeting\nStart\nNov 27, 2019," +
               " 9:30 PM\nEnd\nNov 27, 2019, 10:30 PM\nAll-day Event\nNo\nOrganizer\nStephan Haley\nGuests\nTom Smith - Required\nRecurrence\nWeekly every 1 week on Wednesday\nCall Via Hangout\nNo";


        WebElement actual = driver.findElement(By.cssSelector("div[class=\"row-fluid form-horizontal\"]"));
        String actualMessage = actual.getText();
//
        Assert.assertEquals(actualMessage,expected);
    }



    @AfterMethod
    public void teardown(){

        driver.quit();
    }

}
