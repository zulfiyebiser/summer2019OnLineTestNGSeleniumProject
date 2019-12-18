package com.tests.VyTrack1;
import com.utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public static class VyTrackLoginWithInvalid {
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
}
