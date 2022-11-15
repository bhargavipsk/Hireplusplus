package com.hirepp.sel.po;

import com.hirepp.utils.BaseUtils;
import com.hirepp.utils.config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ChooseAnOptionPO {

    public WebDriver driver;
    BaseUtils baseUtils=new BaseUtils(driver);

    @FindBy(xpath = "//h1") public WebElement ChooseOptionTitle;
    @FindBy(xpath = "//div[@class='drop-file-input']") public WebElement UploadDoc;
    @FindBy(xpath = "//h4[.='Manually fill the form']") public WebElement ManualFillForm;



    public JobsPO goToUpload(String exePath) throws Exception {
        String jobId = ChooseOptionTitle.getText();
        String[] id = baseUtils.stringSplitBySpace(jobId);
        jobId=id[id.length-1];
        UploadDoc.click();
        baseUtils.uploadDoc(exePath);
        return new JobsPO(this.driver,jobId);
    }

    public RequirementsAndPerksPO goToManualFillForm(){
        String jobId = ChooseOptionTitle.getText();
        String[] id = baseUtils.stringSplitBySpace(jobId);
        jobId=id[id.length-1];
        Reporter.log("goToManualFillForm method",true);
        ManualFillForm.click();
        return new RequirementsAndPerksPO(this.driver,jobId);
    }



    public ChooseAnOptionPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }
}
