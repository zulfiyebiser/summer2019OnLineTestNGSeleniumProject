package com.tests.Assigment;

import com.utils.BrowserFactory;
import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Case7 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }
    @Test(description = "verify that file was uploaded")
    public void test7(){
        driver.findElement(By.xpath("//a[@href=\"/upload\"]")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/zulbis/Desktop/git-practice/resume.txt");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
       WebElement Message= driver.findElement((By.xpath("//h3[contains(text(),'File Uploaded')]")));
       String actualMessage = Message.getText();
        String expectedMessage = "File Uploaded!";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        String UploadedFile = uploadedFile.getText();
        String UploadedMessage = "resume.txt";
        Assert.assertEquals(UploadedFile,UploadedMessage);
        Assert.assertTrue(uploadedFile.isDisplayed());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
