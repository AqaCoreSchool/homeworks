package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.biz.test.entity.PunchData;

public class PunchPage {


    @FindBy(xpath = "//textarea[@id='note']")
    private WebElement punchNoteField;

    @FindBy(xpath = "//*[@id=\"currentTime\"]")
    private WebElement punchTime;

    @FindBy(xpath = "//*[@id=\"btnPunch\"]")
    private WebElement punchInButton;

    public PunchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void punchInOut(PunchData punchData) {
        punchNoteField.sendKeys(punchData.getPunchInMessage());
        punchData.setPunchInTime(punchTime.getText());
        punchInButton.click();
        punchNoteField.sendKeys(punchData.getPunchOutMessage());
        punchData.setPunchOutTime(punchTime.getText());
        punchInButton.click();
    }


}
