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
        FirstPagePO firstPagePO = new FirstPagePO(driver);
        login_po = firstPagePO.goTOLoginPage();
        login_po.Login_HirePP(email, password);
        sideBarPO=new SideBarPO(driver);
        jobsPO=sideBarPO.goTOJobsPage();
        basicClientInformationPO=jobsPO.goTOAddJDPage();
        generalDetailsPO=basicClientInformationPO.goToGeneralDetailsPage(jdData);
        chooseAnOptionPO=generalDetailsPO.goToChooseOptionPage(jdData);
        jobsPO=chooseAnOptionPO.goToUpload(jdData.exePath);
        jdData.jobId= jobsPO.getJobid();
        candData.jdid=jdData.jobId;
        jdData.jobId=candData.jdid;
        excelOperations.JdIdStoring("./ScriptsDocs/JDdata .xlsx", "ids",jdData.jobId);
        viewJdPO=jobsPO.goToViewJdPage(candData.jdid);
        driver.navigate().refresh();
        viewJdPO.addSkills(jdData);
        addCandidatePO=viewJdPO.goToAddCandidatePO();
        candData.candid=addCandidatePO.addCandidate(candData);
        excelOperations.canIdStore("./ScriptsDocs/JDdata .xlsx",candData.candid,canNo);
        excelOperations.candIdStoring("./ScriptsDocs/JDdata .xlsx","ids",jdData.jobId,candData.candid);
        viewJdPO=addCandidatePO.goToViewjd();
        reviewCandidatePO=viewJdPO.goToReviewCandidate(candData.candid);
        viewJdPO=reviewCandidatePO.Shortlist(candData);
        schedulePO=viewJdPO.goToBookSlot(candData.candid);
        viewJdPO=schedulePO.Schedule();
        List<String> links = viewJdPO.InterviewLinks(candData.candid);
        System.out.println(links.size());
        String Hire = driver.getWindowHandle();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--use-fake-ui-for-media-stream=1");
        WebDriver driver1=new ChromeDriver(options);
        driver1.manage().window().maximize();
        driver1.get(links.get(0));
        panelistInterviewPO=new InterviewPO(driver1);
        panelistInterviewPO.PanelistJoining();
        String panalistTab = driver1.getWindowHandle();
        baseUtils.OpeningNewTab(driver1,links.get(1));
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
        baseUtils.OpeningNewTab(driver1,links.get(2));
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
