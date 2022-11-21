package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class ViewJdPO {
    WebDriver driver;
    boolean flag;
    BaseUtils baseUtils=new BaseUtils(driver);
    List<String> candIds=new ArrayList<>();

    @FindAll({
            @FindBy(xpath = "//button[text()='Add Single Candidate']"),
            @FindBy(xpath = "//button[.='Add Multiple Candidates']"),
            @FindBy(xpath = "//p[text()='Add Candidates']"),
            @FindBy(xpath = "//a[@class='dropdown-item']"),
            @FindBy(xpath = "//a[@class='d-flex dropdown-item']")
    }) public List<WebElement> addCandidate;
    @FindBy(xpath = "//span[.='+ Add Skill']") public WebElement addSkills;
    @FindBy(xpath = "//button[.='+ Add Skills']") public WebElement popupAddSkills;
    @FindBy(xpath = "//button[.='Save']") public WebElement popupSave;
    @FindAll({@FindBy(xpath = "//ul/li")}) public List<WebElement> pages;
    @FindBys(@FindBy( xpath = "//span[@style='font-size: 11px;']")) public  List<WebElement> allCand;
    @FindBy(xpath = "//div[.='Candidate Details']//following-sibling::div[.='Joining Link']//input") public WebElement CandidateInterviewLink;
    @FindBy(xpath = "//div[.='Panelist Details']//following-sibling::div[.='Joining Link']//input") public WebElement PanelistInterviewLink;
    @FindBy(xpath = "//label[.='Upload .zip file']") public WebElement uploadZip;
    @FindBy(xpath = "//button[.='Next']") public WebElement bulkNext;
    @FindBy(xpath = "//button[.='Done']") public WebElement bulkDone;
    @FindBy(xpath = "//a/p") public WebElement RecruiterInterviewLink;
    @FindBy(xpath = "//span[.='Candidates']") public WebElement CandidateVerify;




    public AddCandidatePO goToAddCandidatePO(){
        baseUtils.elementVisibleWait(driver,CandidateVerify);
        if(allCand.size()>0){
            addCandidate.get(0).click();
            addCandidate.get(1).click();
        }
        else {
            addCandidate.get(0).click();
        }
        return new AddCandidatePO(driver);
    }

       public ViewJdPO addBulkCandidate(String exePath) throws Exception{
           baseUtils.elementVisibleWait(driver,CandidateVerify);
        if(allCand.size()>0){
            addCandidate.get(0).click();
            addCandidate.get(2).click();
        }
        else {
            addCandidate.get(1).click();
        }
        uploadZip.click();
        baseUtils.uploadDoc(exePath);
        Thread.sleep(10000);
        bulkNext.click();
        bulkDone.click();
        driver.navigate().refresh();
        return new ViewJdPO(driver);
    }


    public ViewJdPO addSkills(AddJD data) throws InterruptedException {
        baseUtils.elementVisibleWait(driver,addSkills);
        addSkills.click();
        Thread.sleep(2000);
        for(int i=0;i<data.skills.size();i++){
            popupAddSkills.click();
            driver.findElement(By.id("rc_select_"+i)).sendKeys(data.skills.get(i));
            driver.findElement(By.id("rc_select_"+i)).sendKeys(Keys.ENTER);
            driver.findElement(By.id("skillPerc_"+i)).sendKeys(String.valueOf(data.weightage.get(i)));
            Thread.sleep(1000);

        }
        popupSave.click();
        driver.navigate().refresh();
        return new ViewJdPO(this.driver);
    }

    public ReviewCandidatePO goToReviewCandidate(String candId) throws Exception{
        baseUtils.elementVisibleWait(driver,CandidateVerify);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        int i,page=1,last_page ,j = 1;
        if(allCand.size()>0) {
            if(pages.size()>0) {
                last_page = Integer.parseInt(pages.get(pages.size() - 1).getText());
            }
            else{
                last_page=1;
            }
        while (page<=last_page) {
            List<WebElement> candids=driver.findElements(By.xpath( "//span[@style='font-size: 11px;']"));
            for (i = 0; i < candids.size(); i++) {
                if (candids.get(i).getText().equals(candId)) {
                    flag=true;
                    break;
                }
            }
            if (flag==true) {
                driver.findElement(By.xpath("//div[.='"+candId+"']//ancestor::div[@class='col-md-2']/following-sibling::div[.='Review']")).click();
                break;
            } else {
               js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
                if(j==page){
                    break;
                }
                j=page+1;
                driver.findElement(By.xpath("//a[.='" + j + "']")).click();
                Thread.sleep(5000);
            }
            page++;
        }}

        return new ReviewCandidatePO(this.driver);
    }

    public List<String> getCandId() throws Exception{
        baseUtils.elementVisibleWait(driver,CandidateVerify);
        int i,page=1,last_page,j = 1;
        if(allCand.size()>0) {
            if(pages.size()>0) {
                last_page = Integer.parseInt(pages.get(pages.size() - 1).getText());
            }
            else{
                last_page=1;
            }
            while (page <=last_page) {
                List<WebElement> cadids = driver.findElements(By.xpath("//span[@style='font-size: 11px;']"));
                for (i = 0; i < cadids.size(); i++) {
                    candIds.add(cadids.get(i).getText());
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
        }
        return candIds;
    }

    public SchedulePO goToBookSlot(String candId) throws Exception{
        baseUtils.elementVisibleWait(driver,CandidateVerify);
        int i,page=1,last_page ,j = 1;
        if(allCand.size()>0) {
            if(pages.size()>0) {
                last_page = Integer.parseInt(pages.get(pages.size() - 1).getText());
            }
            else{
                last_page=1;
            }
            while (page<=last_page) {
                List<WebElement> candids=driver.findElements(By.xpath( "//span[@style='font-size: 11px;']"));
                for (i = 0; i < candids.size(); i++) {
                    if (candids.get(i).getText().equals(candId)) {
                        flag=true;
                        break;
                    }
                }
                if (flag==true) {
                    driver.findElement(By.xpath("//div[.='"+candId+"']//ancestor::div[@class='col-md-2']/following-sibling::div[.='Schedule Interview']")).click();
                    break;
                } else {

                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
                    if(j==page){
                        break;
                    }
                    j=page+1;
                    driver.findElement(By.xpath("//a[.='" + j + "']")).click();
                    Thread.sleep(5000);
                }
                page++;
            }}


        return new SchedulePO(this.driver);
    }

    public List<String> InterviewLinks(String candId) throws Exception{
        baseUtils.elementVisibleWait(driver,CandidateVerify);
        List<String> link=new ArrayList<>();
        int i,page=1,last_page ,j = 1;
        if(allCand.size()>0) {
            if(pages.size()>0) {
                last_page = Integer.parseInt(pages.get(pages.size() - 1).getText());
            }
            else{
                last_page=1;
            }
            while (page<=last_page) {
                List<WebElement> candids=driver.findElements(By.xpath( "//span[@style='font-size: 11px;']"));
                for (i = 0; i < candids.size(); i++) {
                    if (candids.get(i).getText().equals(candId)) {
                        flag=true;
                        break;
                    }
                }
                if (flag==true) {
                    driver.findElement(By.xpath("//div[.='"+candId+"']//ancestor::div[@class='col-md-2']/following-sibling::div[.='Interview Details']")).click();
                    break;
                } else {

                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
                    if(j==page){
                        break;
                    }
                    j=page+1;
                    driver.findElement(By.xpath("//a[.='" + j + "']")).click();
                    Thread.sleep(5000);
                }
                page++;
            }}
        Thread.sleep(5000);
        link.add(baseUtils.getAttributeVal(PanelistInterviewLink,"value"));
        link.add(baseUtils.getAttributeVal(CandidateInterviewLink,"value"));
//        link.add(PanelistInterviewLink.getText());
//        link.add(CandidateInterviewLink.getText());
        link.add(RecruiterInterviewLink.getText());
        return link;
    }


    public ViewJdPO(WebDriver driver){
        Reporter.log("inside the View Jd page",true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements in View Jd Page", true);
    }


}
