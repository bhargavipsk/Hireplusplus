package com.hirepp.sel.tests;

import java.io.IOException;

import com.hirepp.utils.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hirepp.sel.po.AddMoreDetailsPO;
import com.hirepp.sel.po.BasicClientInformationPO;
import com.hirepp.sel.po.ChooseAnOptionPO;
import com.hirepp.sel.po.DashboardPagePO;
import com.hirepp.sel.po.ExperienceAndSkillsPO;
import com.hirepp.sel.po.FirstPagePO;
import com.hirepp.sel.po.GeneralDetailsPO;
import com.hirepp.sel.po.JobsPO;
import com.hirepp.sel.po.LoginPagePO;
import com.hirepp.sel.po.RegistrationPagePO;
import com.hirepp.sel.po.RequirementsAndPerksPO;
import com.hirepp.sel.po.ReviewJdPO;
import com.hirepp.sel.po.SideBarPO;

/**
 * This class contains all the TestNG tests on Registrationpage
 *
 * @author Bhargavi created on 16/09/2022
 */

public class RegistrationTests extends TestBaseSetup {

	LoginPagePO loginPageObj;
	RegistrationPagePO reg;
	FirstPagePO firstPageObj;
//	String expected_text = "already registered";

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

	ExcelOperations excelOperations = new ExcelOperations();
	BaseUtils baseUtils=new BaseUtils(driver);

	@Test(priority = 0)
	public void registrationTest() throws InterruptedException, IOException {
		boolean flag = false;
		FirstPagePO firstPageObj = new FirstPagePO(driver);
		loginPageObj = firstPageObj.goTOLoginPage();
		reg = loginPageObj.fromLoginPageToRegistrationPage();

		String password = baseUtils.readPropValues("password");
		String tempEmail = reg.createTempEmail1();
		reg.registrationWithTmpEmail("FN:" + tempEmail, "LN:" + tempEmail, "034300024", tempEmail + "@mail7.io",
				password, password, "Recruiter");
		reg.RegistrationActivation();
		loginPageObj = new LoginPagePO(driver);
		loginPageObj.Login_HirePP(tempEmail + "@mail7.io", password);

	}

//	@Test(priority = 1)
	public void addJdUploadTest() throws Exception {

		Reporter.log("Inside Add Jd test", true);
		sideBarPO = new SideBarPO(driver);
		Thread.sleep(5000);
		jobsPO = sideBarPO.goTOJobsPage();
		Thread.sleep(5000);
		basicClientInformationPO = jobsPO.goTOAddJDPage();
		AddJD data = excelOperations.jdInputsExcel("./ScriptsDocs/JDdata.xlsx", "JD", 1);
		Thread.sleep(5000);
		generalDetailsPO = basicClientInformationPO.goToGeneralDetailsPage(data);
		Thread.sleep(5000);
		chooseAnOptionPO = generalDetailsPO.goToChooseOptionPage(data);
		Thread.sleep(5000);
		chooseAnOptionPO.goToUpload(data.exePath);
		Thread.sleep(5000);

		// need to retrieve the JobID
	}

	@Test(priority = 2)
	public void addJdManualFillFormTest() throws Exception {
		Reporter.log("Inside Add Jd test", true);
		AddJD data = excelOperations.jdInputsExcel("./ScriptsDocs/JDdata.xlsx", "JD", 1);
		sideBarPO = new SideBarPO(driver);
		Thread.sleep(5000);
		jobsPO = sideBarPO.goTOJobsPage();
		Thread.sleep(5000);
		basicClientInformationPO = jobsPO.goTOAddJDPage();
		Thread.sleep(5000);
		Thread.sleep(5000);
		generalDetailsPO = basicClientInformationPO.goToGeneralDetailsPage(data);
		Thread.sleep(5000);
		chooseAnOptionPO = generalDetailsPO.goToChooseOptionPage(data);
		Thread.sleep(5000);
		requirementsAndPerksPO = chooseAnOptionPO.goToManualFillForm();
		Thread.sleep(5000);
		data = excelOperations.JdFillForm("./ScriptsDocs/JDdata.xlsx", "JD", 1);
		experienceAndSkillsPO = requirementsAndPerksPO.goToExperience(data);
		Thread.sleep(5000);
		addMoreDetailsPO = experienceAndSkillsPO.goToMoreDetails(data);
		Thread.sleep(5000);
		reviewJdPO = addMoreDetailsPO.goToReviewJD(data);
		Thread.sleep(5000);
		jobsPO = reviewJdPO.goToJob();

		// need to retrieve jobID after successful creation

	}

}
