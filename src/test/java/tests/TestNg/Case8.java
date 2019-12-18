package tests.TestNg;

import com.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Case8 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }
    @Test
    public void test8(){
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[type=\"button\"]")).click();
        WebElement message = driver.findElement(By.cssSelector("[id=\"result\"]"));
        String actualMessage = message.getText();
        String expectedMessage = "You selected: United States of America";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
