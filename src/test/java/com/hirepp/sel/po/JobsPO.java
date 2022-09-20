package com.hirepp.sel.po;

import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class JobsPO {
    public WebDriver driver;
    BaseUtils cm = new BaseUtils(driver);

    @FindBy(xpath = "//button[.='Add JD +']") public WebElement AddJD;



    public BasicClientInformationPO goTOAddJDPage() throws InterruptedException {
        Reporter.log("inside the goTOJobs method",true);
        Thread.sleep(3000);
        AddJD.click();
        Reporter.log("Clicked on AddJD",true);
        return new BasicClientInformationPO(this.driver);

    }



    public JobsPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }
}
