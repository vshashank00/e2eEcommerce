package project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class Data {
    @DataProvider(name = "ecomdata",parallel = true)
    Object[][] data(){
        String loginData[][]={{"vshashank1@hotmail.com","Shashank@1"}};
        return loginData;
    }
    @DataProvider
    Object[][] fromMap() throws IOException {
        List<HashMap<String,String>>tomap=getdatafromjson();
//        HashMap<String,String> hashmap=new HashMap<>();
//        hashmap.put("Email","vshashank1@hotmail.com");
//        hashmap.put("password","Shashank@1");
//
//        HashMap<String,String> hashmap1=new HashMap<>();
//        hashmap1.put("Email","vshashank1@hotmail.com");
//        hashmap1.put("password","Shashank@1");

        return new Object[][]{{tomap.get(0)}};


    }
    @DataProvider(name = "ecomdatapro",parallel = true)
    Object[][] data1(){
        String product[][]={{"IPHONE 13 PRO","ZARA"}};
        return product;
    }
List<HashMap<String, String>> getdatafromjson() throws IOException {
        String jsonData= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/src/test/java/project/User.json"), StandardCharsets.UTF_8);
    ObjectMapper objectMapper=new ObjectMapper();
    List<HashMap<String,String>>tomap=objectMapper.readValue(jsonData,new TypeReference<List<HashMap<String,String>>>() {
    });
    return tomap;

}


}
