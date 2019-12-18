package tests.Assigment;

import com.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VytrackCalendarEvents {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        //this setUp of explicit wait
        wait = new WebDriverWait(driver,10);

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));

        //to hover on dropdown menu
        Actions action = new Actions(driver);
        action.moveToElement(activitiesElement).perform();

        driver.findElement(By.linkText("Calendar Events")).click();

        //we need to wait until mask is gone
        WebElement mask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(mask));
    }
    @Test
    public void test1(){
        List<WebElement>elemnts = driver.findElements(By.cssSelector("td[class=\"action-cell grid-cell grid-body-cell\"]"));
        for(WebElement each : elemnts){
            
        }
    }
}
