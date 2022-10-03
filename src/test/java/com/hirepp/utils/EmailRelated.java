package com.hirepp.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailRelated {
	static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.get("https://mail7.io/");
			Thread.sleep(4000);
			Reporter.log("Opening temp email generator page", true);
		
			WebElement inputbox = driver.findElement(By.name("username"));
			inputbox.click();
			inputbox.sendKeys("tester.plus1");
					
//call registration function here			
			WebElement inboxBtn = driver.findElement(By.xpath("//input[@value='Go to inbox']"));
			inboxBtn.click();
			
			Thread.sleep(4000);

		//	driver.findElement(By.xpath(("//ul[@class='message-list']/li[1]"))).click();
		//	driver.findElement(By.xpath("//p[@class='title']/b[contains(text(),'Mail7')]"));
			
			driver.findElement(By.xpath("//div[@class='subject']/b[contains(text(),'Registration')]")).click(); ;
			
			Thread.sleep(2000);
			

			WebElement fr = driver.findElement(By.xpath("//div[@class='message']/iframe"));

			Thread.sleep(2000);
			
			driver.switchTo().frame(fr);
			
			
			System.out.println("switched to frame");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[contains(text(),'Activate Account')]")).click();
			
			if(driver.findElement(By.xpath("//pre[contains(text(),'successful')")).isDisplayed()){
				System.out.println("The verification is successful login to the application");
			}
		
	}

}
