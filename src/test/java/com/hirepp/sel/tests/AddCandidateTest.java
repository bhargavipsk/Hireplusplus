package com.hirepp.sel.tests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hirepp.sel.po.AddCandidatePO;
import com.hirepp.sel.po.AddMoreDetailsPO;
import com.hirepp.sel.po.BasicClientInformationPO;
import com.hirepp.sel.po.ChooseAnOptionPO;
import com.hirepp.sel.po.DashboardPagePO;
import com.hirepp.sel.po.ExperienceAndSkillsPO;
import com.hirepp.sel.po.FirstPagePO;
import com.hirepp.sel.po.GeneralDetailsPO;
import com.hirepp.sel.po.JobsPO;
import com.hirepp.sel.po.LoginPagePO;
import com.hirepp.sel.po.RequirementsAndPerksPO;
import com.hirepp.sel.po.ReviewJdPO;
import com.hirepp.sel.po.SideBarPO;
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
	ExcelOperations excelOperations = new ExcelOperations();

	@Test
	public void addingCandidate() throws IOException, InterruptedException {

		Reporter.log("Inside Add Jd test", true);
		FirstPagePO firstPagePO = new FirstPagePO(driver);
		Thread.sleep(5000);
		login_po = firstPagePO.goTOLoginPage();
		Thread.sleep(5000);
		dashboardPagePO = login_po.Login_HirePP(email, password);
		Thread.sleep(5000);
		driver.get("https://platform.dev.hireplusplus.com/viewJd/JD_IN1665046302");
		Reporter.log("Reading the excel", true);
		AddCandidate data = excelOperations.candidateExcelRead("./ScriptsDocs/JDdata.xlsx", "Candidate", 1);
		Reporter.log("Creating object of AddCandidatePO",true);
		addcandidatepo  = new AddCandidatePO(driver);
		Reporter.log("calling the addCandidate()", true);

		addcandidatepo.addCandidate(data);
	}

}
