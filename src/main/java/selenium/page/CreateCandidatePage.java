package selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.driver.Driver;

public class CreateCandidatePage {
    private WebDriverWait wait;

    @FindBy(id = "addCandidate_firstName")
    private WebElement candidateFirstName;

    @FindBy(id = "addCandidate_lastName")
    private WebElement candidateLastName;

    @FindBy(id = "addCandidate_email")
    private WebElement candidateEmail;

    @FindBy(id = "addCandidate_vacancy")
    private WebElement candidateVacancy;

    @FindBy(id = "addCandidate_appliedDate")
    private WebElement candidateAppliedDate;

    @FindBy(id = "addCandidate_contactNo")
    private WebElement candidateContactNo;

    @FindBy(id = "frmAddCandidate")
    private WebElement candidateForm;

    @FindBy(id = "btnSave")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@class='message success fadable']")
    private WebElement successMsg;


    public CreateCandidatePage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(candidateForm));
    }

    public CreateCandidatePage fillFirstName(String name) {
        candidateFirstName.sendKeys(name);
        return this;
    }

    public CreateCandidatePage fillLastName(String lastname) {
        candidateLastName.sendKeys(lastname);
        return this;
    }

    public CreateCandidatePage fillContactNo(String number) {
        candidateContactNo.sendKeys(number);
        return this;
    }

    public CreateCandidatePage fillEmail(String email) {
        candidateEmail.sendKeys(email);
        return this;
    }

    public CreateCandidatePage selectVacancy(String name) {
        candidateVacancy.sendKeys(name, Keys.ENTER);
        return this;
    }

    public CreateCandidatePage fillDate(String date) {
        candidateAppliedDate.clear();
        candidateVacancy.sendKeys(date);
        return this;
    }

    public CreateCandidatePage btnSaveClick() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return this;
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.getText();
    }
}
