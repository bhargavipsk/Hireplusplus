package com.hirepp.sel.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hirepp.sel.po.DashboardPagePO;
import com.hirepp.sel.po.FirstPagePO;
import com.hirepp.sel.po.LoginPagePO;

public class LoginTests extends com.hirepp.utils.TestBaseSetup {

	// public WebDriver driver;
	LoginPagePO login_PO;
//	String expected_DB_url_recruiter = "https://platform.dev.hireplusplus.com/recruiterDash";
	
	@Test
	public void Recruiter_loginTest() throws InterruptedException {
		Reporter.log("Inside Login test",true);
		FirstPagePO firstPageObj = new FirstPagePO(driver);
		login_PO = firstPageObj.goTOLoginPage();
		DashboardPagePO dbp =login_PO.Login_HirePP("tester.hireplus05@gmail.com", "Hire@2022");
		if(dbp!=null) {
			Reporter.log("Dashboard page is displayed" , true);
		}
		else {
			Reporter.log("Dashboard page is not displayed",true);
		}
		
	}

}
