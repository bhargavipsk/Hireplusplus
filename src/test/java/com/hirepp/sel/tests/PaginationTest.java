package com.hirepp.sel.tests;

import com.hirepp.sel.po.*;
import com.hirepp.utils.ExcelOperations;
import com.hirepp.utils.TestBaseSetup;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class PaginationTest extends TestBaseSetup {

    String email = "kongarir@bridgentech.com";
    String password = "recruiter";
    LoginPagePO login_po;

    DashboardPagePO dashboardPagePO;
    SideBarPO sideBarPO;
    JobsPO jobsPO;
    ViewJdPO viewJdPO;

    ExcelOperations excelOperations = new ExcelOperations();


    @Test
    public void openingCand() throws Exception{
        FirstPagePO firstPagePO = new FirstPagePO(driver);
        Thread.sleep(5000);
        login_po = firstPagePO.goTOLoginPage();
        Thread.sleep(5000);
        login_po.Login_HirePP(email, password);
//        String jobid = excelOperations.getJobId("./ScriptsDocs/JDdata.xlsx", "ids", 1);
        String jobid="JD_S11668166116";
        Thread.sleep(5000);
        sideBarPO = new SideBarPO(driver);
        Thread.sleep(5000);
        jobsPO = sideBarPO.goTOJobsPage();
        Thread.sleep(5000);
        viewJdPO=jobsPO.goToViewJdPage(jobid);
        Thread.sleep(5000);
//        viewJdPO.goToReviewCandidate("CA_1666955647");

    }

    @Test
    public void storingJdId() throws Exception {
        FirstPagePO firstPagePO = new FirstPagePO(driver);
        Thread.sleep(5000);
        login_po = firstPagePO.goTOLoginPage();
        Thread.sleep(5000);
        login_po.Login_HirePP(email, password);
        Thread.sleep(5000);
        sideBarPO = new SideBarPO(driver);
        Thread.sleep(5000);
        jobsPO = sideBarPO.goTOJobsPage();
        Thread.sleep(5000);
        List<String> ids = jobsPO.getJobIds();
        for (String s:ids) {
            excelOperations.JdIdStoring("./ScriptsDocs/JDdata.xlsx", "ids",s);
        }

    }

    @Test
    public void storingCandId() throws Exception {
        FirstPagePO firstPagePO = new FirstPagePO(driver);
        Thread.sleep(5000);
        login_po = firstPagePO.goTOLoginPage();
        Thread.sleep(5000);
        login_po.Login_HirePP(email, password);
        Thread.sleep(5000);
        List<String> jdids = excelOperations.getJdIds("./ScriptsDocs/JDdata .xlsx", "ids");
        for (String jd:jdids) {
            driver.get("https://platform.dev.hireplusplus.com/viewJd/"+jd);
            Thread.sleep(5000);
            viewJdPO=new ViewJdPO(this.driver);
            List<String> candids = viewJdPO.getCandId();
            if(candids.size()>0){
                System.out.println("storing");
            for (String cd:candids) {
                excelOperations.candIdStoring("./ScriptsDocs/JDdata .xlsx", "ids",jd,cd);
            }}

        }

    }

}
