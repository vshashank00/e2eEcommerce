package project.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import project.*;
import project.test.BaseTest;

import java.io.IOException;
import java.util.List;

public class MyStepdefs extends BaseTest {
    public Landingpage landingpage;
    public Productpage productpage;
    public Payment_Addresspage payment_addresspage;
    static List<String> item_ordered;


    @And("Checks password is correct or not")
    public void userEntersUserNameAndPassword() {
        Assert.assertEquals("Incorrect email or password.",landingpage.error());
        System.out.println(landingpage.error());
    }

    @Then("Message displayed and close the browser Successfully")
    public void messageDisplayedLoginSuccessfully() {
        driver.quit();
    }

    @Given("Login in with {} and {}")
    public void loginInWithAnd(String userid, String pass) throws IOException {
        landingpage = indexPage();
        productpage = landingpage.login(userid, pass);
    }

    @When("I add products {} and {} to cart")
    public void iAddProductsToMyCart(String product1, String product2) {
        item_ordered = productpage.addtoCart(product1, product2);

    }

    @And("And product verification done on Checkoutpage")
    public void andProductVerificationDoneOnCheckoutpage() {
        Checkoutpage checkoutpage = new Checkoutpage(driver);
        checkoutpage.verficationofProuct(item_ordered);
        payment_addresspage = checkoutpage.checkoutProduct();

    }

    @Then("{string} message should displayed")
    public void messageShouldDisplayed(String texttoverify) throws InterruptedException {
        payment_addresspage.fillAddress(item_ordered, "Ind", texttoverify);
        driver.quit();
    }

    @Given("User is on Home Page with InValid {} and {} Credentials")
    public void userIsOnHomePageWithInValidAndCredentials(String email, String password) throws IOException {
        landingpage = indexPage();
        productpage = landingpage.login(email, password);

    }

    @Given("Go to login page with {} and {}")
    public void goToLoginPageWithAnd(String email, String password) throws IOException {
        landingpage = indexPage();
        productpage = landingpage.login(email, password);
    }



    @Then("click on my order and check the item is visible are {},{}")
    public void clickOnMyAndCheckTheItemIsVisibleAre(String product1, String product2) {
        productpage.gotoorder(product1,product2);
        driver.quit();

    }
}


