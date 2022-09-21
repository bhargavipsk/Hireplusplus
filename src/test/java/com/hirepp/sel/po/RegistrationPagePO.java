package com.hirepp.sel.po;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.hirepp.utils.BaseUtils;

/**
 * This class contains all PageObjects and Methods of RegistrationPage
 *
 * @author Bhargavi created on 16/09/2022
 */
public class RegistrationPagePO {

	public WebDriver driver;
	BaseUtils cm = new BaseUtils(driver);
	String userType = "//div[@class='rc-virtual-list-holder-inner']/div[contains(@class,'ant-select-item')]";

	@FindBy(how = How.XPATH, using = "//div[text()='Register']")
	public WebElement RegisterTitle;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your First Name']")
	public WebElement firstName;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your Last Name']")
	public WebElement lastName;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your Phone Number']")
	public WebElement phoneNumber;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your email']")
	public WebElement email;
	@FindBy(how = How.XPATH, using = "//div[text()='Password']/following-sibling::span/input")
	public WebElement password;
	@FindBy(how = How.XPATH, using = "//div[text()='Confirm Password']/following-sibling::span/input")
	public WebElement confirm_password;
	@FindBy(how = How.XPATH, using = "//div[@class='rc-virtual-list-holder-inner']/div[contains(@class,'ant-select-item')]")
	public List<WebElement> user_Type;
	@FindBy(how = How.XPATH, using = "//div[@class='ant-select-selector']")
	public WebElement user_TypeDropdown;
	@FindBy(how = How.XPATH, using = "//button[text()='Create account']")
	public WebElement createAccount;
	@FindBy(how = How.XPATH, using = "//div[@class='form-body-wrapper']/following-sibling::div[contains(text(),'already')]")
	public WebElement account_alreadyExists;
	@FindBy(how = How.XPATH, using= "//div[@class='ant-notification ant-notification-topRight']") 
	public WebElement notification;
	
	
	/**
	 * 
	 * 
	 * selects the type from the UserType dropdown
	 * 
	 * @author Bhargavi
	 * @param usertype, type to be selected
	 * @return no return value
	 * @throws InterruptedException 
	 * 
	 */
	public void selectUserType(String usertype) throws InterruptedException {
		Reporter.log("Inside the getusertypes method,clicking on dropdown", true);
		user_TypeDropdown.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on dropdown", true);
		Reporter.log("number of elements in userType" + user_Type.size(), true);
		for (WebElement i : user_Type) {
			if (i.getAttribute("title").equalsIgnoreCase(usertype)) {
			//	user_TypeDropdown.click();
				i.click();
				Thread.sleep(2000);
				break;
			} 			
		}
	}
	
	
	public boolean alreadyExists() {
		boolean flag =false;
	try {
		if (account_alreadyExists.isDisplayed()) {
			Reporter.log("User is already registed", true);
			flag = false;
		}
		else {
			Reporter.log("registration is successful", true);
			flag = true;		
			}
	}catch(NoSuchElementException e) {

	}
	return flag;

}
	/**
	 * verifies Registration page title
	 * 
	 * @author Bhargavi
	 * @return returns true/false
	 *
	 */
	public boolean registerPageDisplay() {
		if (cm.isTextPresent("Register", RegisterTitle)) {
			Reporter.log("User is in registration page ...Start registering", true);
			return true;
		}

		else {
			Reporter.log("Registration page is not displayed", true);
			return false;
		}
	}

	/**
	 * Performs data entry into all elements in registration page performs
	 * Registration
	 * 
	 * @author Bhargavi
	 * @param first_Name
	 * @param Last_Name
	 * @param phone_num
	 * @param Email
	 * @param pwd
	 * @param confirm_pwd
	 * @param userType
	 * @throws InterruptedException --- need to implement explicit waits
	 */

	public boolean registration(String first_Name, String Last_Name, String phone_num, String Email, String pwd,
			String confirm_pwd, String userType) throws InterruptedException {

		cm.enterData(firstName, first_Name);
		cm.enterData(lastName, Last_Name);
		cm.enterData(phoneNumber, phone_num);
		cm.enterData(email, Email);
		cm.enterData(password, pwd);
		cm.enterData(confirm_password, confirm_pwd);
		Thread.sleep(2000);
		selectUserType(userType);
		createAccount.click();
		Thread.sleep(2000);
		
		return alreadyExists();
		/*try {
			account_alreadyExists.isDisplayed();
			String verifyText = account_alreadyExists.getText();
			Reporter.log("verifyText captured is"+verifyText,true);
			Reporter.log("User is already Registered. Use another emailID for registering", true);
		}catch (NoSuchElementException e) {
			throw new RuntimeException("This is where you put the message");
			}*/
//		if (verifyText.contains(expected_text)) {
//			Reporter.log("User is already Registered. Use another emailID for registering", true);
//
//		} else if (!verifyText.contains(expected_text)) {
//			Reporter.log("User is Registered. check your registered email account and activate", true);
//
//		}		
//		*/
	}

	
	
	// generate temp pwd

	/**
	 * @author Bhargavi
	 * @param driver
	 */
	public RegistrationPagePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Reporter.log("InitElements method Created the webelements", true);

	}
	
	

}
