package com.hirepp.sel.tests;

import com.hirepp.sel.po.*;
import com.hirepp.utils.AddJD;
import com.hirepp.utils.ExcelOperations;
import com.hirepp.utils.TestBaseSetup;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddJdTests extends TestBaseSetup {

    String email="kongarir@bridgentech.com";
    String password="recruiter";
    LoginPagePO login_po;
    DashboardPagePO dashboardPagePO;
    SideBarPO sideBarPO;
    JobsPO jobsPO;
    BasicClientInformationPO basicClientInformationPO;
    GeneralDetailsPO generalDetailsPO;
    ChooseAnOption chooseAnOption;

    ExcelOperations excelOperations=new ExcelOperations();

    @Test
    public void addJdTest() throws Exception {
        Reporter.log("Inside Add Jd test",true);
        FirstPagePO firstPagePO=new FirstPagePO(driver);
        Thread.sleep(5000);
        login_po=firstPagePO.goTOLoginPage();
        Thread.sleep(5000);
        dashboardPagePO=login_po.Login_HirePP(email,password);
        Thread.sleep(5000);
        sideBarPO=new SideBarPO(driver);
        Thread.sleep(5000);
        jobsPO=sideBarPO.goTOJobsPage();
        Thread.sleep(5000);
        basicClientInformationPO=jobsPO.goTOAddJDPage();
        Thread.sleep(5000);
        AddJD data = excelOperations.jdInputsExcel("./ScriptsDocs/JDdata.xlsx", 0);
        Thread.sleep(5000);
        generalDetailsPO=basicClientInformationPO.goToGeneralDetailsPage(data);
        Thread.sleep(5000);
        chooseAnOption=generalDetailsPO.goToChooseOptionPage(data);
        Thread.sleep(5000);
        chooseAnOption.goToUpload();
        Thread.sleep(5000);



    }

}
