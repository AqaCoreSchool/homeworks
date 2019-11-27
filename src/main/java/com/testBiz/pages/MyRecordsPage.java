package com.testBiz.pages;

import com.testBiz.util.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyRecordsPage {

    private WebDriverWait wait;

    @FindBy (id = "attendance_date")
    private WebElement dateMyRecords;

    @FindBy (id = "//td[contains(text(), 'OVlsaenko Punch In')]")
    private WebElement textPunchIn;

    @FindBy (id = "//td[contains(text(), 'OVlsaenko Punch Out')]")
    private WebElement textPunchOut;

    public MyRecordsPage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
    }

    public void setDate(String date){
        wait.until(ExpectedConditions.elementToBeClickable(dateMyRecords));
        dateMyRecords.click();
        dateMyRecords.click();
        dateMyRecords.sendKeys(date);
        dateMyRecords.sendKeys(Keys.ENTER);
    }


    public void checkTextPunchIn(){
        wait.until(ExpectedConditions.visibilityOf(textPunchIn));
        Assert.assertTrue(textPunchIn.isDisplayed(), "User is punched in");
    }

    public void checkTextPunchOut(){
        wait.until(ExpectedConditions.visibilityOf(textPunchOut));
        Assert.assertTrue(textPunchOut.isDisplayed(), "User is punched out");
    }



}
