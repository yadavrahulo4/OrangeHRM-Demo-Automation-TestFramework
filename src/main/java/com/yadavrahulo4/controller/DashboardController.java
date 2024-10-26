package com.yadavrahulo4.controller;

import com.yadavrahulo4.ObjectRepo.DashboardPage;
import com.yadavrahulo4.utility.Reusable;

public class DashboardController extends orangeHrmReusableController {
    private final Reusable reusable;
    private DashboardPage dashboardOR;

    public DashboardController(Reusable reusable) {
        super(reusable);
        this.reusable = reusable;
        dashboardOR = new DashboardPage(reusable.getDriver());
    }

    public boolean validateDashBoard() {
        return reusable.isDisplayed(dashboardOR.getDashboardWE(), "Dashboard Page");
    }

}
