package com.tests.Assigment;

import com.utils.BrowserFactory;
import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Case1_5 {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.cssSelector("a[href=\"/registration_form\"]")).click();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.findElement(By.cssSelector("input[name=\"birthday\"]")).sendKeys("wrong_dob");
       WebElement warning = driver.findElement(By.cssSelector("small[data-bv-result=\"INVALID\"]"));
       System.out.println(warning.getText());
        BrowserUtils.wait(2);
    }

    @Test
    public void test2(){
      WebElement language1 = driver.findElement(By.cssSelector("input[value=\"cplusplus\"]"));
        language1.click();
        WebElement language2 = driver.findElement(By.cssSelector("input[value=\"java\"]"));
        language2.click();
        WebElement language3 = driver.findElement(By.cssSelector("input[value=\"javascript\"]"));
        language3.click();
        BrowserUtils.wait(2);
        System.out.println(language1.getText()+","+language2.getText()+","+language3.getText());

    }

    @Test
    public void test3() {
        driver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("a");
        WebElement warning2 = driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']"));
        BrowserUtils.wait(2);
        System.out.println(warning2.getText());

    }

    @Test
    public void test4() {
        driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("a");
        WebElement warning = driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']"));
        BrowserUtils.wait(2);
        System.out.println(warning.getText());

    }

    @Test
    public void  test5(){
        driver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("zlfy");
        driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("biser");
        driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys("zlfybsr");
        driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("zlfdj@gmail.com");
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("54321f54");
        driver.findElement(By.cssSelector("input[name=\"phone\"]")).sendKeys("543-888-8888");
        driver.findElement(By.cssSelector("input[value=\"male\"]")).click();
        driver.findElement(By.cssSelector("input[name=\"birthday\"]")).sendKeys("1/3/1977");
        Select select = new Select(driver.findElement(By.cssSelector("select[name=\"department\"]")));
        select.selectByVisibleText("Department of Engineering");
        Select select1 = new Select(driver.findElement(By.cssSelector("select[name=\"job_title\"]")));
        select1.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        WebElement message = driver.findElement(By.tagName("p"));
        System.out.println(message.getText());
        BrowserUtils.wait(3);
    }



    @AfterMethod
    public void Teardown(){
        driver.quit();
    }

}
