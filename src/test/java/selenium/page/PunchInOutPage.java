package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        getWait().until(ExpectedConditions.visibilityOf(currentDateLabel));
        return currentDateLabel.getText();
    }

    public PunchInOutPage fillTextArea(String note) {
        getWait().until(ExpectedConditions.visibilityOf(noteTextArea));
        noteTextArea.sendKeys(note);
        return this;
    }

    public PunchInOutPage clickPunchButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(btnPunch));
        btnPunch.click();
        return this;
    }

    public String getSuccessMessage() {
        getWait().until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.getText();
    }
}
