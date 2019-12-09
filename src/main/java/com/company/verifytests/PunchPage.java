package com.company.verifytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PunchPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='btnPunch']")
    private WebElement punch;

    @FindBy(xpath = "//textarea[@id='note']")
    private WebElement note;

    @FindBy(xpath = "//input[@id='btnPunch']")
    private WebElement buttonInOut;

    @FindBy(xpath = "//span[@id='currentDate']")
    private WebElement currentDate;


    public PunchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public PunchPage punchIn(){
        note.click();
        note.sendKeys("START");
        buttonInOut.click();
        return new PunchPage(driver);
    }

    public PunchPage punchOut(){
        note.click();
        note.sendKeys("FINISH");
        buttonInOut.click();
        return new PunchPage(driver);
    }
}
