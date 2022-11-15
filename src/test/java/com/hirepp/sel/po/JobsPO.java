package com.hirepp.sel.po;

import com.hirepp.utils.BaseUtils;
import com.hirepp.utils.ExcelOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobsPO {
    public WebDriver driver;
    BaseUtils cm = new BaseUtils(driver);
    ExcelOperations excelOperations = new ExcelOperations();
    private String jobid;
    boolean flag;

    @FindBy(xpath = "//button[.='Add JD +']") public WebElement AddJD;
//    @FindBy(xpath = "//p[.='"+jobid+"']") public WebElement job;
//    @FindAll({@FindBy(xpath = "//a/p")}) public List<WebElement> jobids;
    @FindAll({@FindBy(xpath = "//a[@rel='nofollow']")}) public List<WebElement> pages;


    public String getJobid(){
        return this.jobid;
    }


    public BasicClientInformationPO goTOAddJDPage() throws InterruptedException {
        Reporter.log("inside the goTOJobs method",true);
        Thread.sleep(3000);
        AddJD.click();
        Reporter.log("Clicked on AddJD",true);
        return new BasicClientInformationPO(this.driver);

    }

    public ViewJdPO goToViewJdPage() throws IOException {
        excelOperations.JdIdStoring("./ScriptsDocs/JDdata.xlsx", "ids", this.jobid);
        driver.findElement(By.xpath("//p[.='"+this.jobid+"']")).click();
//        job.click();
        return new ViewJdPO(this.driver);
    }

    public ViewJdPO goToViewJdPage(String JobId) throws Exception {
        int i,page=1,last_page;

        last_page= Integer.parseInt(pages.get(pages.size()-1).getText());
        while (page<=last_page) {
            List<WebElement> jobids=driver.findElements(By.xpath( "//a/p"));
            for (i = 0; i < jobids.size(); i++) {
                if (jobids.get(i).getText().equals(JobId)) {
                    flag=true;
                    break;
                }
            }
            if (flag==true) {
                driver.findElement(By.xpath("//p[.='" + JobId + "']")).click();
                break;
            } else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
                int j=page+1;
                driver.findElement(By.xpath("//a[.='" + j + "']")).click();
                Thread.sleep(5000);
            }
            page++;
        }

        return new ViewJdPO(this.driver);
    }

    public List<String> getJobIds() throws Exception {
        List<String> jobIds=new ArrayList<>();
        int i,page=1,last_page,j=0;
        last_page= Integer.parseInt(pages.get(pages.size()-1).getText());
        System.out.println(last_page);
        while (page<=last_page) {
            List<WebElement> jobids = driver.findElements(By.xpath("//a/p"));
            for (i = 0; i < jobids.size(); i++) {
                jobIds.add(jobids.get(i).getText());
            }

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
           if(j<last_page) {
               j = page + 1;
               driver.findElement(By.xpath("//a[.='" + j + "']")).click();
               Thread.sleep(5000);

           }
            page++;

        }
        return jobIds;
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
