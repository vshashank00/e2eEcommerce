package project;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import project.test.BaseTest;

import java.io.IOException;

import static project.Reportss.report;

public class AddingReport extends BaseTest implements ITestListener {
    ExtentReports reports=report();
    ExtentTest test;
    ThreadLocal<ExtentTest>local=new ThreadLocal<>();
    @Override
    public void onTestStart(ITestResult result) {
       test= reports.createTest(result.getMethod().getMethodName());
       local.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        local.get().log(Status.PASS,"passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        local.get().fail(result.getThrowable());
        String path = null;
        try {
            driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
                 path= takeSs(result.getMethod().getMethodName(),driver);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            test.addScreenCaptureFromPath(path,result.getMethod().getMethodName());


        }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}

