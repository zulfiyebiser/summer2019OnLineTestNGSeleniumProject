package com.tests.VyTrack1;


import com.utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrackLoginWithInvalid {
    /*
    •automate the negative test case blow :
    •Go to the login page of VyTrack •
    Enter invalid credential (can be any role)
    •Click login button
    •Verify that the system shows error message “Invalid user name or password.”
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");

        BrowserUtils.wait(2);
        driver.findElement(By.id("prependedInput")).sendKeys("UserUser");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        BrowserUtils.wait(1);
        driver.findElement(By.id("_submit")).click();

        String expectedResult = "Invalid user name or password.";

        BrowserUtils.wait(1);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]"));

        String actualResult = errorMessage.getText();

        System.out.println(actualResult);

         if(actualResult.equalsIgnoreCase(expectedResult))
             System.out.println("Test Passed");
          else
             System.out.println("Test Failed");
        System.out.println(expectedResult);
        System.out.println(actualResult);

        driver.quit();
        }

    }




