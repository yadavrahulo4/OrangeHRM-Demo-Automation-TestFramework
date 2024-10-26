package com.yadavrahulo4.test;

import com.yadavrahulo4.controller.DashboardController;
import com.yadavrahulo4.controller.LoginPageController;
import com.yadavrahulo4.utility.BaseTestSetup;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(groups = "sanity", priority = 2)
public class DashBoardTest extends BaseTestSetup {

    @Test(description = "To Verify Navigation to Dashboard after successful Login.", priority = 1)
    public void Login_TC007_DashBoardTest() {
        SoftAssert softAssert = new SoftAssert();
        loginPageController = new LoginPageController(reusable);
        DashboardController dashboardController = loginPageController.validLogin();
        softAssert.assertTrue(dashboardController.validateDashBoard());
        softAssert.assertAll();
    }

    @Test(description = "To Verify All expected Dashboard elements visibility.", priority = 2)
    public void Login_TC008_DashBoardTest() {
        SoftAssert softAssert = new SoftAssert();
        loginPageController = new LoginPageController(reusable);
        DashboardController dashboardController = loginPageController.validLogin();
        loginPageController = dashboardController.logout();
        softAssert.assertTrue(loginPageController.validateLoginPage());
        softAssert.assertAll();
    }
}
