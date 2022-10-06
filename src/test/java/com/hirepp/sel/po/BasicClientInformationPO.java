package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import com.hirepp.utils.BaseUtils;
import com.hirepp.utils.config;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.io.IOException;


public class BasicClientInformationPO {

    public WebDriver driver;
    BaseUtils baseUtils =new BaseUtils(driver);
    config getProp = new config();

    @FindBy(xpath = "//h1[.='Basic Client Information']") public WebElement clientInfoPageTitle;
    @FindBy(xpath = "//input[@placeholder='Client Name']") public WebElement clientName;
    @FindBy(xpath = "//input[@placeholder='Hiring Manager']") public WebElement hiringManager;
    @FindBy(xpath = "//label[.='Location Type']/following-sibling::select") public WebElement locationType;
    @FindBy(xpath = "//input[@placeholder='Location']") public WebElement location;
    @FindBy(xpath = "//input[@placeholder='No. of Openings']") public WebElement openings;
    @FindBy(xpath = "//input[@placeholder='job Title']") public WebElement jobTitle;
    @FindBy(xpath = "//input[@id='hirePPDateOfJoining']") public WebElement joiningDate;
    @FindBy(xpath = "//button[.='Next']") public WebElement clientInfoNext;


    public GeneralDetailsPO goToGeneralDetailsPage(AddJD data) throws InterruptedException, IOException {
        Reporter.log("inside the goTOGeneralDetails method",true);
        Thread.sleep(3000);
        baseUtils.enterData(clientName,data.clientName);
        baseUtils.enterData(hiringManager,data.HiringManager);
        baseUtils.Select_ddElementByIndex(locationType,1);
        baseUtils.enterData(location,data.location);
 //       baseUtils.enterData(openings,String.valueOf(Keys.NUMPAD1));
        baseUtils.enterData(openings,String.valueOf(data.numberOfOpenings));
        baseUtils.enterData(jobTitle,data.jdName);
        String date=baseUtils.getAttributeVal(joiningDate,"min");
        getProp.loadConfigFile();
        date=baseUtils.dateEntering(date, getProp.getPropertyVal("browser"));
        baseUtils.enterData(joiningDate,date);
        clientInfoNext.click();
        return new GeneralDetailsPO(this.driver);

    }

    public BasicClientInformationPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }

}
