package project;

import project.Reuse.Reusethings;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Checkoutpage extends Reusethings {
    String checkout="//div[@class=\"subtotal cf ng-star-inserted\"]/descendant::button";
    WebDriver driver;
    public Checkoutpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//p[@class=\"itemNumber\"]/following-sibling::h3")
    List<WebElement>checkList;
    @FindBy(xpath = "//div[@class=\"subtotal cf ng-star-inserted\"]/descendant::button")
    WebElement elementtoclick;
    @FindBy(xpath = "//input[@placeholder=\"Select Country\"]")
    WebElement country;
    public void verficationofProuct(List<String> s){


        int i = 0;
        List<WebElement> checkList = driver.findElements(By.xpath("//p[@class=\"itemNumber\"]/following-sibling::h3"));
        for (WebElement webElement : checkList) {
            if (webElement.getText().contains(s.get(i))) {
                System.out.println("product successfully added in cart and also verified in checkout page: " + s.get(i));
                Assert.assertTrue(webElement.getText().contains(s.get(i)));
                i++;
            }
        }

    }
    public Payment_Addresspage checkoutProduct(){

        Actions actions = new Actions(driver);
        Reusethings reusethings=new Reusethings(driver);
        try {
            reusethings.waits(elementtoclick);
            actions.moveToElement(elementtoclick).click().build().perform();

        }catch (ElementClickInterceptedException e) {
            reusethings.waits(elementtoclick);
            actions.moveToElement(elementtoclick).click().build().perform();
        }
        try {
            reusethings.waits(country);
        }catch (TimeoutException t){
            actions.moveToElement(elementtoclick).click().build().perform();
            reusethings.waits(country);
        }

    Payment_Addresspage payment_addresspage=new Payment_Addresspage(driver);
    return payment_addresspage;
}}
