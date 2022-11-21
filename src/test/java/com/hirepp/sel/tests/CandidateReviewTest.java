package com.hirepp.sel.tests;

import com.hirepp.sel.po.DashboardPagePO;
import com.hirepp.sel.po.FirstPagePO;
import com.hirepp.sel.po.LoginPagePO;
import com.hirepp.sel.po.ReviewCandidatePO;
import com.hirepp.utils.TestBaseSetup;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CandidateReviewTest extends TestBaseSetup {
    String email="kongarir@bridgentech.com"; String password="recruiter";
    LoginPagePO login_po;
    DashboardPagePO dashboardPagePO;
    ReviewCandidatePO reviewCandidatePO;

    @Test
    public void ReviewCandidate() throws Exception{

        Reporter.log("Inside Add Jd test",true);
        FirstPagePO firstPagePO=new FirstPagePO(driver);
        Thread.sleep(5000);
        login_po=firstPagePO.goTOLoginPage();
        Thread.sleep(5000);
        dashboardPagePO=login_po.Login_HirePP(email,password);
        Thread.sleep(5000);

//        reviewCandidatePO.Shortlist();
    }
}
