package com.hirepp.sel.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ChooseAnOption {

    public WebDriver driver;

    @FindBy(xpath = "//div[@class='drop-file-input']") public WebElement UploadDoc;


    public JobsPO goToUpload(String filePath) throws Exception {
        UploadDoc.click();
        Thread.sleep(5000);
        Runtime.getRuntime().exec("./ScriptsDocs/JdUpload.exe");
        return new JobsPO(this.driver);
    }



    public ChooseAnOption(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }
}
