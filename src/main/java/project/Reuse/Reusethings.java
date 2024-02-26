package project.Reuse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Reusethings {
    WebDriver driver;
    WebDriverWait wait;
    public Reusethings(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
         wait=new WebDriverWait(driver, Duration.ofSeconds(5));


    }
    @FindBy(xpath = "//ul/descendant::button[@routerlink=\"/dashboard/cart\"]")
    WebElement cart;

     public void waits(WebElement eleWait){

        wait.until(ExpectedConditions.elementToBeClickable(eleWait));



     }
     public void visibleWait(WebElement webElement){

          wait.until(ExpectedConditions.visibilityOf(webElement));

     }
    public void inwaits(WebElement eleWait){

        wait.until(ExpectedConditions.invisibilityOf(eleWait));



    }
    public void cart(){
        cart.click();

    }

}
