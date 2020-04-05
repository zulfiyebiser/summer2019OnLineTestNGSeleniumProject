package com.tests.day10;

import com.utils.BrowserFactory;
import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploading {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test(description = "verify that file was uploaded")
    public void test1(){
        driver.findElement(By.linkText("File Upload")).click();
        //For Mac: right click and click and hold option button --> copy as a path name
        driver.findElement(By.id("file-upload")).sendKeys("/Users/zulbis/Desktop/ zlf/Alper bey");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        String expectedFileName = "Alper bey";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);
        System.out.println(actualFileName);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}



