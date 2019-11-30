package com.tests.BasicNavigation;

import com.utils.BrowserFactory;
import com.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case6 {

    private WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        WebElement email = driver.findElement(By.cssSelector("[class=\"animace\"]"));
        String mail = email.getText();
        System.out.println(mail);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("zlfy");
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("wooden_spoon")).click();
        WebElement element = driver.findElement(By.name("signup_message"));
        String expectedMesaage = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertTrue(element.isDisplayed(),expectedMesaage );

        BrowserUtils.wait(4);

       driver.navigate().to("https://www.tempmailaddress.com/");
        WebElement receivedEmail = driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
        Assert.assertTrue(receivedEmail.isDisplayed(), "do-not-reply@practice.cybertekschool.com");
        receivedEmail.click();
        WebElement message = driver.findElement(By.id("predmet"));
        String expected = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertTrue(message.isDisplayed(),expected);
        driver.quit();

    }

}
