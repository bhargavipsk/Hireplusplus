package com.hirepp.sel.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.hirepp.utils.BaseUtils;

/**
 * Recruiter LoginPagePO contains all PageObjects and operations performed on LoginPage
 * This class will be modified in the future and not baselined
 * 
 * @author Bhargavi created on 16/09/2022
 */

public class LoginPagePO {

	public WebDriver driver;
	FirstPagePO fp = new FirstPagePO(driver);
	BaseUtils bu = new BaseUtils(driver);

	@FindBy(how = How.XPATH, using = "//span[text()='Sign Up']")
	public WebElement signUp;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter email Id']")
	public WebElement emailId;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your password']")
	public WebElement password;
	@FindBy(how = How.XPATH, using = "//button[text()='Login']")
	public WebElement Login_btn;

	public void clickSignup() {
		signUp.click();
	}

	/**
	 * The Constructor contains PageFactory - InitElements method to initialize web
	 * Elements of Login page
	 * 
	 * @param driver WebDriver object
	 */

	public LoginPagePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Reporter.log("InitElements method Created the webelements of login", true);

	}

	public DashboardPagePO Login_HirePP(String email_Id, String pwd) throws InterruptedException {
		Reporter.log("Inside Login_HirePP method", true);
		Thread.sleep(2000);
		if (bu.isElementPresent(emailId)) {
			Reporter.log("Entering the EmailID", true);
			bu.enterData(emailId, email_Id);
		} else
			Reporter.log(emailId + "not present", true);
		if (bu.isElementPresent(password)) {
			Reporter.log("Entering the password", true);
			bu.enterData(password, pwd);
		} else
			Reporter.log(password + "not present", true);
		if (bu.isElementPresent(Login_btn)) {
			Reporter.log("Clicking the Login button", true);
			Login_btn.click();
		} else
			Reporter.log(Login_btn + "not present", true);
	
		return new DashboardPagePO(this.driver);

	}

	
	
	public RegistrationPagePO fromLoginPageToRegistrationPage() throws InterruptedException {
		Reporter.log("Inside fromLoginPageToRegistrationPage", true);
		// Need to remove sleep and implement page load wait here
		Thread.sleep(2000);
		clickSignup();
		return new RegistrationPagePO(this.driver);

	}
}
