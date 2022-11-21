package com.hirepp.sel.po;

import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SideBarPO {

    public WebDriver driver;
    BaseUtils cm = new BaseUtils(driver);

    @FindBy(xpath = "//div[.='Jobs']") public WebElement Jobs;
    @FindBy(xpath = "//div[.='Home']") public WebElement Home;




    public JobsPO goTOJobsPage() throws InterruptedException {
        Reporter.log("inside the goTOJobs method",true);
        cm.elementVisibleWait(driver,Jobs);
        Jobs.click();
        Reporter.log("Clicked on Jobs",true);
        return new JobsPO(this.driver);
    }

    public DashboardPagePO goTOHomePage() throws InterruptedException {
        Reporter.log("inside the goTOHome method",true);
        Thread.sleep(3000);
        Home.click();
        Reporter.log("Clicked on Home",true);
        return new DashboardPagePO(this.driver);
    }


    public SideBarPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }



}
