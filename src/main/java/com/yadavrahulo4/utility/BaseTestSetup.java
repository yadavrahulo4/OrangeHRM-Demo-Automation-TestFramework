package com.yadavrahulo4.utility;

import com.yadavrahulo4.controller.DashboardController;
import com.yadavrahulo4.controller.LoginPageController;
import com.yadavrahulo4.controller.orangeHrmReusableController;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static com.yadavrahulo4.utility.ExtReportListener.extent;
import static com.yadavrahulo4.utility.ExtReportListener.test;

public class BaseTestSetup {


    protected Reusable reusable;
    protected LoginPageController loginPageController;
    private DashboardController dashboardController;

    @BeforeSuite
    public void init() {
//        reusable =  Reusable.getReusableInstance();
    }

    @BeforeTest
    public void launchBrowser() {
        reusable = Reusable.getReusableInstance();
        reusable.launchBrowser();
        Reusable.Wait.setImplicitWait(25);
    }

    @BeforeMethod()
    public void login(ITestResult result) {
        // Get the description of the current test method dynamically
        String description = result.getMethod().getDescription();
        String methodName = result.getMethod().getMethodName();
        // Create a new test in ExtentReports with the description
        test = extent.createTest(methodName, description);
        //        reusable.getExtent().createTest(methodName, description);
        reusable.hitURL();
//        loginPageController= new LoginPageController(reusable);
//        dashboardController= loginPageController.validLogin();
    }

    @AfterMethod()
    public void logout(Method method) {
        if (method.getName().equalsIgnoreCase("Login_TC001_ValidLoginTest"))
            new orangeHrmReusableController(reusable).logout();
    }

    @AfterTest
    public void close() {
//        reusable.close();
    }

    @AfterSuite
    public void end() {
//        reusable.quit();
    }
}
