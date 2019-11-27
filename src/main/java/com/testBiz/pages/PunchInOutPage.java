package com.testBiz.pages;

import com.testBiz.util.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PunchInOutPage {

    private WebDriverWait wait;
    String date, time;

    @FindBy(id = "btnPunch")
    private WebElement inBtn;

    @FindBy(id = "note")
    private WebElement commentInputFieldPunchIn;

    @FindBy(id = "currentDate")
    private WebElement currentDate;

    @FindBy(id = "currentTime")
    private WebElement currentTime;

    public void setCommentTextPunchInOut(String comment){
        wait.until(ExpectedConditions.elementToBeClickable(commentInputFieldPunchIn));
        commentInputFieldPunchIn.click();
        commentInputFieldPunchIn.sendKeys(comment);
    }

    public String getCurrentDate(){
        return date = currentDate.getText();
    }

    public String getCurrentTime(){
        return time = currentTime.getText();
    }

    public void clickInOutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(inBtn));
        inBtn.click();
    }


    public PunchInOutPage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
    }
}
