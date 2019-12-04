package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.Candidate;

public class CreateCandidatePage extends BasePage {

    @FindBy(xpath = "//select[@id='addCandidate_vacancy']")
    private WebElement jobVacancySelect;

    @FindBy(xpath = "//input[@id='addCandidate_firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='addCandidate_lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='addCandidate_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveCandidateButton;

    @FindBy(xpath = "//input[@id='btnBack']")
    private WebElement backToCandidateListPageButton;

    public CreateCandidatePage() {
        super();
    }

    public void saveNewCandidate(Candidate candidate) {
        WaitUtil.waitAndType(firstNameField, candidate.getFirstName());
        Select select = new Select(jobVacancySelect);
        select.selectByVisibleText(candidate.getVacancy().getName());
        lastNameField.sendKeys(candidate.getLastName());
        emailField.sendKeys(candidate.getEmail());
        saveCandidateButton.click();
    }

    public CandidatesListPage backToCandidatesListPage() {
        WaitUtil.waitAndClick(backToCandidateListPageButton);
        return new CandidatesListPage();
    }
}
