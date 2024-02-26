package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Payment_Addresspage extends Checkoutpage{
    WebDriver driver;
    public Payment_Addresspage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath ="//div[@class=\"form-group\"]/descendant::span" )
    List<WebElement> listtoselectcountry;
    @FindBy(xpath ="//a[text()=\"Place Order \"]" )
    WebElement placeorder;
    @FindBy (xpath = "//h1")
    WebElement h1;
    public void fillAddress(List<String> s, String countryName, String textverify) throws InterruptedException {
        Actions actions = new Actions(driver);
        Checkoutpage checkout=new Payment_Addresspage(driver);
        checkout.country.sendKeys(countryName);
        for (WebElement webElement : listtoselectcountry) {
            if (webElement.getText().startsWith(countryName)) {
                actions.moveToElement(webElement).click().build().perform();
                actions.moveToElement(placeorder).click().build().perform();
                Assert.assertTrue(h1.getText().contains(textverify));
                System.out.println("Succesfully ordered" + s);
                break;
            }
        }
    }

}
