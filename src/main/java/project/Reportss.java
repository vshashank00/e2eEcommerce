package project;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class Reportss {
    public static ExtentReports report(){
        String path=System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Report");
        extentSparkReporter.config().setDocumentTitle("ReportofTest");
        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("SDET","Shashank");
        return extentReports;
    }
}
