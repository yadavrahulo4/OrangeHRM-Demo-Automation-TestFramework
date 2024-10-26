package com.yadavrahulo4.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//input[@name='username']")
    protected WebElement userNameIF;
    @FindBy(name = "password")
    protected WebElement passwordIF;
    @FindBy(xpath = "//button[text()=' Login ']")
    protected WebElement loginBT;
    @FindBy(xpath = "//p[text()='Forgot your password? ']")
    protected WebElement forgotPassword;
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    protected WebElement invalidCredentialsMsg;
    @FindBy(xpath = "//input[@name='username']/ancestor::div/following-sibling::span[text()='Required']")
    protected WebElement usernameRequiredMsg;
    @FindBy(xpath = "//input[@name='password']/ancestor::div/following-sibling::span[text()='Required']")
    protected WebElement passwordRequiredMsg;
    @FindBy(xpath = "//h5[text()='Login']")
    protected WebElement loginText;

}
