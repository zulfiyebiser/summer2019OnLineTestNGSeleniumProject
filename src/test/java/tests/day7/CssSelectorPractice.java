package tests.day7;

import com.utils.BrowserFactory;
import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CssSelectorPractice {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //lets find all buttons, and click on them one by one
        //why we put between  . because of there two classes names .btn.btn-primary
        // in this case , we will find all buttons that have: class=".btn.btn-primary'
        //or like this [class=".btn.btn-primary'] no need for
        // . means class name
        // # means id
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        //loop through list of buttons
        for(WebElement button: buttons){
            // and click all buttons one by one
            button.click();
            BrowserUtils.wait((1));
            // get message after click
            WebElement message = driver.findElement(By.cssSelector("#result"));
            //print a text of that message
            System.out.println(message.getText());
        }

        // find element with a tag name  h3, that has a parent element , with class name container
        WebElement header =driver.findElement(By.cssSelector(".container > h3"));
        System.out.println(header.getText());

        WebElement p =driver.findElement(By.cssSelector("[class='container'] > p"));
        System.out.println(p.getText());
        driver.quit();

    }
}
