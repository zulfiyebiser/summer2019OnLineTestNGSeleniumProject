package com.tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utils.BrowserFactory;
public class TestsForLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
//      <a href="/autocomplete">Autocomplete</a>
//        Autocomplete - it's the text that you see
        driver.findElement(By.linkText("Autocomplete")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
