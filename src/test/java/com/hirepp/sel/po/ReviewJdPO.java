package com.hirepp.sel.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ReviewJdPO {

    WebDriver driver;

    @FindBy(xpath = "//button[.='Confirm and Save']") public WebElement confirmAndSave;

    public JobsPO goToJob(){
        confirmAndSave.click();
        return new JobsPO(this.driver);
    }
    public ReviewJdPO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);

    }
}
