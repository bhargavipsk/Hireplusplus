package com.hirepp.sel.tests;

import com.hirepp.sel.po.*;
import com.hirepp.utils.AddJD;
import com.hirepp.utils.ExcelOperations;
import com.hirepp.utils.TestBaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddJdTests extends TestBaseSetup {

	/*
	 * String email="kongarir@bridgentech.com"; String password="recruiter";
	 * LoginPagePO login_po;
	 */
	String jobId;
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

	@Test
	public String addJdUploadTest(WebDriver driver) throws Exception {
		/*
		 * Reporter.log("Inside Add Jd test",true); FirstPagePO firstPagePO=new
		 * FirstPagePO(driver); Thread.sleep(5000);
		 * login_po=firstPagePO.goTOLoginPage(); Thread.sleep(5000);
		 * dashboardPagePO=login_po.Login_HirePP(email,password); Thread.sleep(5000);
		 */
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
		jobId = chooseAnOptionPO.ChooseOptionTitle.getText();
		chooseAnOptionPO.goToUpload();
		Thread.sleep(5000);
		return jobId;

	}

	@Test
	public String addJdManualFillFormTest(WebDriver driver) throws Exception {
		Reporter.log("Inside Add Jd test", true);
		AddJD data = excelOperations.jdInputsExcel("./ScriptsDocs/JDdata.xlsx", "JD", 1);
		/*
		 * FirstPagePO firstPagePO=new FirstPagePO(driver); Thread.sleep(5000);
		 * login_po=firstPagePO.goTOLoginPage(); Thread.sleep(5000);
		 * dashboardPagePO=login_po.Login_HirePP(email,password); Thread.sleep(5000);
		 * sideBarPO=new SideBarPO(driver); Thread.sleep(5000);
		 */jobsPO = sideBarPO.goTOJobsPage();
		Thread.sleep(5000);
		basicClientInformationPO = jobsPO.goTOAddJDPage();
		Thread.sleep(5000);
		Thread.sleep(5000);
		generalDetailsPO = basicClientInformationPO.goToGeneralDetailsPage(data);
		Thread.sleep(5000);
		chooseAnOptionPO = generalDetailsPO.goToChooseOptionPage(data);
		Thread.sleep(5000);
		jobId = chooseAnOptionPO.ChooseOptionTitle.getText();
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
		return jobId;

	}
}
