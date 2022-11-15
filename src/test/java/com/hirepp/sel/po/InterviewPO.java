package com.hirepp.sel.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class InterviewPO {
    WebDriver driver;

    @FindBy(xpath = "//button[.=' Join ']") public WebElement candJoin;
    @FindBy(xpath = "//button[.=' End Interview ']") public WebElement RecruiterEnd;
    @FindBys(@FindBy(xpath = "//div[@class='col-sm']")) public List<WebElement> Stars;
    @FindBy(xpath = "//button[.='Next Skill']") public WebElement next;
    @FindBy(xpath = "//button[.='SUBMIT']") public WebElement submit;


    public ReportPO RecruiterEndInterview(){

        return new ReportPO(this.driver);
    }

    public void CandidateEndInterview(){
        candJoin.click();
    }

    public InterviewPO(WebDriver driver){
        Reporter.log("inside the Interview page",true);
        this.driver =driver;
        PageFactory.initElements(driver,this);
        Reporter.log("InitElements method Created the webelements in View Jd Page",true);
}
}
