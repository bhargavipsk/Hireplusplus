package com.hirepp.sel.tests;

import com.hirepp.sel.po.DashboardPagePO;
import com.hirepp.sel.po.FirstPagePO;
import com.hirepp.sel.po.LoginPagePO;
import com.hirepp.sel.po.ViewJdPO;
import com.hirepp.utils.AddJD;
import com.hirepp.utils.ExcelOperations;
import com.hirepp.utils.TestBaseSetup;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddSkillsTest extends TestBaseSetup {
    String email = "kongarir@bridgentech.com";
    String password = "recruiter";

    ViewJdPO viewJdPO;
    LoginPagePO login_po;
    DashboardPagePO dashboardPagePO;

    ExcelOperations excelOperations=new ExcelOperations();
    AddCandidateTest addCandidateTest=new AddCandidateTest();

    @Test
    public void addSkill() throws Exception {
        AddJD data = excelOperations.jdInputsExcel("./ScriptsDocs/JDdata.xlsx", "JD", 1);
        Thread.sleep(5000);
        FirstPagePO firstPagePO = new FirstPagePO(driver);
		Thread.sleep(5000);
		login_po = firstPagePO.goTOLoginPage();
		Thread.sleep(5000);
		login_po.Login_HirePP(email, password);
		Thread.sleep(5000);
        addCandidateTest.addingCandidate(driver);
        Thread.sleep(5000);
        viewJdPO=new ViewJdPO(driver);
        viewJdPO.addSkills(data);
    }
}
