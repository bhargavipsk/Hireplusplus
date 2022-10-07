package com.hirepp.sel.po;

import com.hirepp.utils.config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.hirepp.utils.AddCandidate;
import com.hirepp.utils.BaseUtils;

import java.io.IOException;

public class AddCandidatePO {

	    WebDriver driver;
	    BaseUtils baseUtils =new BaseUtils(driver);
		config getProp = new config();
	    
	    @FindBy(xpath ="//button[text()='+ Add Candidates']") public WebElement addCandidate;	    
	    @FindBy(xpath="//label[text()='First Name']/following-sibling::input") public WebElement first_Name;
	    @FindBy(xpath="//label[text()='Last Name']/following-sibling::input") public WebElement last_Name;
	    @FindBy(xpath ="//label[text()='Email Id']/following-sibling::input") public WebElement email;
	    @FindBy(xpath="//input[@placeholder='Contact No.']") public WebElement contact_no;
	    @FindBy(xpath = "//label[text()='Notice Period']/following-sibling::select") public WebElement notice_period;
	    @FindBy(xpath="//label[text()='Current Company']/following-sibling::input") public WebElement current_Company;	
	    @FindBy(xpath="//input[@placeholder=Current CTC']") public WebElement current_CTC;
	    @FindBy(xpath="//input[@placeholder=Expected CTC']") public WebElement expected_CTC;
	    @FindBy(xpath = "//label[text()='Currency Type']/following-sibling::select") public WebElement currency_Type;
	    @FindBy(xpath="//input[@type='file']") public WebElement file_input;
	    @FindBy(xpath="//span[@class='ant-select-selection-search']") public WebElement country_dropdown;
		@FindBy(xpath = "//button[.='Add']") public WebElement Add_button;
		@FindBy(xpath = "//button[.='Finish']") public WebElement Finish_button;
	    
	    
	    
	    public void addCandidate(AddCandidate data) throws InterruptedException, IOException {
	    	
	        Reporter.log("Inside the addCandidate()",true);
	        Thread.sleep(3000);
	        addCandidate.click();
	        baseUtils.enterData(first_Name,data.first_Name);
	        baseUtils.enterData(last_Name,data.last_Name);
	        baseUtils.enterData(email,data.email_id);	 
	        contact_no.sendKeys(String.valueOf(data.contact_no));
	        notice_period.click();
	        Thread.sleep(3000);
	        baseUtils.select_ByValue(notice_period,String.valueOf(data.notice_period));
	        baseUtils.enterData(current_Company,data.current_Company);
	        current_CTC.sendKeys(String.valueOf(data.current_CTC));
	        expected_CTC.sendKeys(String.valueOf(data.expected_CTC));
	        baseUtils.select_ByValue(currency_Type,String.valueOf(data.currency));
			file_input.click();
			getProp.loadConfigFile();
			String browser = getProp.getPropertyVal("browser");
			if(browser.equalsIgnoreCase("chrome")){
				baseUtils.uploadDoc(".\\ScriptsDocs\\ChromeResumeUpload.exe");
			}
			if(browser.equalsIgnoreCase("firefox")) {
				baseUtils.uploadDoc(".\\ScriptsDocs\\FirefoxResumeUpload.exe");
			}
			Add_button.click();
			Thread.sleep(10000);
			Finish_button.click();
	    }
	    
	    
	    public AddCandidatePO(WebDriver driver){
	    	Reporter.log("inside the AddCandidatePO",true);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        Reporter.log("InitElements method Created the webelements in AddCanddiatePO", true);
	    }
	    
}
