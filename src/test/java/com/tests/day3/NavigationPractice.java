package com.tests.day3;


import org.openqa.selenium.WebDriver;
import com.utils.BrowserFactory;
import com.utils.BrowserUtils;
public class NavigationPractice {
    public static void main(String[] args) {
        //create a webdriver object, to work with a browser
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //to maximize browser window
        driver.manage().window().maximize();
        driver.get("http://google.com");
        //wait for 3 seconds
        //this is out custom method
        //since method is static, we use class name to call the method
        //as a parameter, we provide number of seconds(time in seconds)
        BrowserUtils.wait(3);
        driver.navigate().to("http://amazon.com");
        //navigate back to google (previous URL)
        driver.navigate().back();
        //move forward to the amazon again
        driver.navigate().forward();
        //to refresh/reload a webpage/website
        driver.navigate().refresh();
        //shutdown browser
        driver.quit();
    }
}
