package com.yadavrahulo4.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtReportListener implements ITestListener {

    protected static ExtentReports extent = null;
    protected static ExtentTest test;
    private String ReportName = "UI Test Report";
    private String DocumentTitle = "Automation Report";

    public ExtentTest getExtTest() {
        if (extent == null) {
            throw new IllegalStateException("ExtentReport has not been initialized");
        }
        return test;
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(
                new File("extentReport" +/*Reusable.getCurrentTimeStamp()+*/".html"));
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle(DocumentTitle);
        reporter.config().setReportName(ReportName);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

//    @Override
//    public void onTestStart(ITestResult result) {
//        test = extent.createTest(result.getMethod().getMethodName());
//    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
