package tests.practice;

import com.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm {
    public static void main(String[] args) throws Exception{
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a[href=\"/registration_form\"]")).click();
        driver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("zulfiye");
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
        Thread.sleep(3000);
        driver.quit();
    }
}
