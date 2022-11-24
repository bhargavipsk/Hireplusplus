package com.hirepp.sel.po;

import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class InterviewJoiningPO {
    WebDriver driver;
    BaseUtils baseUtils=new BaseUtils(driver);
    @FindBy(xpath = "//button[.=' Join ']") public WebElement Join;

    public InterviewPO Joining() throws InterruptedException {
        baseUtils.elementVisibleWait(driver, Join);
        baseUtils.elementClickableWait(driver, Join);
        Join.click();
        Thread.sleep(5000);
        return new InterviewPO(driver);
    }


    public InterviewJoiningPO(WebDriver driver){
        Reporter.log("inside the Interview page",true);
        this.driver =driver;
        PageFactory.initElements(driver,this);
        Reporter.log("InitElements method Created the webelements in View Jd Page",true);
    }
}
