package com.hirepp.sel.tests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hirepp.sel.po.FirstPagePO;
import com.hirepp.sel.po.LoginPagePO;
import com.hirepp.sel.po.RegistrationPagePO;
import com.hirepp.utils.BaseUtils;
import com.hirepp.utils.config;

/**
 * This class contains all the TestNG tests on Registrationpage
 *
 * @author Bhargavi created on 16/09/2022
 */

public class RegistrationTests extends com.hirepp.utils.TestBaseSetup {

	LoginPagePO loginPageObj;
	RegistrationPagePO reg;
	FirstPagePO firstPageObj;
//	String expected_text = "already registered";
	config getProp = new config();

	@Test
	public void registrationTest() throws InterruptedException, IOException {
		boolean flag = false;
		FirstPagePO firstPageObj = new FirstPagePO(driver);
		loginPageObj = firstPageObj.goTOLoginPage();
		reg = loginPageObj.fromLoginPageToRegistrationPage();
		getProp.loadConfigFile();
		String password = getProp.getPropertyVal("password");
		String tempEmail = reg.createTempEmail1();
		reg.registrationWithTmpEmail("FN:"+tempEmail, "LN:"+tempEmail, "034300024", tempEmail + "@mail7.io", password, password,
				"Recruiter");
		reg.RegistrationActivation();
		loginPageObj = new LoginPagePO(driver);
		loginPageObj.Login_HirePP(tempEmail + "@mail7.io", password);

	}

}
