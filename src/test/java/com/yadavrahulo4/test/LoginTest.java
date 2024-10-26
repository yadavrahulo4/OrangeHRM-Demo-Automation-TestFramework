package com.yadavrahulo4.test;

import com.yadavrahulo4.controller.DashboardController;
import com.yadavrahulo4.controller.LoginPageController;
import com.yadavrahulo4.utility.BaseTestSetup;
import com.yadavrahulo4.utility.Reusable;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(groups = "smoke", priority = 1)
public class LoginTest extends BaseTestSetup {

    @Test(description = "To Validate Login With Valid Credentials.", priority = 1)
    public void Login_TC001_ValidLoginTest() {
        SoftAssert softAssert = new SoftAssert();
        DashboardController dashboardController = new LoginPageController(reusable).validLogin();
        softAssert.assertTrue(dashboardController.validateDashBoard());
        softAssert.assertAll();
    }

    @Test(description = "To Validate Login With inValid Credentials.", priority = 1)
    public void Login_TC002_InvalidLoginTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPageController loginPageController = new LoginPageController(reusable);
//        loginPageController.login(Reusable.randomStringGenerator(5), Reusable.randomStringGenerator(8));
        loginPageController.login("fsfsdgg", "erwq3r23");
        softAssert.assertTrue(loginPageController.validateInvalidCredentialsErrorMSG());
        softAssert.assertAll();
    }

    @Test(description = "To Validate Login With Empty Credential Fields.", priority = 1)
    public void Login_TC003_InvalidLoginTest() {
        SoftAssert softAssert = new SoftAssert();
        loginPageController = new LoginPageController(reusable);
        loginPageController.login("", "");
        softAssert.assertEquals(loginPageController.validateUserNameRequiredMSG(), loginPageController.validatePasswordRequiredMSG());
        softAssert.assertAll();
    }

    @Test(description = "To Validate Login With Valid UserName & Empty Password Field.", priority = 1)
    public void Login_TC004_InvalidLoginTest() {
        SoftAssert softAssert = new SoftAssert();
        loginPageController = new LoginPageController(reusable);
        loginPageController.login(Reusable.getPropertyValue("username"), "");
        softAssert.assertTrue(loginPageController.validatePasswordRequiredMSG());
        softAssert.assertAll();
    }

    @Test(description = "To Validate Login With Empty UserName Field & valid Password.", priority = 1)
    public void Login_TC005_InvalidLoginTest() {
        SoftAssert softAssert = new SoftAssert();
        loginPageController = new LoginPageController(reusable);
        loginPageController.login("", Reusable.getPropertyValue("password"));
        softAssert.assertTrue(loginPageController.validateUserNameRequiredMSG());
        softAssert.assertAll();
    }

    @Test(description = "To Validate Successful Logout.", priority = 1)
    public void Login_TC006_LogoutTest() {
        SoftAssert softAssert = new SoftAssert();
        loginPageController = new LoginPageController(reusable);
        DashboardController dashboardController = loginPageController.validLogin();
        loginPageController = dashboardController.logout();
        softAssert.assertTrue(loginPageController.validateLoginPage());
        softAssert.assertAll();
    }

}
