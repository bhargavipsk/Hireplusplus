package com.hirepp.sel.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hirepp.sel.po.FirstPagePO;
import com.hirepp.sel.po.LoginPagePO;
import com.hirepp.sel.po.RegistrationPagePO;
import com.hirepp.utils.BaseUtils;

/**
 * This class contains all the TestNG tests on Registrationpage
 *
 * @author Bhargavi created on 16/09/2022
 */

public class RegistrationTests extends com.hirepp.utils.TestBaseSetup {

	LoginPagePO loginPageObj;
	RegistrationPagePO reg;
	FirstPagePO firstPageObj;
	BaseUtils bu;
	String expected_text = "already registered";
	
	@Test
	public void registrationTest() throws InterruptedException {
		boolean flag = false;
		BaseUtils bu = new BaseUtils(driver);

		Reporter.log("Inside registration test", true);
		FirstPagePO firstPageObj = new FirstPagePO(driver);
		loginPageObj = firstPageObj.goTOLoginPage();
		reg = loginPageObj.fromLoginPageToRegistrationPage();
		Reporter.log("generating temp pwd",true);
		String tempEmail = bu.temppwdgenerator();
		
		flag = reg.registration("test", "emailID", "034300024", tempEmail, "Hash@2020",
				"Hash@2020", "Recruiter");
		if(flag) {
			Reporter.log("registration is successful",true);
		}
		else Reporter.log("Registraton failed , register with another emailid",true);
	}
	
}
