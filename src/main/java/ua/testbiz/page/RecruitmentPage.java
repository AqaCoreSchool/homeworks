package ua.testbiz.page;

import data.Candidate;
import data.Vacancy;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.Application;
import util.Convertable;

import java.util.List;

public class RecruitmentPage implements Convertable {
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

    // vacancy search
    @FindBy(xpath = "//select[@id='vacancySearch_jobVacancy']")
    private WebElement vacancyJobSelect;

    @FindBy(xpath = "//select[@id='vacancySearch_hiringManager']")
    private WebElement vacancyManagerSelect;

    @FindBy(xpath = "//input[@id='btnSrch']")
    private WebElement vacancySearchButton;

    private String position;
    private String managerName;

    private JSONObject jsonCandidate;
    private JSONObject jsonVacancy;

    public RecruitmentPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public void switchToCandidate() {
        candidateSubOption.click();
    }

    public void switchToVacancy() {
        vacancySubOption.click();
    }

    public void addCandidate(Candidate candidate) {
        jsonCandidate = convertToJson(candidate);

        addButton.click();

        firstNameInput.sendKeys(candidate.getFirstName());
        lastNameInput.sendKeys(candidate.getLastName());
        emailInput.sendKeys(candidate.getEmail());

        saveButton.click();
    }

    public String checkCandidate(Candidate candidate) {
        for (WebElement element : candidateTable) {
            List<WebElement> candidateName = element.findElements(By.tagName("a"));

            if (candidateName.get(0).getText().equals(candidate.getFirstName() + " " + candidate.getLastName())) {
                System.out.printf("Candidate %s exists.%n", candidateName.get(0).getText());
                return candidateName.get(0).getText();
            }
        }
        return null;
    }

    public void searchCandidate(Candidate candidate) {
        candidateSearchNameInput.sendKeys(String.join(" ", candidate.getFirstName(), candidate.getLastName()));
        candidateSearchButton.click();
    }

    public void searchCandidateByJSON() {
        Candidate cand = (Candidate) Convertable.super.getObject(jsonCandidate, Candidate.class);
        searchCandidate(cand);
    }

    public void addVacancy(Vacancy vacancy) {
        addButton.click();

        Select jobSelect = new Select(jobTitleSelect);
        jobSelect.selectByValue(vacancy.getJobTitle());

        vacancyNameInput.sendKeys(vacancy.getPosition());

        managerInput.sendKeys(" ");

        managerName = managerValue.get(vacancy.getManagerValue()).getText();
        managerInput.sendKeys(managerName);

        saveButton.click();
    }

    public String checkVacancy(Vacancy vacancy) {
        for (WebElement element : candidateTable) {
            List<WebElement> vacancies = element.findElements(By.tagName("a"));
            List<WebElement> managers = element.findElements(By.xpath("//td[4]"));

            for (int i = 0; i < managers.size(); i++) {
                if (vacancies.get(0).getText().equals(vacancy.getPosition()) && managers.get(i).getText().equals(managerName)) {
                    System.out.printf("Vacancy of %s [manager %s] exists.%n", vacancies.get(0).getText(), managers.get(i).getText());
                    return vacancies.get(0).getText() + " " + managers.get(i).getText();
                }
            }
        }
        return null;
    }

    public void searchVacancy(Vacancy vacancy) {
        Select vacancyJob = new Select(vacancyJobSelect);
        vacancyJob.selectByVisibleText(vacancy.getPosition());

        Select vacancyManager = new Select(vacancyManagerSelect);
        vacancyManager.selectByVisibleText(managerName);

        vacancySearchButton.click();
    }

    public void searchVacancyByJSON() {
        Vacancy vac = (Vacancy) Convertable.super.getObject(jsonVacancy, Vacancy.class);

        Select vacancyJob = new Select(vacancyJobSelect);
        vacancyJob.selectByValue(position);

        Select vacancyManager = new Select(vacancyManagerSelect);
        vacancyManager.selectByValue(managerName);

        vacancySearchButton.click();
    }
}
