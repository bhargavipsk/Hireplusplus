package com.hirepp.sel.po;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.hirepp.utils.BaseUtils;

public class FirstPagePO{
	
	public WebDriver driver;
	BaseUtils cm = new BaseUtils(driver);

	@FindBy(how = How.XPATH, using = "//a[@href='/login']")
	public WebElement login_bt;

	
	public FirstPagePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Reporter.log("InitElements method Created the webelements of login", true);
		System.out.println("print driver"+ driver);

	}
	
	public LoginPagePO goTOLoginPage() throws InterruptedException {
		Reporter.log("inside the goTOLogin method",true);
		Thread.sleep(3000);
//		Point loginpoint = login_bt.getLocation();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy("+loginpoint+")");

		login_bt.click();
		Reporter.log("Clicked on Login in the firstpage",true);
		return new LoginPagePO(this.driver);

	}
	
	/*public LoginPagePO clickLogin(){
		Reporter.log("inside the clickLogin method",true);
		Login.click();
		Reporter.log("Clicked on Login",true);
		return new LoginPagePO(this.driver);
		

	}*/

}
