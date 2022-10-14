package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ViewJdPO {
    WebDriver driver;
    BaseUtils baseUtils=new BaseUtils(driver);

    @FindBy(xpath ="//button[text()='+ Add Candidates']") public WebElement addCandidate;
    @FindBy(xpath = "//span[text()='Add Candidates']") public WebElement addCandidateMultiple;
    @FindBy(xpath = "//span[.='+ Add Skill']") public WebElement addSkills;
    @FindBy(xpath = "//button[.='+ Add Skills']") public WebElement popupAddSkills;
    @FindBy(xpath = "//button[.='Save']") public WebElement popupSave;





    public AddCandidatePO goToAddCandidatePO(){
        if(baseUtils.isElementPresent(addCandidate)) {
            addCandidate.click();
        }
        else{
            addCandidateMultiple.click();
        }
        return new AddCandidatePO(driver);
    }

    public ViewJdPO addSkills(AddJD data) throws InterruptedException {
        Thread.sleep(5000);
        addSkills.click();
        Thread.sleep(2000);
        for(int i=0;i<data.skills.size();i++){
            popupAddSkills.click();
            driver.findElement(By.id("rc_select_"+i)).sendKeys(data.skills.get(i));
            driver.findElement(By.id("rc_select_"+i)).sendKeys(Keys.ENTER);
//            driver.findElement(By.xpath("//div[.='"+data.skills.get(i)+"']")).click();
            driver.findElement(By.id("skillPerc_"+i)).sendKeys(String.valueOf(data.weightage[i]));
            Thread.sleep(1000);

        }
        popupSave.click();
        return new ViewJdPO(this.driver);
    }

    public ViewJdPO(WebDriver driver){
        Reporter.log("inside the View Jd page",true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements in View Jd Page", true);
    }


}
