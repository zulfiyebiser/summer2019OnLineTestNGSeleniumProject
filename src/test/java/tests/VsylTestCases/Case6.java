package tests.VsylTestCases;

import com.utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement element =  driver.findElement(By.xpath("//a[@href=\"/registration_form\"]"));
       // System.out.println(element.getText());
        element.click();

       WebElement UserName = driver.findElement(By.xpath("//input[@name=\"username\"]"));

        UserName.sendKeys("user");
        BrowserUtils.wait(2);
        WebElement Warning = driver.findElement(By.xpath("//small[@data-bv-result=\"INVALID\"]"));
        String  WarningMessage = Warning.getText();
       System.out.println(WarningMessage);


        driver.close();
    }
}
