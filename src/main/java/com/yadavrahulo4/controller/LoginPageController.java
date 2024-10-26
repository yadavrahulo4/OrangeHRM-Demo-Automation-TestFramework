package com.yadavrahulo4.controller;

import com.aventstack.extentreports.Status;
import com.yadavrahulo4.ObjectRepo.LoginPage;
import com.yadavrahulo4.utility.Reusable;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class LoginPageController extends LoginPage {

    private final Reusable reusable;

    public LoginPageController(Reusable reusable) {
        this.reusable = reusable;
        PageFactory.initElements(reusable.getDriver(), this);
    }

    public void typeValidUserNane() {
        reusable.sendKeys(userNameIF, "User Name InputField", Reusable.getPropertyValue("username"));
    }

    public void typeValidPassword() {
        reusable.sendKeys(passwordIF, "Password InputField", Reusable.getPropertyValue("password"));
    }

    public void clickLoginBT() {
        reusable.click(loginBT, "Login button");
    }

    public void login(String username, String password) {

        if (!username.isBlank()) {
            reusable.sendKeys(userNameIF, "User Name InputField", username);
        } else {
            System.out.println("Username is blank");
            reusable.getExtTest().log(Status.INFO, "Blank UserName Field");
        }
        if (!password.isBlank()) {
            reusable.sendKeys(passwordIF, "Password InputField", password);
        } else {
            System.out.println("password is blank");
            reusable.getExtTest().log(Status.INFO, "Blank Password Field");
        }
        try {
            Thread.sleep(Duration.ofSeconds(7));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickLoginBT();
    }

    public DashboardController validLogin() {
        typeValidUserNane();
        typeValidPassword();
        clickLoginBT();
        return new DashboardController(reusable);
    }

    public boolean validateInvalidCredentialsErrorMSG() {
        return reusable.isDisplayed(invalidCredentialsMsg, "Invalid Credentials Error Msg");
    }

    public boolean validateUserNameRequiredMSG() {
        return reusable.isDisplayed(usernameRequiredMsg, "UserName Required Error MSG");
    }

    public boolean validatePasswordRequiredMSG() {
        return reusable.isDisplayed(passwordRequiredMsg, "Password Required Error MSG");
    }

    public boolean validateLoginPage() {
        return reusable.isDisplayed(loginText, "Login Page ");
    }
}
