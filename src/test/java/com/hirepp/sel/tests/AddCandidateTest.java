package com.hirepp.sel.tests;

import com.hirepp.sel.po.*;
import com.hirepp.utils.BaseUtils;
import com.hirepp.utils.TestBaseSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hirepp.utils.AddCandidate;
import com.hirepp.utils.ExcelOperations;

public class AddCandidateTest extends TestBaseSetup {

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
	FirstPagePO firstPagePO;


//	@Test
	public ViewJdPO addingCandidate(WebDriver driver) throws Exception {

//		FirstPagePO firstPagePO = new FirstPagePO(driver);
//		login_po = firstPagePO.goTOLoginPage();
//		Thread.sleep(5000);
//		dashboardPagePO = login_po.Login_HirePP(email, password);
//		Thread.sleep(5000);
		jobsPO=addJdTests.addJdUploadTest(driver);

		Thread.sleep(5000);
		viewJdPO=jobsPO.goToViewJdPage();
		Thread.sleep(5000);
		addcandidatepo=viewJdPO.goToAddCandidatePO();
		Reporter.log("Reading the excel", true);
		AddCandidate data = excelOperations.candidateExcelRead("./ScriptsDocs/JDdata.xlsx", "Candidate", 1);
		Reporter.log("Creating object of AddCandidatePO",true);
		Reporter.log("calling the addCandidate()", true);

		viewJdPO=addcandidatepo.addCandidate(data);
		return viewJdPO;
	}

	@Test
	public void addingCandidateForJd() throws Exception {

		FirstPagePO firstPagePO = new FirstPagePO(driver);
		Thread.sleep(5000);
		login_po = firstPagePO.goTOLoginPage();
		Thread.sleep(5000);
		login_po.Login_HirePP(email, password);
		String jobid = excelOperations.getJobId("./ScriptsDocs/JDdata.xlsx", "Jd", 1);
		Thread.sleep(5000);
		sideBarPO = new SideBarPO(driver);
		Thread.sleep(5000);
		jobsPO = sideBarPO.goTOJobsPage();
		Thread.sleep(5000);
		viewJdPO=jobsPO.goToViewJdPage(jobid);
		Thread.sleep(5000);
		addcandidatepo=viewJdPO.goToAddCandidatePO();
		Reporter.log("Reading the excel", true);
//		AddCandidate data = excelOperations.candidateExcelRead("./ScriptsDocs/JDdata.xlsx", "Candidate", 1);
//		Reporter.log("Creating object of AddCandidatePO",true);
//		Reporter.log("calling the addCandidate()", true);

//		viewJdPO=addcandidatepo.addCandidate(data);
//		return viewJdPO;
	}

}
