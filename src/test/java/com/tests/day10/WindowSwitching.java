package com.tests.day10;

import com.utils.BrowserFactory;
import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
       driver.findElement(By.linkText("New tab")).click();
       // after 3 second another website will be opened, in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(4);// diger tab 3 sn de aciliyor bunu eklemezsek onu bulamadan kapanip hata verir
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice","Title is Wrong!");
    }
    @Test(description = "Verify that user be able to see new window")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();

        //record id of original window
        String oldWindow = driver.getWindowHandle();
        // WindowHandle - it's like window id

        // after 3 second another website will be opened, in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(4);
        // in the selenium every window has an id. that the id calls WindowHandle
        // to read window handle we use method getWindowHandle()
        // after new window was opened, we can get list of all window id's / window handles

        //list- it's a data structure
        //set it's also a data structure, like list, but it doesn't allow duplicates
        // there is not .get() method
        //that's why, we  need to loop through the set,to read a data from there
        // Set can store only unique values

       Set<String> windowHandles =  driver.getWindowHandles();

       // loop through the collection of window handles
       for(String windowHandle: windowHandles){
           //switch to that window
           if(!windowHandle.equals(oldWindow)){
               driver.switchTo().window(windowHandle);
           }
       }
       //lets verify that title of new window is a fresh tab
        System.out.println(driver.getTitle());
       Assert.assertEquals(driver.getTitle(),"Fresh tab","Title is wrong!");
       // comeback to original page
        // we can build a function that will jump, between windows based on page title
        String pageTitle = "Practice";
        for(String windowHandle:windowHandles){
            // keep jumping from window to window
            driver.switchTo().window(windowHandle);
            // once we found page title,of the window that we need
            if(driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }

        System.out.println(driver.getTitle());
    }

    @AfterMethod

    public void teardown(){
        //driver.quit();
    }
}
