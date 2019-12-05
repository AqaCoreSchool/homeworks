package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.Wait;

public class PunchInOutPage extends BasePage {

    @FindBy(id = "currentDate")
    private WebElement currentDateLabel;

    @FindBy(id = "note")
    private WebElement noteTextArea;

    @FindBy(id = "btnPunch")
    private WebElement btnPunch;

    @FindBy(xpath = "//label[contains(text(),'Punched in ...')]")
    private WebElement noteLabel;

    @FindBy(xpath = "//div[@class='message success fadable']")
    private WebElement successMsg;

    public String getCurrentDateLabel() {
        Wait.waitForVisible(currentDateLabel);
        return currentDateLabel.getText();
    }

    public PunchInOutPage fillTextArea(String note) {
        Wait.waitForVisible(noteTextArea);
        noteTextArea.sendKeys(note);
        return this;
    }

    public PunchInOutPage clickPunchButton() {
        Wait.waitForElementToBeClickable(btnPunch);
        btnPunch.click();
        return this;
    }

    public String getSuccessMessage() {
        Wait.waitForVisible(successMsg);
        return successMsg.getText();
    }
}
