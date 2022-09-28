package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import com.hirepp.utils.BaseUtils;
import com.hirepp.utils.config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.io.IOException;

public class RequirementsAndPerksPO {
    WebDriver driver;
    BaseUtils baseUtils=new BaseUtils(driver);
    config getProp = new config();

    @FindBy(xpath = "//h1[.='Requirements and perks']") public WebElement requirementsAndPerksTitle;
    @FindBy(xpath = "//label[.='Job Description']/following-sibling::textarea") public WebElement jobDescription;
    @FindBy(xpath = "//label[.='Requirements']/following-sibling::textarea") public WebElement Requirements;
    @FindBy(xpath = "//p[.='Perks']/following-sibling::textarea") public WebElement perks;
    @FindBy(xpath = "//button[.='Next']") public WebElement requirementsAndPerksNext;



    public ExperienceAndSkillsPO goToExperience(AddJD data) throws IOException {
        Reporter.log("inside the goToExperience",true);
        getProp.loadConfigFile();
        String description = getProp.getPropertyVal("description");
        String requirements=getProp.getPropertyVal("requirements");
        baseUtils.enterData(jobDescription,description);
        baseUtils.enterData(Requirements,requirements);
        requirementsAndPerksNext.click();
        return new ExperienceAndSkillsPO(this.driver);
    }

    public RequirementsAndPerksPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }

}
