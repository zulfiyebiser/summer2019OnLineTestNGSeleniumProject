package tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenColseAndQuit {

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        //this two line allows to set up
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000); // will pause program execution for 4 seconds
        // sleep() nmethod throws checked exception ,that you need to take care of before running a program.Otherwise
        // you will getcompilation error. As this point ,just add throws InterruptedException in the method signature.
        //when we see millis
        //lets try to close browser
        driver.close();// will close only one tab
        //driver.quit();

    }
}
