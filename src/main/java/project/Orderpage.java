package project;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Orderpage{
    WebDriver driver;
    public Orderpage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//tr/descendant::td[2]")
    List<WebElement> productname;
    void verifyordersinOrderpage(String product1,String product2){
        boolean True=false;
        for (WebElement element:productname){
            if((element.getText().contains(product1)||element.getText().contains(product2)))
            {

                True=true;

            }

        }
        System.out.println("verification of products on order page is done for: " + product1+","+product2);
        Assert.assertTrue(True);


    }
}
