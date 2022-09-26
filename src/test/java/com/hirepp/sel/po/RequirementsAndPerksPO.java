package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class RequirementsAndPerksPO {
    WebDriver driver;

    @FindBy(xpath = "//h1[.='Requirements and perks']") public WebElement requirementsAndPerksTitle;
    @FindBy(xpath = "//label[.='Job Description']/following-sibling::textarea") public WebElement jobDescription;
    @FindBy(xpath = "//label[.='Requirements']/following-sibling::textarea") public WebElement Requirements;
    @FindBy(xpath = "//p[.='Perks']/following-sibling::textarea") public WebElement perks;
    @FindBy(xpath = "//button[.='Next']") public WebElement requirementsAndPerksNext;



    public ExperienceAndSkillsPO goToExperience(AddJD data){
        jobDescription.sendKeys(data.description);
        Requirements.sendKeys(data.requirements);
        perks.sendKeys(data.perks);
        requirementsAndPerksNext.click();
        return new ExperienceAndSkillsPO(this.driver);
    }

    public RequirementsAndPerksPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }

}
