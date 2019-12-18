package tests.VsylTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case7 {

    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.comStep 2. Click on “Registration Form”Step
    3. Enter “testers@email” into email input box.Step
    4. Verify that warning message is displayed: “email address is not a validEmail format is not correct”
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm = driver.findElement(By.xpath("//a[@href=\"/registration_form\"]"));
        registrationForm.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("testers@email");
        WebElement message = driver.findElement(By.xpath("//small[@style=\"display: block;\"][2]"));
        WebElement message2 = driver.findElement(By.xpath("//small[@data-bv-validator=\"emailAddress\"]"));
        String WarningMessage = message.getText();
        String WarningMessage2 = message2.getText();
        String actualMessage = WarningMessage2+WarningMessage;
        String expectedMessage = "email address is not a validEmail format is not correct";
        if(actualMessage.equals(expectedMessage)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
        //Assert.assertEquals(actualMessage,expectedMessage);
       // System.out.println("WarningMessage: "+WarningMessage2+WarningMessage);

        driver.quit();
    }
}
