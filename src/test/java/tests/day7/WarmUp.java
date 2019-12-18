package tests.day7;

import com.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {

        //       WebDriverManager.chromedriver().setup();
        //        WebDriver driver= new ChromeDriver(); instead of this two line better to use
        WebDriver driver = BrowserFactory.getDriver("chrome"); // this line most preferable
        driver.get("https://cybertekschool.com/");
        // how to find all links
        // every link as a tag name <a>
        //findElement vs findElements
        //findElement ==> for only 1 webelement
        //findElements ==> for 0 or more elements list can be empty
        // for List we use findElements
        // if list is empty, that means that element is not there
        // in this way ,we can ensure that element doesn't present
        // to find link with text name ==> //tagname[.'text] or //tagname[text()='text]

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: "+links.size());

        // to print text of all links one by one

        for(WebElement webElement: links){
            // print text of every link
            System.out.println(webElement.getText());
        }
        driver.quit();

    }
}
