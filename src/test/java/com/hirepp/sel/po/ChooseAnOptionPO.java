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
    config getProp = new config();

    @FindBy(xpath = "//h1") public WebElement ChooseOptionTitle;
    @FindBy(xpath = "//div[@class='drop-file-input']") public WebElement UploadDoc;
    @FindBy(xpath = "//h4[.='Manually fill the form']") public WebElement ManualFillForm;



    public JobsPO goToUpload() throws Exception {
        UploadDoc.click();
        getProp.loadConfigFile();
        String browser = getProp.getPropertyVal("browser");
        Thread.sleep(10000);
        if(browser.equalsIgnoreCase("chrome")){
            baseUtils.uploadDoc(".\\ScriptsDocs\\ChromeJdUpload.exe");
        }
        if(browser.equalsIgnoreCase("firefox")) {
            baseUtils.uploadDoc(".\\ScriptsDocs\\JdUpload.exe");
        }
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
