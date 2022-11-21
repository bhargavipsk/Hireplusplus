package com.hirepp.utils;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailRelated {
	static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.get("https://platform.dev.hireplusplus.com/allJd");
			Thread.sleep(4000);
			
			
			driver.findElement(By.xpath("//a[text()='Log in")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			
			WebElement emailID = driver.findElement(By.xpath("//input[@placeholder='Enter email Id']"));
		
			
			/*
			.sendKeys(");
			@FindBy(how = How.XPATH, using = ")
			public WebElement emailId;
			@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your password']")
			public WebElement password;
			@FindBy(how = How.XPATH, using = "//button[text()='Login']")
			public WebElement Login_btn;

		
*/	
		}	
		}
