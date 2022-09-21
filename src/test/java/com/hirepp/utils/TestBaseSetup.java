package com.hirepp.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hirepp.sel.po.FirstPagePO;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author bhargavi The BaseTest class Opens the browser and the URL and
 *         initializes the driver object.
 *
 */

public class TestBaseSetup {

	public WebDriver driver;
	config getProp = new config();

	/**
	 * 
	 * setUp() before method runs before each Test of TestNG. Checks if driver
	 * object is null if null , loads the config file.
	 * 
	 * 
	 */
	@BeforeMethod
	public FirstPagePO setUp() throws IOException {
		System.out.println("driver = " + driver);
		if (driver == null) {
			Reporter.log("Inside if block of driver==null", true);
			getProp.loadConfigFile();
		}

		if (getProp.getPropertyVal("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Reporter.log("Brower is maximized", true);
			Reporter.log("Entering the URL", true);
			driver.get(getProp.getPropertyVal("testurl"));
		}

		else if (getProp.getPropertyVal("browser").equalsIgnoreCase("firefox")) {
			Reporter.log("Opening firefox",true);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			Reporter.log("Brower is maximized", true);
			Reporter.log("Entering the URL", true);
			driver.get(getProp.getPropertyVal("testurl"));
			Reporter.log("Entered the url" , true);
		}

		else if (getProp.getPropertyVal("browser").equalsIgnoreCase("edgedriver")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			Reporter.log("Brower is maximized", true);
			Reporter.log("Entering the URL", true);
			driver.get(getProp.getPropertyVal("testurl"));
		}
		return new FirstPagePO(this.driver);
	}

	/*@AfterMethod
	public void tearDown() throws InterruptedException {
		Reporter.log("Inside the teardown", true);
		driver.close();
		Reporter.log("Teardown is successful", true);
	}*/

	/*
	 * public WebDriver openBrowser() { driver.manage().window().maximize();
	 * Reporter.log("Brower is maximized", true); Reporter.log("Entering the URL",
	 * true); driver.get(getProp.getPropertyVal("testurl")); return driver; }
	 */
}
