package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.io.IOException;

public class RequirementsAndPerksPO {
    WebDriver driver;
    String jobId;
    BaseUtils baseUtils=new BaseUtils(driver);


    @FindBy(xpath = "//h1[.='Requirements and perks']") public WebElement requirementsAndPerksTitle;
    @FindBy(xpath = "//label[.='Job Description']/following-sibling::textarea") public WebElement jobDescription;
    @FindBy(xpath = "//label[.='Requirements']/following-sibling::textarea") public WebElement Requirements;
    @FindBy(xpath = "//p[.='Perks']/following-sibling::textarea") public WebElement perks;
    @FindBy(xpath = "//button[.='Next']") public WebElement requirementsAndPerksNext;



    public ExperienceAndSkillsPO goToExperience(AddJD data) throws IOException {
        Reporter.log("inside the goToExperience",true);
        baseUtils.elementVisibleWait(driver,jobDescription);
        baseUtils.enterData(jobDescription,data.description);
        baseUtils.enterData(Requirements,data.requirements);
        requirementsAndPerksNext.click();
        return new ExperienceAndSkillsPO(this.driver,this.jobId);
    }

    public RequirementsAndPerksPO(WebDriver driver, String jobId){
        this.driver = driver;
        this.jobId=jobId;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }

}
