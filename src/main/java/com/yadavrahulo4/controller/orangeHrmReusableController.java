package com.yadavrahulo4.controller;

import com.yadavrahulo4.ObjectRepo.orangeHrmReusable;
import com.yadavrahulo4.utility.Reusable;
import org.openqa.selenium.support.PageFactory;

public class orangeHrmReusableController extends orangeHrmReusable {
    private final Reusable utility;

    public orangeHrmReusableController(Reusable utility) {
        this.utility = utility;
        PageFactory.initElements(utility.getDriver(), this);
    }

    public LoginPageController logout() {
        utility.click(profilePicture, "User Profile DD");
        utility.click(logout, "Log Out");
        return new LoginPageController(utility);
    }
}
