package tests.day5;

import com.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestForIdLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button = driver.findElement(By.id("disappearing_button"));

        button.click();

        WebElement result = driver.findElement(By.id("result"));

        System.out.println(result.getText());

        driver.quit();

    }
}
