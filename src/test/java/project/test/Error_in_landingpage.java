package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.Retry;

public class Error_in_landingpage extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    void erroronindex() {
         landingpage.login("vshashank@gmail.com","sdfghjk");
         Assert.assertEquals("Incorrect email or password.",landingpage.error());
         System.out.println(landingpage.error());

    }
}
