package com.yadavrahulo4.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends orangeHrmReusable {

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardWE;
    @FindBys({@FindBy(xpath = "//div[@class='oxd-table-card --mobile']//div[contains(text(),'Candidate')]/following-sibling::div")})
    private List<WebElement> candidateNamesWE;
    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getCandidateNamesWE() {
        return candidateNamesWE;
    }

    public WebElement getDashboardWE() {
        return dashboardWE;
    }
}
