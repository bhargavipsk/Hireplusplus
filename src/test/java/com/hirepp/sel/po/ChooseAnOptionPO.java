package com.hirepp.sel.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ChooseAnOptionPO {

    public WebDriver driver;

    @FindBy(xpath = "//h1[.='Choose an option to fill J.D']") public WebElement ChooseOptionTitle;
    @FindBy(xpath = "//div[@class='drop-file-input']") public WebElement UploadDoc;
    @FindBy(xpath = "//h4[.='Manually fill the form']") public WebElement ManualFillForm;


    public JobsPO goToUpload() throws Exception {
        UploadDoc.click();
        Thread.sleep(10000);
        Runtime.getRuntime().exec(".\\ScriptsDocs\\JdUpload.exe");
        return new JobsPO(this.driver);
    }

    public RequirementsAndPerksPO goToManualFillForm(){
        Reporter.log("goToManualFillForm method",true);
        ManualFillForm.click();
        return new RequirementsAndPerksPO(this.driver);
    }



    public ChooseAnOptionPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }
}
