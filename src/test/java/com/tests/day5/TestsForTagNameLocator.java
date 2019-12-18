package com.tests.day5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utils.BrowserFactory;
import com.utils.BrowserUtils;
import org.openqa.selenium.WebElement;

public class TestsForTagNameLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //if you want to do in one line, without creating webelement reference variable
        //enter full name
        BrowserUtils.wait(4);
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        //enter email
        BrowserUtils.wait(4);
        driver.findElement(By.name("email")).sendKeys("test_email@email.com");
        //click sign up
        BrowserUtils.wait(4);
        WebElement elm = driver.findElement(By.tagName("button"));
        System.out.println(elm.getText());
        //pause for 3 seconds
        BrowserUtils.wait(3);
        driver.quit();
    }
}
