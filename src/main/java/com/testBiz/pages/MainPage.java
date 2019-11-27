package com.testBiz.pages;

import com.testBiz.util.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriverWait wait;

    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement timeBtnHeader;

    @FindBy(id = "menu_attendance_Attendance")
    private WebElement attendanceBtnHeader;

    @FindBy(id = "menu_attendance_punchIn")
    private WebElement punchInOutBtnDropDown;

    @FindBy(id = "menu_attendance_viewMyAttendanceRecord")
    private WebElement myRecordsBtnDropDown;

    public void clickTimeBtnHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(timeBtnHeader));
        timeBtnHeader.click();
    }

    public void clickAttendanceBtn(){
        wait.until(ExpectedConditions.visibilityOf(attendanceBtnHeader));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance().getDriver();
        jse.executeScript("document.getElementById('menu_attendance_Attendance').focus();");
        attendanceBtnHeader.click();
    }

    public  void clickPunchInOutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(punchInOutBtnDropDown));
        punchInOutBtnDropDown.click();
    }

    public void clickMyRecordsBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(myRecordsBtnDropDown));
        myRecordsBtnDropDown.click();
    }

    public MainPage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
    }
}
