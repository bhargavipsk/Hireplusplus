package com.hirepp.sel.po;

import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class InterviewPO {
    WebDriver driver;
    BaseUtils baseUtils=new BaseUtils(driver);

    @FindBy(xpath = "//button[.=' Join ']") public WebElement Join;
    @FindBy(xpath = "//button[.=' End Interview ']") public WebElement End;
    @FindBys(@FindBy(xpath = "//div[@class='col-sm']")) public List<WebElement> Stars;
    @FindBy(xpath = "//button[.='Next Skill']") public WebElement next;
    @FindBy(xpath = "//button[.='SUBMIT']") public WebElement submit;




    public void CandidateJoining(){
        baseUtils.elementVisibleWait(driver,Join);
        Join.click();
    }

    public void RecruiterJoining(){
        baseUtils.elementVisibleWait(driver,Join);
        Join.click();
    }

    public void PanelistJoining(){
        baseUtils.elementVisibleWait(driver,Join);
        Join.click();
    }

    public void candidateEnd() throws InterruptedException {
        baseUtils.elementVisibleWait(driver,End);
        End.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    public void RecruiterEnd() throws InterruptedException {
        baseUtils.elementVisibleWait(driver,End);
        End.click();
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    public void PanelistEnd() throws InterruptedException {
        baseUtils.elementVisibleWait(driver,End);
        End.click();
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }
    public InterviewPO(WebDriver driver){
        Reporter.log("inside the Interview page",true);
        this.driver =driver;
        PageFactory.initElements(driver,this);
        Reporter.log("InitElements method Created the webelements in View Jd Page",true);
}
}
