package com.hirepp.sel.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hirepp.sel.po.FirstPagePO;
import com.hirepp.sel.po.LoginPagePO;
import com.hirepp.sel.po.RegistrationPagePO;

/**
 * This class contains all the TestNG tests on Registrationpage
 *
 * @author Bhargavi created on 16/09/2022
 */

public class RegistrationTests extends com.hirepp.utils.TestBaseSetup {

	LoginPagePO lg;
	RegistrationPagePO reg;
	FirstPagePO fp;

	@Test
	public void registrationTest() throws InterruptedException {
		
		Reporter.log("Inside registration test", true);
		Reporter.log("going to call before method and get the firstpageobject", true);
		FirstPagePO fp = new FirstPagePO(driver);
		System.out.println(fp);
		System.out.println("printing driver insdie registrationtest" + driver);
		Thread.sleep(3000);
		lg = fp.goTOLoginPage();
		reg = lg.fromLoginPageToRegistrationPage();
		
		reg.registration("Bhargavi", "psk", "0343433434", "bhargavipsk@gmail.com", "Hash@2020", "Hash@2020",
				"recruiter");
	}

}
