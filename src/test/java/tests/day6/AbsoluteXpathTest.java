package tests.day6;

import com.utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbsoluteXpathTest {
    public static void main(String[] args) {
        //create object
        //WebDriver driver = BrowserFactory.getDriver("chrome");
        //second way
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
    driver.get("https://login1.nextbasecrm.com/?login=yes");
    driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
        WebElement warningMessage = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        System.out.println(warningMessage.getText());

    }
}
