package project;

import project.Reuse.Reusethings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage extends Reusethings {
WebDriver driver;
String url="https://rahulshettyacademy.com/client/";
public Landingpage(WebDriver driver){
    super(driver);
    this.driver=driver;
    PageFactory.initElements(driver,this);

}
    String xpath = "//input[@id=";
@FindBy(xpath = "//input[@id='userEmail']")
    WebElement email;
@FindBy(xpath = "//input[@id='userPassword']")
    WebElement password;
@FindBy (css="[class*='flyInOut']")
    WebElement errommessage;
public Productpage login(String emaillog, String passwordlog){
    email.sendKeys(emaillog);
    password.sendKeys(passwordlog);
    password.submit();
    Productpage productpage=new Productpage(driver);
    return productpage;

}
public String error(){
    visibleWait(errommessage);
    return errommessage.getText();

}
void geturl()
{
    driver.get(url);
}

}
