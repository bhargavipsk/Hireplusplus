package com.hirepp.sel.po;

import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class JobsPO {
    public WebDriver driver;
    BaseUtils cm = new BaseUtils(driver);
    private String jobid;

    @FindBy(xpath = "//button[.='Add JD +']") public WebElement AddJD;
//    @FindBy(xpath = "//p[.='"+jobid+"']") public WebElement job;
    @FindAll({@FindBy(xpath = "//a/h6")}) public List<WebElement> jobs;




    public BasicClientInformationPO goTOAddJDPage() throws InterruptedException {
        Reporter.log("inside the goTOJobs method",true);
        Thread.sleep(3000);
        AddJD.click();
        Reporter.log("Clicked on AddJD",true);
        return new BasicClientInformationPO(this.driver);

    }

    public ViewJdPO goToViewJdPage(){
        driver.findElement(By.xpath("//p[.='"+this.jobid+"']")).click();
//        job.click();
        return new ViewJdPO(driver);
    }



    public JobsPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }
    public JobsPO(WebDriver driver,String jobid){
        this.driver = driver;
        this.jobid=jobid;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }
}
