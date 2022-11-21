package com.hirepp.utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * BaseUtils contains re-usable methods that can be called within the pageobject
 * classes
 *
 * @author Bhargavi created on 16/09/2022
 */

public class BaseUtils extends TestBaseSetup{

	public WebDriver driver;
	config gp = new config();


	public BaseUtils(WebDriver driver) {
		Reporter.log("Inside the BaseUtils constructor", true);
		this.driver = driver;
	}

	public BaseUtils(){

	}

	public void Select_ddElementByIndex(WebElement webElement,int i){
		Select select = new Select(webElement);
		select.selectByIndex(i);
	}

	public void OpeningNewTab(WebDriver driver, String link){
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.open('"+link+"','_blank')");
	}

	public String Selected_ddElement(WebElement webElement) {

		Select select = new Select(webElement);
		return select.getFirstSelectedOption().getText();

	}

	
	public void select_valueByVisibleText(WebElement webElement,String obj)
	{
		Select select = new Select(webElement);
		select.selectByVisibleText(obj);
		
		}

		
	public void select_valueByIndex(WebElement webElement,Object obj)
	{
		Select select = new Select(webElement);
		select.selectByIndex((int) obj);
		
		}
	
	public void select_ByValue(WebElement webElement,Object obj)
	{
		Select select = new Select(webElement);
		select.selectByValue((String) obj);
		
		}
		
	public List<WebElement> allddElements(WebElement webElement) {
		Select select = new Select(webElement);
		return select.getOptions();
	}



	/**
	 * 
	 * 
	 * @return
	 */
	public Actions getAction() {
		Actions action = new Actions(driver);
		return action;
	}

	/**
	 * Waits for a duration of time prior to throwing exception
	 * 
	 * @param pageloadDuration set time for page load
	 * @param driver           is the WebDriver object
	 * @return no return value
	 */
	public void wait_pageLoad(int pageloadDuration, WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadDuration));

	}

	public void elementVisibleWait(WebDriver driver,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

//	public void elementClickableWait(WebElement element){
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//	}

//	public void elementSelectableWait(WebElement element){
//		wait.until(ExpectedConditions.elementToBeSelected(element));
//	}

	public void pageVerification(String element,String title){
		Assert.assertEquals(element,title);
	}

	/**
	 * Verifies whether text is present or not
	 * 
	 * @author bhargavi
	 * @param string     is the Text to be verified
	 * @param webElement is the HTML webElement from which Text has to be verified
	 * @return is true/ false boolean value
	 * 
	 */

	public boolean isTextPresent(String string, WebElement webElement) {
		if (webElement.getText().equalsIgnoreCase(string))
			return true;
		else
			return false;
	}

	/**
	 * 
	 * getAttributevalue based on passed attribute
	 * 
	 * @author Bhargavi
	 * @param webElement is a HTML element
	 * @param attribute  is HTML attribute
	 * @return returns attribute value as string
	 */
	public String getAttributeVal(WebElement webElement, String attribute) {
		return webElement.getAttribute(attribute);
	}

	/**
	 * 
	 * enterData into an input element
	 * 
	 * @author Bhargavi
	 * @param webelement is the input element
	 * @param data       is the input provided to the input
	 * @return no return value
	 * 
	 */

	public void enterData(WebElement webelement, String data) {
		webelement.clear();
		webelement.click();
		webelement.sendKeys(data);

	}

	public void uploadDoc(String exePath) throws IOException {
		Runtime.getRuntime().exec(exePath);
	}

	public String[] stringSplitBySpace(String s){
		String[] split = s.split(" ");
		return split;
	}

	public String readPropValues(String property) throws IOException {

		config getProp = new config();
		getProp.loadConfigFile();
		return getProp.getPropertyVal(property);

	}




	public String dateEntering(String date,String browser){
		String[] split = date.split("-");
		String returningDate = "";
		if(browser.equalsIgnoreCase("chrome")){
			returningDate=split[2]+"-"+split[1]+"-"+split[0];
			return returningDate;
		}
		if(browser.equalsIgnoreCase("firefox")){
			returningDate=split[0]+"-"+split[1]+"-"+split[2];
			return returningDate;
		}
		return returningDate;
	}

	public boolean isElementPresent(WebElement element) {
		boolean flag = false;
		if (element != null) {
			Reporter.log(element + " is Present", true);
			flag = true;
			return flag;
		} 
		return flag;

	}
	
	/**
	 * The temppwdgenerator is used to generate temporary emailID
	 * But it's not opening the registration email.
	 * Automated clicking on the website is not allowed.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * 
	 */

	/*public String temppwdgenerator() throws InterruptedException {
		String email = " ";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Brower is maximized", true);
		Reporter.log("Entering the URL", true);
		driver.get("https://temp-mail.org/en/");
		Thread.sleep(4000);
		Reporter.log("Opening temp email generator page", true);
		WebElement mail = driver.findElement(By.xpath("//input[@id='mail']"));
		if (mail.getAttribute("value") != email) {
			email = mail.getAttribute("value");
		} else {
			Reporter.log("Not generated any email", true);
		}
		return email;

	}*/
	
	
	
//	public void waitForElement
	


}