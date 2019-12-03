package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.Driver;
//everything that is in common among pages
//can go here
//for example top menu elements don't belong to specific page
//top menu appears on every single page
//so we can keep them here
public class BasePage {
    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;
    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;
    @FindBy(css = "#user-menu > a")
    public WebElement userName;
    @FindBy(linkText = "Logout")
    public WebElement logOutLink;
    @FindBy(linkText = "My User")
    public WebElement myUser;
    public BasePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.get(), this);
    }

    /*
    While this loading screen present, html code is a not complete
    some elements will be missing
    Also you won't be able to interact with any elements
    All actions will be intercepted
    Waits until loader mask(loading bar, spinning wheel)disappears
    @return true of if loader mask is gone, false if something went wrong
     */

    public boolean waitUntilLoaderMaskDissapear(){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        try{
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            return  true;
        }catch(NoSuchElementException e) {
            System.out.println("Loader mask not found!");
            System.out.println(e.getMessage());
            return  true; //no loader mask, all good, return true
        }catch(WebDriverException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    /**
     * This method stands for navigation in vytrack app
     * provide tab name, for example "Fleet" as a String
     * and module name, for example "Vehicles" as a String as well
     * then based on these values, locators will be created
     * @param moduleName
     * @param subModuleName
     * normalize-space() same line .trim() in java
     */
    public void navigateTo(String moduleName, String subModuleName) {

        String moduleLocator = "//*[normalize-space()='"+moduleName+"' and @class='title title-level-1']";

        String subModuleLocator = "//*[normalize-space()='"+subModuleName+"' and @class='title title-level-2']";

        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));
        WebElement module = Driver.get().findElement(By.xpath(moduleLocator));
        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.elementToBeClickable(module));
        module.click(); //once we clicked on module, submodule should be visible
        WebElement subModule = Driver.get().findElement(By.xpath(subModuleLocator));
        wait.until(ExpectedConditions.visibilityOf(subModule));
        subModule.click();
        //after navigation
        //wait until loader mask disappear
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
}