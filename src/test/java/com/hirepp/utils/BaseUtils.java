package com.hirepp.utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * BaseUtils contains re-usable methods that can be called within the pageobject
 * classes
 *
 * @author Bhargavi created on 16/09/2022
 */

public class BaseUtils {

	public WebDriver driver;
	config gp = new config();

	public BaseUtils(WebDriver driver) {
		Reporter.log("Inside the BaseUtils constructor", true);
		this.driver = driver;
	}

	public void enterDataSendkeys(WebElement webElement, String data) {
		webElement.click();
		webElement.sendKeys(data);
	}

	public void Select_ddElementByIndex(WebElement webElement,int i){
		Select select = new Select(webElement);
		select.selectByIndex(i);
	}

	public String Selected_ddElement(WebElement webElement) {

		Select select = new Select(webElement);
		return select.getFirstSelectedOption().getText();

	}

	public List<WebElement> allddElements(WebElement webElement) {
		Select select = new Select(webElement);
		return select.getOptions();
	}

	public void wait(int w) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(w));
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
	
	
	
	
	


}