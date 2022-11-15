package com.hirepp.sel.po;

import com.hirepp.utils.AddCandidate;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.Random;

public class ReviewCandidatePO {
    WebDriver driver;
    BaseUtils baseUtils=new BaseUtils(driver);
    Random random=new Random();
    int i;

    @FindBy(xpath = "//input[@placeholder='City']") public WebElement city;
    @FindBy(xpath = "//div[.='Total Exp']/following-sibling::div[1]/div/input") public WebElement TotalExp;
    @FindBy(xpath = "//div[.=' Relavent Exp']/following-sibling::div[1]/div/input") public WebElement RelevantExp;
    @FindBy(xpath = "//input[@placeholder='Add Tags']") public WebElement Domain;
    @FindBy(xpath = "//span[.='Yes']") public WebElement OtherOffersYes;
    @FindBy(xpath = "//span[.='No']") public WebElement OtherOffersNo;
    @FindBy(xpath = "//div[.='Serving Notice']/following-sibling::div[1]/div/input") public WebElement ServingNotice;
    @FindBy(xpath = "//span[.='Large Firms']") public WebElement LargeFirms;
    @FindBy(xpath = "//span[.='Startups']") public WebElement Startups;
    @FindBy(xpath = "//span[.='SME']") public WebElement Sme;
    @FindBy(xpath = "//span[.='MNC']") public WebElement Mnc;
    @FindBy(xpath = "//button[.='Shortlist']") public WebElement Shortlist;



    public ViewJdPO Shortlist(AddCandidate data){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        baseUtils.enterData(city,data.city);
        baseUtils.enterData(TotalExp, String.valueOf(data.total_Exp));
        baseUtils.enterData(RelevantExp,String.valueOf(data.relevant_Exp));
        for (String d: data.Domain) {
            baseUtils.enterData(Domain,d);
            Domain.sendKeys(Keys.ENTER);
        }
        if(data.otherOffers){
            OtherOffersYes.click();
        }
        else {
            OtherOffersNo.click();
        }
        if(data.servingNotice){
            ServingNotice.click();
        }
        i= random.nextInt(5)+1;
        driver.findElement(By.xpath("//li["+i+"]")).click();
        int j=random.nextInt(4)+1;
        for(int j1=0;j1<j;j1++) {
            int k=random.nextInt(4)+1;
            switch (k) {
                case 1:
                LargeFirms.click();
                break;
                case 2:
                    Startups.click();
                    break;
                case 3:
                    Sme.click();
                    break;
                case 4:
                    Mnc.click();
                    break;
            }
        }
        Shortlist.click();
        return new ViewJdPO(this.driver);
    }




    public ReviewCandidatePO(WebDriver driver){
        Reporter.log("inside the View Jd page",true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements in View Jd Page", true);
    }
}
