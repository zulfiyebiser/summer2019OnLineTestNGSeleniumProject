package com.tests.vytrack;

import com.utils.BrowserUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.utils.ConfigurationReader;
import com.utils.Driver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//this class will be a test foundation for all test classes
//we will put here only before and after parts
//In this way before and after methods will be the same
//Every test class will extend testbase class
public abstract class TestBase {

    @BeforeMethod
    public void setup(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        Driver.close();
    }

    public static class LoginTest extends TestBase {
        @Ignore
        @Test
        public void test1(){
            //read url value from the properties file
            String url = ConfigurationReader.getProperty("url");
            //Driver.get() --> will return webdriver object
            //and then we can call webdriver methods like get(), findElement()....
    //        WebDriver driver = Driver.get();
            Driver.get().get(url);
            //print page title
            System.out.println(Driver.get().getTitle());
            BrowserUtils.wait(2);
            Driver.close();
        }
        @Test
        public void test2(){
            System.out.println(Driver.get().getTitle());
            BrowserUtils.wait(2);
        }
    }
}
