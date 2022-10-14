package com.hirepp.sel.tests;

import java.io.IOException;

import com.hirepp.sel.po.*;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hirepp.utils.AddCandidate;
import com.hirepp.utils.ExcelOperations;

public class AddCandidateTest extends com.hirepp.utils.TestBaseSetup {

	String email = "kongarir@bridgentech.com";
	String password = "recruiter";
	LoginPagePO login_po;

	DashboardPagePO dashboardPagePO;
	SideBarPO sideBarPO;
	JobsPO jobsPO;
	BasicClientInformationPO basicClientInformationPO;
	GeneralDetailsPO generalDetailsPO;
	ChooseAnOptionPO chooseAnOptionPO;
	RequirementsAndPerksPO requirementsAndPerksPO;
	ExperienceAndSkillsPO experienceAndSkillsPO;
	AddMoreDetailsPO addMoreDetailsPO;
	ReviewJdPO reviewJdPO;
	AddCandidatePO addcandidatepo;
	ViewJdPO viewJdPO;
	ExcelOperations excelOperations = new ExcelOperations();
	AddJdTests addJdTests=new AddJdTests();
	BaseUtils baseUtils=new BaseUtils(driver);

	@Test
	public ViewJdPO addingCandidate(WebDriver driver) throws Exception {

//		Reporter.log("Inside Add Jd test", true);
//		FirstPagePO firstPagePO = new FirstPagePO(driver);
//		Thread.sleep(5000);
//		login_po = firstPagePO.goTOLoginPage();
//		Thread.sleep(5000);
//		dashboardPagePO = login_po.Login_HirePP(email, password);
//		Thread.sleep(5000);
		jobsPO=addJdTests.addJdUploadTest(driver);

		Thread.sleep(5000);
		viewJdPO=jobsPO.goToViewJdPage();
		Thread.sleep(5000);
		addcandidatepo=viewJdPO.goToAddCandidatePO();
//		String[] jobid = baseUtils.stringSplitBySpace(job);
//		driver.get("https://platform.hireplusplus.com/viewJd/"+jobid[jobid.length-1]);
		Reporter.log("Reading the excel", true);
		AddCandidate data = excelOperations.candidateExcelRead("./ScriptsDocs/JDdata.xlsx", "Candidate", 1);
		Reporter.log("Creating object of AddCandidatePO",true);
//		addcandidatepo  = new AddCandidatePO(driver);
		Reporter.log("calling the addCandidate()", true);

		viewJdPO=addcandidatepo.addCandidate(data);
		return viewJdPO;
	}

	@Test
	public ViewJdPO addingCandidateForJd(WebDriver driver) throws Exception {

		Reporter.log("Inside Add Jd test", true);
		FirstPagePO firstPagePO = new FirstPagePO(driver);
		Thread.sleep(5000);
		login_po = firstPagePO.goTOLoginPage();
		Thread.sleep(5000);
		dashboardPagePO = login_po.Login_HirePP(email, password);
		Thread.sleep(5000);
		jobsPO=addJdTests.addJdUploadTest(driver);
		Thread.sleep(5000);
		excelOperations.getJobId()
		viewJdPO=jobsPO.goToViewJdPage();
		Thread.sleep(5000);
		addcandidatepo=viewJdPO.goToAddCandidatePO();
//		String[] jobid = baseUtils.stringSplitBySpace(job);
//		driver.get("https://platform.hireplusplus.com/viewJd/"+jobid[jobid.length-1]);
		Reporter.log("Reading the excel", true);
		AddCandidate data = excelOperations.candidateExcelRead("./ScriptsDocs/JDdata.xlsx", "Candidate", 1);
		Reporter.log("Creating object of AddCandidatePO",true);
//		addcandidatepo  = new AddCandidatePO(driver);
		Reporter.log("calling the addCandidate()", true);

		viewJdPO=addcandidatepo.addCandidate(data);
		return viewJdPO;
	}

}
