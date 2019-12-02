package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.biz.test.entity.Candidate;

public class CreateCandidatePage {


    @FindBy(xpath ="//select[@id='addCandidate_vacancy']")
    private WebElement jobVacancySelect;

    @FindBy(xpath ="//option[contains(text(),'AQA Trainee')]")
    private WebElement vacancy;

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


    public CreateCandidatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void saveNewCandidate(Candidate candidate) {
        jobVacancySelect.click();
        vacancy.click();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        firstNameField.sendKeys(candidate.getFirstName());
        lastNameField.sendKeys(candidate.getLastName());
        emailField.sendKeys(candidate.getEmail());
        saveCandidateButton.click();
    }

    public CandidatesListPage backToCandidatesListPage(WebDriver driver) {
        backToCandidateListPageButton.click();
        return new CandidatesListPage(driver);
    }
}
