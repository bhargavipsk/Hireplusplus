package com.hirepp.sel.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DashboardPagePO {

	public WebDriver driver;




	public DashboardPagePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Reporter.log("InitElements method Created the webelements of login", true);
		System.out.println("print driver" + driver);

	}
	
	

}
