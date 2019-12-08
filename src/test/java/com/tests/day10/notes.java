package com.tests.day10;

import com.utils.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class notes {
    /*
    Windows, how to switch in between windows/tabs
    Frames
    File uploading
    Alerts/Pop-ups
     driver.switchTo().window(windowHandle); - in thins way we can switch to another window.
     window handle - it's like window id

     //set can store only unique values
     //getWindowHandles() return collection of window id's that are currently opened by webdriver
     Set<String> windowHandles = driver.getWindowHandles();
     String pageTitle = "Practice"; //title of the page that we want
        for (String windowHandle : windowHandles) {
            //keep jumping from window to window
            driver.switchTo().window(windowHandle);
            //once we found a correct page title
            if(driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }
//to open new blank tab
 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(tabs.get(0));
to open hyperlink in the new window use command/control + left click
######################
How to upload file in Selenium?
.sendKeys("path/to/the/file.txt")
For Window: hold shift and make a right click on the file
For Mac: right click and click and hold option button --> copy as a path name
"\"C:\\users\\user\\desktop\\file.txt\""
change \ to \\ or, /. also remove extra double quotes \"

     */
   // public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
      //  WebDriver driver = BrowserFactory.getDriver("chrome");
    //}
}
