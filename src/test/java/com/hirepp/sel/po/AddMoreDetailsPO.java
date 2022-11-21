package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddMoreDetailsPO {

    WebDriver driver;
    String jobId;
    BaseUtils baseUtils =new BaseUtils(driver);

    @FindBy(xpath = "//h1[.='Add More Details']") public WebElement addMoreDetailsTitle;
    @FindBy(xpath = "//textarea") public WebElement moreDetails;
    @FindBy(xpath = "//button[.='Create Job']") public WebElement addMoreDetailsNext;


    public ReviewJdPO goToReviewJD(AddJD data){
        Reporter.log("inside goToReviewJD method",true);
        baseUtils.elementVisibleWait(driver,moreDetails);
        baseUtils.enterData(moreDetails,data.moreDetails);
        addMoreDetailsNext.click();
        return new ReviewJdPO(this.driver,this.jobId);
    }

    public AddMoreDetailsPO(WebDriver driver, String jobId){
        this.driver=driver;
        this.jobId=jobId;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }


}
