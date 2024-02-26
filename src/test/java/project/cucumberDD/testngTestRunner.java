package project.cucumberDD;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/project/cucumberDD/1_ecommerce.feature","src/test/java/project/cucumberDD/2_check_order.feature","src/test/java/project/cucumberDD/error.feature"},glue ="project.steps",monochrome = true,tags = "@Regression",plugin = {"html:target/report7.html"})
public class testngTestRunner extends AbstractTestNGCucumberTests {
}
