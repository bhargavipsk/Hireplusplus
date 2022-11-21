package com.hirepp.sel.po;

import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ReviewJdPO {

    WebDriver driver;
    String jobId;
    BaseUtils baseUtils=new BaseUtils(driver);

    @FindBy(xpath = "//button[.='Confirm and Save']") public WebElement confirmAndSave;

    public JobsPO goToJob(){
        Reporter.log("inside goToJobs",true);
        baseUtils.elementVisibleWait(driver,confirmAndSave);
        confirmAndSave.click();
        return new JobsPO(this.driver,this.jobId);
    }
    public ReviewJdPO(WebDriver driver, String jobId){
        this.driver=driver;
        this.jobId=jobId;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);

    }
}
