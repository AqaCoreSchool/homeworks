package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.PunchData;

import java.util.List;

public class PunchPage extends BasePage {

    @FindBy(xpath = "//textarea[@id='note']")
    private WebElement punchNoteField;

    @FindBy(xpath = "//*[@id=\"currentTime\"]")
    private WebElement punchTime;

    @FindBy(xpath = "//*[@id=\"btnPunch\"]")
    private WebElement punchInButton;

    public void punchInOut(PunchData punchData) {
        WaitUtil.waitAndType(punchNoteField, punchData.getPunchInMessage());
        punchData.setPunchInTime(punchTime.getText());
        punchInButton.click();
        WaitUtil.waitAndType(punchNoteField, punchData.getPunchOutMessage());
        punchData.setPunchOutTime(punchTime.getText());
        punchInButton.click();
    }
}
