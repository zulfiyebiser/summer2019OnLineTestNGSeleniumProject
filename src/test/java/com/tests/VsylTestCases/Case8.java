package com.tests.VsylTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case8 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        registrationForm.click();
        WebElement PhoneNumber = driver.findElement(By.name("phone"));
        PhoneNumber.sendKeys("5711234354");
        WebElement Warning = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/small[2]"));
        String WarningMessage = Warning.getText();
        System.out.println(WarningMessage);
        driver.quit();

    }
}