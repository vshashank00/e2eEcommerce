package project.test;

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
import project.Landingpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public  class BaseTest {
    String url="https://rahulshettyacademy.com/client/";
    public Landingpage landingpage;
    public WebDriver driver;
    WebDriver iniliazeBrowser() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/project/Reuse/Browser.properties");
        properties.load(fileInputStream);

        String name = System.getProperty("browser")!=null?System.getProperty("browser"):properties.getProperty("Broweser_name");
        if (name.contains("chrome")) {
            ChromeOptions chromeOptions=new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (name.contains("headless"))
            { chromeOptions.addArguments("headless");}
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setSize(new Dimension(1449,900));

        } else if (name.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (name.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver() ;
        } else
            System.out.println("this is a different driver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(properties.getProperty("Timeout"))));
        return driver;

    }
    protected String takeSs(String testname, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
        File src= takesScreenshot.getScreenshotAs(OutputType.FILE);
        File path=new File(System.getProperty("user.dir") + "\\reports\\"+testname+".png");
        System.out.println(System.getProperty("user.dir"));
        FileUtils.copyFile(src, path);
        return System.getProperty("user.dir") + "\\reports\\"+testname+".png";

    }
    @BeforeMethod(alwaysRun = true)
    protected Landingpage indexPage() throws IOException {
        driver=iniliazeBrowser();
        driver.get(url);
        landingpage=new Landingpage(driver);
        return landingpage;

    }
@AfterMethod
    void close(){
        driver.quit();
        
}
ArrayList<String> Databaseconn() throws SQLException {//method to fetch data from selenium
        String host="localhost";
        String port="3306";
    Connection co =DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Ecomm","root","Shashank@1");
    Statement s=co.createStatement();
    ResultSet resultSet=s.executeQuery("select * from products;");
    resultSet.next();
    resultSet.next();
    ArrayList<String> arrayList= new ArrayList<>();
   arrayList.add( resultSet.getString("product1"));
    arrayList.add(resultSet.getString("product2"));
    return arrayList;
}

}