package com.tests.vytrack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utils.BrowserUtils;
import org.testng.annotations.*;
import com.utils.ConfigurationReader;
import com.utils.Driver;

import java.util.concurrent.TimeUnit;

//this class will be a test foundation for all test classes
//we will put here only before and after parts
//In this way before and after methods will be the same
//Every test class will extend testbase class
public abstract class TestBase {
    protected ExtentReports extentReports;
    //ExtentHtmlReporter creates a rich stanalone HTML file.It allows several
    protected ExtentHtmlReporter extentHtmlReporter;
    // Defines  a test. You can add logs, snapshots,assign author and categories to a test and its children.

    @BeforeTest
    public void beforeTest() {
        //location of report
        //it's gonna be next to target folder, test-output folder
        String filePath = System.getProperty("user.dir") + "test-output/report.html";

        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("Vytrack Test Results");
    }


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



   // public static class LoginTest extends TestBase {
//        @Ignore
//        @Test
//        public void test1(){
//            //read url value from the properties file
//            String url = ConfigurationReader.getProperty("url");
//            //Driver.get() --> will return webdriver object
//            //and then we can call webdriver methods like get(), findElement()....
//    //        WebDriver driver = Driver.get();
//            Driver.get().get(url);
//            //print page title
//            System.out.println(Driver.get().getTitle());
//            BrowserUtils.wait(2);
//            Driver.close();
//        }
//        @Test
//        public void test2(){
//            System.out.println(Driver.get().getTitle());
//            BrowserUtils.wait(2);
//        }
    }

