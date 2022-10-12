package com.hirepp.sel.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ViewJdPO {
    WebDriver driver;

    @FindBy(xpath ="//button[text()='+ Add Candidates']") public WebElement addCandidate;


    public AddCandidatePO goToAddCandidatePO(){
        addCandidate.click();
        return new AddCandidatePO(driver);
    }

    public ViewJdPO(WebDriver driver){
        Reporter.log("inside the View Jd page",true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements in View Jd Page", true);
    }


}
