package ua.testbiz.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pojo.Candidate;
import pojo.Vacancy;
import util.Application;

import java.util.List;

public class RecruitmentPage {
    @FindBy(xpath = "//a[@id='menu_recruitment_viewCandidates']")
    private WebElement candidateSubOption;

    @FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
    private WebElement vacancySubOption;

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> candidateTable;

    // candidate
    @FindBy(xpath = "//input[@id='addCandidate_firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='addCandidate_lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='addCandidate_email']")
    private WebElement emailInput;

    @FindBy(xpath = "//select[@id='addCandidate_vacancy']")
    private WebElement jobVacancySelect;


    // candidate search
    @FindBy(xpath = "//input[@id='candidateSearch_candidateName']")
    private WebElement candidateSearchNameInput;

    @FindBy(xpath = "//input[@id='btnSrch']")
    private WebElement candidateSearchButton;

    // vacancy
    @FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
    private WebElement jobTitleSelect;

    @FindBy(xpath = "//input[@id='addJobVacancy_name']")
    private WebElement vacancyNameInput;

    @FindBy(xpath = "//span[@class='validation-error']")
    public WebElement validationError;

    @FindBy(xpath = "//input[@id='addJobVacancy_hiringManager']")
    private WebElement managerInput;

    @FindBy(xpath = "//div[@class='ac_results']//li")
    private List<WebElement> managerValue;

    @FindBy(xpath = "//input[@id='btnBack']")
    private WebElement backButton;

    // vacancy search
    @FindBy(xpath = "//select[@id='vacancySearch_jobVacancy']")
    private WebElement vacancyJobSelect;

    @FindBy(xpath = "//select[@id='vacancySearch_hiringManager']")
    private WebElement vacancyManagerSelect;

    @FindBy(xpath = "//input[@id='btnSrch']")
    private WebElement vacancySearchButton;

    private String position;
    private String managerName;

    public RecruitmentPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public RecruitmentPage switchToCandidate() {
        candidateSubOption.click();
        return this;
    }

    public RecruitmentPage switchToVacancy() {
        vacancySubOption.click();
        return this;
    }

    public RecruitmentPage addCandidate(Candidate candidate) {
        addButton.click();

        firstNameInput.sendKeys(candidate.getFirstName());
        lastNameInput.sendKeys(candidate.getLastName());
        emailInput.sendKeys(candidate.getEmail());

        saveButton.click();

        return this;
    }

    public boolean checkCandidate(Candidate candidate) {
        for (WebElement element : candidateTable) {
            List<WebElement> candidateName = element.findElements(By.tagName("a"));

            if (candidateName.get(0).getText().equals(candidate.getFirstName() + " " + candidate.getLastName())) {
                System.out.printf("Candidate %s exists.%n", candidateName.get(0).getText());
                return true;
            }
        }
        return false;
    }

    public RecruitmentPage searchCandidate(Candidate candidate) {
        candidateSearchNameInput.sendKeys(String.join(" ", candidate.getFirstName(), candidate.getLastName()));
        candidateSearchButton.click();

        return this;
    }

    public RecruitmentPage addVacancy(Vacancy vacancy) {
        addButton.click();

        Select jobSelect = new Select(jobTitleSelect);
        jobSelect.selectByValue(vacancy.getJobTitle());

        vacancyNameInput.sendKeys(vacancy.getPosition());

        managerInput.sendKeys(" ");
        managerName = managerValue.get(vacancy.getManagerValue()).getText();
        managerInput.sendKeys(managerName);

        saveButton.click();
        backButton.click();
        return this;
    }

    public boolean checkVacancy(Vacancy vacancy) {
        for (WebElement element : candidateTable) {
            List<WebElement> vacancies = element.findElements(By.tagName("a"));
            List<WebElement> managers = element.findElements(By.xpath("//td[4]"));

            for (int i = 0; i < managers.size(); i++) {
                if (vacancies.get(0).getText().equals(vacancy.getPosition()) && managers.get(i).getText().equals(managerName)) {
                    System.out.printf("Vacancy of %s [manager %s] exists.%n", vacancies.get(0).getText(), managers.get(i).getText());
                    return true;
                }
            }
        }
        return false;
    }

    public RecruitmentPage searchVacancy(Vacancy vacancy) {
        Select vacancyJob = new Select(vacancyJobSelect);
        vacancyJob.selectByValue(vacancy.getPosition());

        Select vacancyManager = new Select(vacancyManagerSelect);
        vacancyManager.selectByVisibleText(managerName);

        vacancySearchButton.click();
        return this;
    }
}
