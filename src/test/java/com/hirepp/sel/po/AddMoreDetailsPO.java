package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddMoreDetailsPO {

    WebDriver driver;

    @FindBy(xpath = "//h1[.='Add More Details']") public WebElement addMoreDetailsTitle;
    @FindBy(xpath = "//textarea") public WebElement moreDetails;
    @FindBy(xpath = "//button[.='Create Job']") public WebElement addMoreDetailsNext;


    public ReviewJdPO goToReviewJD(AddJD data){
        moreDetails.sendKeys(data.moreDetails);
        addMoreDetailsNext.click();
        return new ReviewJdPO(this.driver);
    }

    public AddMoreDetailsPO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }


}
