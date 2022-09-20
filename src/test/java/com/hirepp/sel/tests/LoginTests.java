package com.hirepp.sel.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hirepp.sel.po.FirstPagePO;
import com.hirepp.sel.po.LoginPagePO;
import com.hirepp.utils.BaseUtils;

public class LoginTests extends com.hirepp.utils.TestBaseSetup {

	// public WebDriver driver;
	BaseUtils cm = new BaseUtils(driver);
	LoginPagePO lg;

//	@Test
	public void LoginTest() throws InterruptedException {
		FirstPagePO fp = new FirstPagePO(driver);
		System.out.println("print driver" + driver);
		lg = fp.goTOLoginPage();
		Reporter.log("Inside Login test");
		lg.Login_HirePP("tester.hireplus05@gmail.com", "Hire@2022");

	}

}
