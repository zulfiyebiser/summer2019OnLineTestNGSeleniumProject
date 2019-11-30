package com.tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utils.BrowserFactory;

import java.util.concurrent.TimeUnit;



public class WaitsPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dynamic Loading")).click();
        //partialLinkText we match only part of the link text(like contains text)
        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();
        // this is "Hello World!"
        WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }
    @Test
    public void test2(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        // select Example 1 we can use xpath as
        driver.findElement(By.partialLinkText("Example 1")).click();

        //click on start button
        driver.findElement(By.tagName("button")).click();

        // we find element first but,the problem is element can be present but not visible
        WebElement userNameInputBox =  driver.findElement(By.id("username"));

        //we create object of WebDriverWait to apply explicit wait
        // we must provide webdriver object and period of time
        //within this period of time selenium will check every 500 milliseconds
        //if condition is true, if condition has met, no need to wait longer
        //your script will continue executing

        WebDriverWait wait = new WebDriverWait(driver,10);//==>wait object

        //how to apply condition ==> ExpectedConditions.condition
        // in this example, selenium webdriver will wait up to 10 seconds, until element is visible
        // if wait time expire, your test will fail(due to exception)

        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));

        //enter username
       userNameInputBox.sendKeys("tomsmith");
       WebElement passwordInputBox = driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        //this is a webelement that represents submit button
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        //wait, within 10 seconds, until that button is available for click
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        WebElement message = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Test
    public void test3(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        //wait until overlay screen disappear
        //otherwise, we will have issue to click or enter the text
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));
        //find webelement of user input box
        WebElement userNameInputBox = driver.findElement(By.id("username"));
        //wait for user name input box to become visible
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        //enter user name
        userNameInputBox.sendKeys("tomsmith");
        //find webelement of password input box
        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        //wait for password input box to become visible
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");
        //this is a webelement that represents submit button
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        //wait, within 10 seconds, until that button is available for click
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        WebElement message = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
//    @Test(description = "Fluent wait example")
//    public void test4(){
//        driver.findElement(By.linkText("Dynamic Loading")).click();
//        driver.findElement(By.partialLinkText("Example 2")).click();
//        driver.findElement(By.tagName("button")).click();
//        Wait wait = new FluentWait(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(200))
//                .ignoring(ElementNotVisibleException.class);
//        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
//                                                         @Override
//                                                         public WebElement apply(WebDriver driver) {
//                                                             return driver.findElement(By.id("finish"));
//                                                         }
//                                                     }
//        );
//    }






    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}
