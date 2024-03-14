package project.test;

import org.testng.annotations.Test;
import project.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class Ecommerce extends BaseTest {
    String product1="IPHONE 13 PRO";
    String product2="ZARA COAT 3";
//    hello git
    @Test(enabled = true, dataProvider = "fromMap" , dataProviderClass = Data.class)
    void e2eEcom(HashMap<String,String> input) throws IOException, InterruptedException, SQLException {
        Productpage productpage=landingpage.login(input.get("Email"),input.get("password"));
        List<String>item_to_be_ordered=Databaseconn();
        List<String>item_ordered=productpage.addtoCart(item_to_be_ordered.get(0),item_to_be_ordered.get(1));
        Checkoutpage checkoutpage=new Checkoutpage(driver);
        checkoutpage.verficationofProuct(item_ordered);
        Payment_Addresspage payment_addresspage=checkoutpage.checkoutProduct();
        payment_addresspage.fillAddress(item_ordered,"Ind","THANKYOU FOR THE ORDER.");

    }
    @Test (enabled = true, dataProvider = "ecomdata", dataProviderClass = Data.class,dependsOnMethods = "e2eEcom")
    void gotoOrderpage(String email, String password) throws SQLException {
        Productpage productpage=landingpage.login(email,password);
        List<String>item_to_be_ordered=Databaseconn();
        productpage.gotoorder(item_to_be_ordered.get(0),item_to_be_ordered.get(1));
    }}

//import io.github.bonigarcia.wdm.WebDriverManager;
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.WebElement;
//        import org.openqa.selenium.chrome.ChromeDriver;
//        import org.openqa.selenium.interactions.Actions;
//        import org.openqa.selenium.support.ui.ExpectedConditions;
//        import org.openqa.selenium.support.ui.WebDriverWait;
//        import org.testng.Assert;
//        import org.testng.annotations.Test;
//
//        import java.awt.*;
//        import java.time.Duration;
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class Ecommerce {
//
//    @Test(enabled = true, dataProvider = "ecomdata", dataProviderClass = Data.class)
//    void e2eEcom(String email, String password) throws AWTException, InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        String xpath = "//input[@id=";
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//        driver.get("https://rahulshettyacademy.com/client/");
//        driver.findElement(By.xpath(xpath + "'userEmail']")).sendKeys(email);
//        WebElement element = driver.findElement(By.xpath(xpath + "'userPassword']"));
//        element.sendKeys(password);
//        element.submit();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id=\"toast-container\"]"))));
//        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"card\"]"));
//        List<String> s = new ArrayList<String>();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getText().contains("IPHONE 13 PRO") || list.get(i).getText().contains("ADIDAS ORIGINAL")) {
//                s.add(list.get(i).getText().split(" ", 2)[0]);
//                list.get(i).findElement(By.xpath("(//button[contains(text(),\" Add To Cart\")])[" + (i + 1) + "]")).click();
//                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id=\"toast-container\"]"))));
//                wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//            }
//        }
//        driver.findElement(By.xpath("//ul/descendant::button[@routerlink=\"/dashboard/cart\"]")).click();
//        int i = 0;
//        List<WebElement> checkList = driver.findElements(By.xpath("//p[@class=\"itemNumber\"]/following-sibling::h3"));
//        for (WebElement webElement : checkList) {
//            if (webElement.getText().contains(s.get(i))) {
//                System.out.println("product addition is verified " + s.get(i));
//                Assert.assertTrue(webElement.getText().contains(s.get(i)));
//                i++;
//            }
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']"))));
//        WebElement elementtoclick = driver.findElement(By.cssSelector(".totalRow button"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(elementtoclick).click().build().perform();
//        driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("ind");
//        List<WebElement> listtoselectcountry = driver.findElements(By.xpath("//div[@class=\"form-group\"]/descendant::span"));
//        for (WebElement webElement : listtoselectcountry) {
//            if (webElement.getText().equalsIgnoreCase("india")) {
//                actions.moveToElement(webElement).click().build().perform();
//                actions.moveToElement(driver.findElement(By.xpath("//a[text()=\"Place Order \"]"))).click().build().perform();
//                Assert.assertTrue(driver.findElement(By.xpath("//h1")).getText().contains("THANKYOU FOR THE ORDER."));
//                System.out.println("Succesfully ordered" + s);
//                break;
//            }
//        }
//        driver.quit();
//
//    }
//}
