package com.yadavrahulo4.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orangeHrmReusable {
    @FindBy(xpath = "//span/img[@alt='profile picture']")
    protected WebElement profilePicture;
    @FindBy(xpath = "//a[text()='Logout']")
    protected WebElement logout;
    @FindBy(xpath = "//a[text()='Change Password']")
    protected WebElement changePassword;
    @FindBy(xpath = "//a[text()='Support']")
    protected WebElement Support;
    @FindBy(xpath = "//a[text()='About']")
    protected WebElement About;
}