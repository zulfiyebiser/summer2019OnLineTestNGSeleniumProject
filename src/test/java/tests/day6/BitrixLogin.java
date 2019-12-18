package tests.day6;

import com.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*

 */

public class BitrixLogin {
    public static void main(String[] args) {
        // getDriver() method returns object of webdriver
        //we need webDriver objectto send commands to the browser
        // left side is arefrence variable to ereuse this object
        //object can be created and used without refernce variable
        //but it's gonna be impossible to use that
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //go to bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.xpath("//input[@name=\"USER_LOGIN\"]")).sendKeys("helpdesk37@cybertekschool.com");
        //enter password
        //*matches any element
        //its better to specify tag name, to avoid issues with finding element
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();


    }
}
