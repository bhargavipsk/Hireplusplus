package com.hirepp.sel.po;

import com.hirepp.utils.BaseUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;
import java.util.Set;

public class InterviewPO {
    WebDriver driver;
    BaseUtils baseUtils=new BaseUtils(driver);


    @FindBy(xpath = "//button[.=' End Interview ']") public WebElement End;
    @FindBy(xpath = "//div[.='Knowledge']//following-sibling::div//div[@class='slider-handle min-slider-handle round']") public WebElement KnowledgerSlider;
    @FindBy(xpath = "//div[.='Experience']//following-sibling::div//div[@class='slider-handle min-slider-handle round']") public WebElement ExpSlider;
    @FindBy(xpath = "//div[.='Clarity Of Thoughts']//following-sibling::div//div[@class='slider-handle min-slider-handle round']") public WebElement ThoughtSlider;

//    @FindBys(@FindBy(xpath = "//div[@class='col-sm']")) public List<WebElement> Stars;
    @FindBy(xpath = "//input[@placeholder='Type a Message']") public WebElement messageInput;
    @FindBy(xpath = "//div[.=' Chat ']") public WebElement chatTab;
    @FindBy(xpath = "//div[.=' Code Editor ']") public WebElement codeEditorTab;
    @FindBy(xpath = "//div[.=' View JD ']") public WebElement JdTab;
    @FindBy(xpath = "//div[.=' View Resume ']") public WebElement ResumeTab;
//    @FindBy(className = "bi bi-mic") public WebElement AudioMute;
//    @FindBy(className = "bi bi-mic-mute") public WebElement AudioUnmute;
//    @FindBy(className = "bi bi-camera-video") public WebElement VideoOff;
//    @FindBy(className = "bi bi-camera-video-off") public WebElement VideoOn;

    @FindBys(@FindBy(xpath = "//div[@class='row tabs-row']/div")) public List<WebElement> Tabs;
    @FindBy(xpath = "//div[.=' QnA Suggestions ']") public WebElement QnATab;
    @FindBys(@FindBy(xpath ="//div[@class='question-outline']//div[@class='question-ques']")) public List<WebElement> questions;
    @FindBys(@FindBy(xpath = "//div[@class='p-0']")) public List<WebElement> skillTabs;
    @FindBy(xpath = "//div[@class='col-md-2 timer-label']") public WebElement Timer;
    @FindBys(@FindBy(xpath = "//div[.='100%']")) public List<WebElement> percent100;

    @FindBy(xpath = "//button[.='Next Skill']") public WebElement next;
    @FindBy(xpath = "//button[.='SUBMIT']") public WebElement submit;
    @FindBys(@FindBy(xpath = "//div[@class='col-sm']")) public List<WebElement> Stars;





    public void audioVideoOff() throws InterruptedException {
        baseUtils.elementClickableWait(driver,chatTab);
//       AudioMute.click();
//       VideoOff.click();
    }

    public void chatting(String message) throws InterruptedException {
        baseUtils.elementVisibleWait(driver,chatTab);
        chatTab.click();
        Thread.sleep(2000);
        messageInput.sendKeys(message);
        messageInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    public void tabs() throws InterruptedException {
        baseUtils.elementVisibleWait(driver,chatTab);
       for(WebElement e:Tabs){
           e.click();
           Thread.sleep(2000);
       }
    }

    public void InterviewAssessment() throws InterruptedException {
        QnATab.click();
        Thread.sleep(2000);
        for(WebElement s:skillTabs) {
            s.click();
            QnATab.click();
            Thread.sleep(2000);
            Set<Integer> i = baseUtils.randomThree(0, questions.size());
            for (int j : i) {
                String ques = questions.get(j).getText();
                switch (baseUtils.randomOne(5, 1)) {
                    case 1: {
                        driver.findElement(By.xpath("//div[.=' " + ques + " ']//following-sibling::div/div[.='Terrible']")).click();
                        break;
                    }
                    case 2: {
                        driver.findElement(By.xpath("//div[.=' " + ques + " ']//following-sibling::div/div[.='Poor']")).click();
                        break;
                    }
                    case 3: {
                        driver.findElement(By.xpath("//div[.=' " + ques + " ']//following-sibling::div/div[.='Adequate']")).click();
                        break;
                    }
                    case 4: {
                        driver.findElement(By.xpath("//div[.=' " + ques + " ']//following-sibling::div/div[.='Good']")).click();
                        break;
                    }
                    case 5: {
                        driver.findElement(By.xpath("//div[.=' " + ques + " ']//following-sibling::div/div[.='Excellent']")).click();
                        break;
                    }
                }
            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,0)","");
            int pix;
            pix=baseUtils.randomOne(5,0)*100;
            Actions actions = new Actions(driver);
            actions.dragAndDropBy(KnowledgerSlider, pix, 0).perform();
            Rectangle point = driver.findElement(By.xpath("//body")).getRect();
            int height = point.getHeight();
            actions.scrollByAmount(0,height).perform();
            pix=baseUtils.randomOne(5,0)*100;
            actions.dragAndDropBy(ExpSlider, pix, 0).perform();
            pix=baseUtils.randomOne(5,0)*100;
            actions.dragAndDropBy(ThoughtSlider, pix, 0).perform();
            actions.build().perform();
            pix=baseUtils.randomOne(6,2);
            Stars.get(pix).click();
            actions.scrollByAmount(0,-height).perform();

        }
    }

    public void candidateEnd() throws InterruptedException {
        baseUtils.elementVisibleWait(driver,End);
//       AudioUnmute.click();
//       VideoOn.click();
       Thread.sleep(2000);
        End.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    public void RecruiterEnd() throws InterruptedException {
        baseUtils.elementVisibleWait(driver,End);
//        AudioUnmute.click();
//        VideoOn.click();
        Thread.sleep(2000);
        End.click();
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    public void PanelistEnd() throws InterruptedException {
        baseUtils.elementVisibleWait(driver,End);
//        AudioUnmute.click();
//        VideoOn.click();
        Thread.sleep(2000);
        End.click();
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }
    public InterviewPO(WebDriver driver){
        Reporter.log("inside the Interview page",true);
        this.driver =driver;
        PageFactory.initElements(driver,this);
        Reporter.log("InitElements method Created the webelements in View Jd Page",true);
}
}
