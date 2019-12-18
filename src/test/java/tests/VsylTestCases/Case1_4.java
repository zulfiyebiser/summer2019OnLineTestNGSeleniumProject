package tests.VsylTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Case1_4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
    // Test Case 1
        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement link = driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[43]/a"));

        link.click();

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[1]/div/input")).sendKeys("Zulfiye");

        driver.findElement(By.name("email")).sendKeys("zlfdnbsr@gmail.com");

        driver.findElement(By.name("wooden_spoon")).click();

        String expectedResult ="Thank you for signing up. Click the button below to return to the home page.";

        WebElement signUpMessage = driver.findElement(By.name("signup_message"));
        String actualResult = signUpMessage.getText();
        System.out.println(actualResult);

        if(expectedResult.equals(actualResult)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        //TestCase2
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        List<WebElement> list = driver.findElements(By.className("list-group-item"));
        int listOfsize = list.size();
        System.out.println("size: "+listOfsize);

        //TestCase3
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        WebElement multipleButton =driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a"));
        multipleButton.click();
        WebElement button1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]"));
        button1.click();
        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();
        System.out.println(resultText);

        //Test Case 4
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        registrationForm.click();
        WebElement firstName = driver.findElementByName("firstname");
        firstName.sendKeys("123");
        WebElement errorMassage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]"));
        String ErrorMessage = errorMassage.getText();
        System.out.println(ErrorMessage);


        //Test Case 5


        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm2 = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        registrationForm2.click();
        WebElement LastName = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/label"));
        LastName.sendKeys("123");

       // System.out.println(Warning);


        driver.quit();
    }
}
