package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ExperienceAndSkillsPO {

    WebDriver driver;
    String jobId;
    BaseUtils baseUtils=new BaseUtils(driver);

    @FindBy(xpath = "//h1[.='Experience and skills']") public WebElement experienceAndSkillsTitle;
    @FindBy(xpath = "//label[.='Minimum']/following-sibling::select") public WebElement minimumExperience;
    @FindBy(xpath = "//label[.='Maximum']/following-sibling::select") public WebElement maximumExperience;
    @FindBy(xpath = "//input[@placeholder='Please enter a skill name']") public WebElement skillName;
    @FindBy(xpath = "//button[.='Add']") public WebElement skillAdd;
    @FindBy(xpath = "//input[@placeholder='Copy and paste if skills are in text format.']") public WebElement skillAsName;
    @FindBy(xpath = "//button[.='Next']") public WebElement experienceAndSkillsNext;



    public AddMoreDetailsPO goToMoreDetails(AddJD data){
        Reporter.log("inside goToMoreDetails method",true);
        baseUtils.Select_ddElementByIndex(minimumExperience,1);
        baseUtils.Select_ddElementByIndex(maximumExperience,3);
        for(String skill:data.skills){
            baseUtils.enterData(skillName,skill);
            skillAdd.click();
        }
        experienceAndSkillsNext.click();
        return new AddMoreDetailsPO(this.driver,this.jobId);

    }
    public ExperienceAndSkillsPO(WebDriver driver, String jobId){
        this.driver = driver;
        this.jobId=jobId;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }

}
