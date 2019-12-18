package tests.day7;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsTest {

    @BeforeMethod
    public void setup(){
     // some code that will be running before every test, like:test1, test2, test3...
     //we can use method with @BeforeMethod annotation
        // it runs automatically before every method in class.
        System.out.println("before method");
    }

    //it runs automatically after every method in class.
    @AfterMethod
    public void teardown(){
        System.out.println("After method!");
    }

    @Test
    public void test1(){
        System.out.println("Test 1!");
        Assert.assertTrue(5==5); // i works as an if statement
    }

    @Test
    public void test2(){
        System.out.println("Test 2!");

    }

    @Test
    public void test3(){
        System.out.println("Test 3!");

    }
}
