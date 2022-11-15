package com.hirepp.sel.po;

import com.hirepp.utils.AddCandidate;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CandidateInterviewPO {
    WebDriver driver;
    BaseUtils baseUtils=new BaseUtils(driver);

    @FindBy(name = "username") public WebElement input;
    @FindBy(xpath = "//input[@value='Go to inbox']") public WebElement inbox;
    @FindBy(xpath = "//button[.='Refresh']") public WebElement refresh;
    @FindBy(xpath = "//b[contains(text(),'Interview Scheduled']") public WebElement InterviewMail;



    public void candidateJoining(AddCandidate data) throws Exception{
        driver.get("https://www.mail7.io");
        String mail = driver.getWindowHandle();
        Reporter.log("Opening temp email generator page", true);
        baseUtils.enterData(input, data.email_id);
        inbox.click();
        Thread.sleep(4000);
        refresh.click();
        Thread.sleep(4000);
        InterviewMail.click();
        Thread.sleep(4000);
        WebElement fr = driver.findElement(By.xpath("//div[@class='message']/iframe"));
        driver.switchTo().frame(fr);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'Interview Scheduled']")).click();
        driver.switchTo().window(mail);
        driver.close();
    }

    public CandidateInterviewPO(WebDriver driver){
        Reporter.log("inside the Candidate page",true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements in View Jd Page", true);
    }
}
