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
    BaseUtils baseUtils =new BaseUtils(driver);

    @FindBy(xpath = "//h1[.='Add More Details']") public WebElement addMoreDetailsTitle;
    @FindBy(xpath = "//textarea") public WebElement moreDetails;
    @FindBy(xpath = "//button[.='Create Job']") public WebElement addMoreDetailsNext;


    public ReviewJdPO goToReviewJD(AddJD data){
        Reporter.log("inside goToReviewJD method",true);
        baseUtils.elementClickableWait(moreDetails);
        baseUtils.enterData(moreDetails,data.moreDetails);
        baseUtils.elementClickableWait(addMoreDetailsNext);
        addMoreDetailsNext.click();
        return new ReviewJdPO(this.driver);
    }

    public AddMoreDetailsPO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }


}
