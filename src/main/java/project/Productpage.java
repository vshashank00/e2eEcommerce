package project;

import project.Reuse.Reusethings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Productpage extends Reusethings {


    WebDriver driver;
    public Productpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//div[@class='card']")
   List <WebElement> list;
    @FindBy(xpath = "//div[@id=\"toast-container\"]")
    WebElement toast;
    @FindBy(css = ".ng-animating")
    WebElement ani;
    @FindBy(xpath = "//button[@routerlink=\"/dashboard/myorders\"]")
    WebElement orderpath;

    public List<String> addtoCart(String product1, String product2){
        waits(toast);
        List<String>  s=new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().contains(product2) || list.get(i).getText().contains(product1)) {
                s.add(list.get(i).getText().split("\n")[0]);
                list.get(i).findElement(By.xpath("(//button[contains(text(),\" Add To Cart\")])[" + (i + 1) + "]")).click();
                waits(toast);
                inwaits(driver.findElement(By.cssSelector(".ng-animating")));
            }
        }
        cart();
        return s;

    }
    public void gotoorder(String product1, String product2){
        orderpath.click();
        Orderpage orderpage=new Orderpage(driver);
        orderpage.verifyordersinOrderpage(product1,product2);

    }

}
