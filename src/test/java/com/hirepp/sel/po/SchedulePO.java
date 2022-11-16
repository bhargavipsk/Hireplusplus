package com.hirepp.sel.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;
import java.util.Scanner;

public class SchedulePO {
    WebDriver driver;


    @FindAll(@FindBy(xpath = "//div[@class='panelist']")) public List<WebElement> panelists;
    @FindAll(@FindBy(xpath = "//span[.='b']")) public List<WebElement> slots;
    @FindBy(xpath = "//button[.='Submit']") public WebElement SlotSubmit;



    public ViewJdPO Schedule() throws InterruptedException {
        panelists.get(panelists.size()-1).click();
        Thread.sleep(5000);
        slots.get(0).click();
        SlotSubmit.click();
        driver.navigate().back();
        driver.navigate().refresh();
        return new ViewJdPO(this.driver);
    }

    public SchedulePO(WebDriver driver){
        Reporter.log("inside the schedule page",true);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Reporter.log("InitElements method Created the webelements in View Jd Page", true);
    }

}