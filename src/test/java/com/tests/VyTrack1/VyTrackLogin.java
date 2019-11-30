package com.tests.VyTrack1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrackLogin {
    public static void main(String[] args) throws InterruptedException{
        //we have to setup webdriver based on the browser that we gonna use(Chromedriver)
        WebDriverManager.chromedriver().setup();
        // create the object
        ChromeDriver driver = new ChromeDriver();
        // maximize windows
        driver.manage().window().maximize();

        //to open the page to the desired website(get()method allows to open some website
        driver.get("http://qa2.vytrack.com/user/login");
        Thread.sleep(2000);

        //to input username as text into the desired box
        driver.findElement(By.name("_username")).sendKeys("user38");

        Thread.sleep(2000);

        //to input password as text into the desired box
        driver.findElement(By.name("_password")).sendKeys("UserUser123");

        Thread.sleep(2000);
        //I  inspected element in order to find the name identifier of the log in button
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(2000);

        String expectedUrl = "https://qa2.vytrack.com/";  //expected url to show up​

        String actualUrl = driver.getCurrentUrl();  //to get the url of the page we are on currently

        if (expectedUrl.equals(actualUrl)) {     //this makes sure that we are on the desired url,and prints the result, pass or fail
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        driver.quit();

    }
}
