package tests.VyTrack1;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Btrix24 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
      //  driver.findElement(By.cssSelector("a[href=\"/registration_form\"]")).click();
       driver.findElement(By.cssSelector("a[href=\"/registration_form\"]")).click();
      driver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("zulfiye");

        driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("biser");
        driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys("shfsdafhk");
        driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("sdKJDHsd");
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("1234");
        driver.findElement(By.cssSelector("input[name=\"phone\"]")).sendKeys("17823333737");
        driver.findElement(By.cssSelector("input[value=\"male\"]")).click();
        driver.findElement(By.cssSelector("input[placeholder=\"MM/DD/YYYY\"]")).sendKeys("1/1/1222");
        driver.findElement(By.cssSelector("select[name=\"department\"]"));

        driver.close();

    }
}
