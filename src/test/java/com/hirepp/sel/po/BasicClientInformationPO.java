package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class BasicClientInformationPO {

    public WebDriver driver;
    BaseUtils cm = new BaseUtils(driver);

    @FindBy(xpath = "//h1[.='Basic Client Information']") public WebElement clientInfoPageTitle;
    @FindBy(xpath = "//input[@placeholder='Client Name']") public WebElement clientName;
    @FindBy(xpath = "//input[@placeholder='Hiring Manager']") public WebElement hiringManager;
    @FindBy(xpath = "//label[.='Location Type']/following-sibling::select") public WebElement locationType;
    @FindBy(xpath = "//input[@placeholder='Location']") public WebElement location;
    @FindBy(xpath = "//input[@placeholder='No. of Openings']") public WebElement openings;
    @FindBy(xpath = "//input[@placeholder='job Title']") public WebElement jobTitle;
    @FindBy(xpath = "//input[@id='hirePPDateOfJoining']") public WebElement joiningDate;
    @FindBy(xpath = "//button[.='Next']") public WebElement clientInfoNext;


    public GeneralDetailsPO goToGeneralDetailsPage(AddJD data) throws InterruptedException {
        Reporter.log("inside the goTOGeneralDetails method",true);
        Thread.sleep(3000);
        clientName.sendKeys(data.clientName);
        hiringManager.sendKeys(data.HiringManager);
        cm.Select_ddElementByIndex(locationType,1);
        location.sendKeys(data.location);
        openings.sendKeys(Keys.NUMPAD1);
        jobTitle.sendKeys(data.jdName);
//        Point dateloc = joiningDate.getLocation();
//        System.out.println(dateloc);

//        Actions actions=new Actions(driver);
//        actions.moveToElement(joiningDate).click().perform();
//        actions.moveToElement(joiningDate,125,-30).click().perform();
//        actions.build().perform();


//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.getElementById('hirePPDateOfJoining').setAttribute('value', '2022-09-22')");
//        joiningDate.clear();
//       String  date = joiningDate.getAttribute("min");
        joiningDate.sendKeys("10-10-2022");


        clientInfoNext.click();
        return new GeneralDetailsPO(this.driver);

    }

    public BasicClientInformationPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }

}
