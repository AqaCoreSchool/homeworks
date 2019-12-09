package selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.Utils;
import selenium.common.Wait;

import java.util.List;
import java.util.stream.Collectors;

public class CreateCandidatePage extends BasePage {

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

    @FindBy(className = "validation-error")
    private List<WebElement> requiredFields;

    public CreateCandidatePage fillFirstName(String name) {
        Wait.waitForVisible(candidateFirstName);
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
        Wait.waitForElementToBeClickable(saveBtn);
        saveBtn.click();
        return this;
    }

    public String getSuccessMessage() {
        Wait.waitForVisible(successMsg);
        return successMsg.getText();
    }

    public boolean checkValidation() {
        return requiredFields.isEmpty();
    }

    public String getValidationMessage() {
        return requiredFields.stream()
                .map(WebElement::getText)
                .filter(message -> message.contains(Utils.getProperty("required")) ||
                        message.contains(Utils.getProperty("invalid")) ||
                        message.contains(Utils.getProperty("expectedFormat")))
                .collect(Collectors.joining("\n"));
    }
}
