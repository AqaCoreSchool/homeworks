package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.data.UserData;
import selenium.driver.Driver;

public class PunchInOutPage {
    private WebDriverWait wait;

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


    public PunchInOutPage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
    }

    public String getCurrentDateLabel() {
        wait.until(ExpectedConditions.visibilityOf(currentDateLabel));
        return currentDateLabel.getText();
    }

    public PunchInOutPage fillTextArea(String note) {
        wait.until(ExpectedConditions.visibilityOf(noteTextArea));
        noteTextArea.sendKeys(note);
        return this;
    }

    public PunchInOutPage clickPunchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnPunch));
        btnPunch.click();
        return this;
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.getText();
    }
}
