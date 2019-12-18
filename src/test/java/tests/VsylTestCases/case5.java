package tests.VsylTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class case5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm = driver.findElement(By.xpath("//a[@href=\"/registration_form\"]"));
        registrationForm.click();
        WebElement LastName = driver.findElementByName("lastname");
        LastName.sendKeys("123");

        WebElement Warning = driver.findElement(By.xpath("//small[@style=\"display: block;\"]"));
        String WarningText = Warning.getText();


        System.out.println(WarningText);

    driver.quit();
    }
}
