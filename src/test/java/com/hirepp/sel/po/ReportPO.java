package com.hirepp.sel.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ReportPO {
    WebDriver driver;




    public ReportPO(WebDriver driver){
        Reporter.log("inside the Report page",true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements in View Jd Page", true);
    }
}
