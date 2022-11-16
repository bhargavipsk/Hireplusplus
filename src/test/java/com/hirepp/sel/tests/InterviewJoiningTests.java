package com.hirepp.sel.tests;

import com.hirepp.sel.po.*;
import com.hirepp.utils.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class InterviewJoiningTests extends TestBaseSetup {
    String email = "kongarir@bridgentech.com";
    String password = "recruiter";

    ViewJdPO viewJdPO;
    LoginPagePO login_po;
    DashboardPagePO dashboardPagePO;
    SideBarPO sideBarPO;
    JobsPO jobsPO;
    AddCandidatePO addCandidatePO;
    ReviewCandidatePO reviewCandidatePO;
    SchedulePO schedulePO;
    InterviewPO panelistInterviewPO;
    InterviewPO recruiterInterviewPO;
    InterviewPO candidateInterviewPO;
    BasicClientInformationPO basicClientInformationPO;
    GeneralDetailsPO generalDetailsPO;
    ChooseAnOptionPO chooseAnOptionPO;

    ExcelOperations excelOperations=new ExcelOperations();
    BaseUtils baseUtils=new BaseUtils(driver);


    @Test
    public void InterviewJoining()throws Exception{
        int jdno,canNo;
        Random random=new Random();
        jdno=random.nextInt(6)+1;
        canNo= random.nextInt(19)+1;
        AddJD jdData = excelOperations.jdInputsExcel("./ScriptsDocs/JDdata .xlsx", "JD", jdno);
        AddCandidate candData=excelOperations.candidateExcelRead("./ScriptsDocs/JDdata .xlsx","candidate",canNo);
//        System.out.println(jdData.exePath);
        Thread.sleep(10000);
        FirstPagePO firstPagePO = new FirstPagePO(driver);
        login_po = firstPagePO.goTOLoginPage();
        Thread.sleep(5000);
        login_po.Login_HirePP(email, password);
        Thread.sleep(5000);
        sideBarPO=new SideBarPO(driver);
        Thread.sleep(5000);
        jobsPO=sideBarPO.goTOJobsPage();
        Thread.sleep(5000);
        basicClientInformationPO=jobsPO.goTOAddJDPage();
        Thread.sleep(5000);
        generalDetailsPO=basicClientInformationPO.goToGeneralDetailsPage(jdData);
        Thread.sleep(5000);
        chooseAnOptionPO=generalDetailsPO.goToChooseOptionPage(jdData);
        Thread.sleep(5000);
        jobsPO=chooseAnOptionPO.goToUpload(jdData.exePath);
        Thread.sleep(10000);
        jdData.jobId= jobsPO.getJobid();
//        jdData.jobId=excelOperations.getJobId("./ScriptsDocs/JDdata .xlsx", "ids", 1);
        candData.jdid=jdData.jobId;
        jdData.jobId=candData.jdid;
        excelOperations.JdIdStoring("./ScriptsDocs/JDdata .xlsx", "ids",jdData.jobId);
        viewJdPO=jobsPO.goToViewJdPage(candData.jdid);
        Thread.sleep(5000);
        driver.navigate().refresh();
        viewJdPO.addSkills(jdData);
        Thread.sleep(5000);
        addCandidatePO=viewJdPO.goToAddCandidatePO();
        Thread.sleep(5000);
        candData.candid=addCandidatePO.addCandidate(candData);
        excelOperations.canIdStore("./ScriptsDocs/JDdata .xlsx",candData.candid,canNo);
        excelOperations.candIdStoring("./ScriptsDocs/JDdata .xlsx","ids",jdData.jobId,candData.candid);
        Thread.sleep(10000);
        viewJdPO=addCandidatePO.goToViewjd();
        Thread.sleep(5000);
        reviewCandidatePO=viewJdPO.goToReviewCandidate(candData.candid);
        Thread.sleep(5000);
        viewJdPO=reviewCandidatePO.Shortlist(candData);
        Thread.sleep(5000);
        schedulePO=viewJdPO.goToBookSlot(candData.candid);
        Thread.sleep(5000);
        viewJdPO=schedulePO.Schedule();
        Thread.sleep(10000);
        List<Object> links = viewJdPO.InterviewLinks(candData.candid);
        Thread.sleep(5000);
        String Hire = driver.getWindowHandle();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--use-fake-ui-for-media-stream=1");
        WebDriver driver1=new ChromeDriver(options);
        driver1.get(links.get(0).toString());
        Thread.sleep(5000);
        panelistInterviewPO=new InterviewPO(driver1);
        panelistInterviewPO.PanelistJoining();
        Thread.sleep(5000);
        String panalistTab = driver1.getWindowHandle();

        baseUtils.OpeningNewTab(driver1,links.get(1).toString());
        Set<String> handles = driver1.getWindowHandles();
        for(String handle:handles){
            if(!handle.equalsIgnoreCase(panalistTab)){
                driver1.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(5000);
        candidateInterviewPO= new InterviewPO(driver1);
        candidateInterviewPO.CandidateJoining();
        Thread.sleep(5000);
        String candidateTab = driver1.getWindowHandle();
        baseUtils.OpeningNewTab(driver1,links.get(2).toString());
        handles =  driver1.getWindowHandles();
        for(String handle:handles){
            if(!handle.equalsIgnoreCase(panalistTab)&&!handle.equalsIgnoreCase(candidateTab)){
                driver1.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(5000);
        recruiterInterviewPO= new InterviewPO(driver1);
        recruiterInterviewPO.RecruiterJoining();
        Thread.sleep(5000);
        String RecruiterTab = driver1.getWindowHandle();
        Thread.sleep(70000);
        driver1.switchTo().window(candidateTab);
        candidateInterviewPO.candidateEnd();
        Thread.sleep(5000);
        driver1.switchTo().window(RecruiterTab);
        recruiterInterviewPO.RecruiterEnd();
        Thread.sleep(5000);
        driver1.switchTo().window(panalistTab);
        panelistInterviewPO.PanelistEnd();
        Thread.sleep(5000);

        driver.quit();
    }
}