package com.hirepp.sel.po;

import com.hirepp.utils.AddJD;
import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class GeneralDetailsPO {

    public WebDriver driver;
    BaseUtils cm = new BaseUtils(driver);

    @FindBy(xpath = "//h1[.='Add General Details']") public WebElement GeneralDetailsTitle;
    @FindBy(xpath = "//label[.='Employment Type']/following-sibling::select") public WebElement employmentType;
    @FindBy(xpath = "//label[.='Domain/Industry']/following-sibling::select") public WebElement domain;
    @FindBy(xpath = "//label[.='Function/Area']/following-sibling::select") public WebElement functionalArea;
    @FindBy(xpath = "//label[.='Currency']/following-sibling::select") public WebElement currency;
    @FindBy(xpath = "//input[@placeholder='Min Salary']") public WebElement minSalary;
    @FindBy(xpath = "//input[@placeholder='Max Salary']") public WebElement maxSalary;
    @FindBy(xpath = "//button[.='Next']") public WebElement generalDetailsNext;

    public ChooseAnOption goToChooseOptionPage(AddJD data){
        cm.Select_ddElementByIndex(employmentType,1);
        domain.sendKeys(data.preferredDomain);
        functionalArea.sendKeys(data.functionalArea);
        cm.Select_ddElementByIndex(currency,1);
        minSalary.sendKeys(data.minSalaryBudget);
        maxSalary.sendKeys(data.maxSalaryBudget);
        generalDetailsNext.click();
        return new ChooseAnOption(this.driver);
    }

    public GeneralDetailsPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements", true);
    }
}