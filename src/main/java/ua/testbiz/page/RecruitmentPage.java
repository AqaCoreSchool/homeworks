package ua.testbiz.page;

import data.Candidate;
import data.Vacancy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.Driver;

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

    @FindBy(xpath = "//input[@id='addCandidate_contactNo']")
    private WebElement contactNoInput;

    @FindBy(xpath = "//select[@id='addCandidate_vacancy']")
    private WebElement jobVacancySelect;

    // vacancy
    @FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
    private WebElement jobTitleSelect;

    @FindBy(xpath = "//input[@id='addJobVacancy_name']")
    private WebElement vacancyNameInput;

    @FindBy(xpath = "//input[@id='addJobVacancy_hiringManager']")
    private WebElement managerInput;

    @FindBy(xpath = "//div[@class='ac_results']//li")
    private List<WebElement> managerValue;

    private String managerName;

    private WebDriver webDriver;

    public RecruitmentPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(Driver.driver, this);
    }

    public RecruitmentPage switchToCandidate() {
        candidateSubOption.click();
        return this;
    }

    public RecruitmentPage switchToVacancy() {
        vacancySubOption.click();
        return this;
    }

    public RecruitmentPage addRecord() {
        addButton.click();
        return this;
    }

    public RecruitmentPage saveRecord() {
        saveButton.click();
        return this;
    }

    public RecruitmentPage addCandidate(Candidate candidate) {
        firstNameInput.sendKeys(candidate.getFirstName());
        lastNameInput.sendKeys(candidate.getLastName());
        emailInput.sendKeys(candidate.getEmail());
        contactNoInput.sendKeys(candidate.getContactNo());

        Select selectVacancy = new Select(jobVacancySelect);
        selectVacancy.selectByValue("270");

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

    public RecruitmentPage addVacancy(Vacancy vacancy) {
        Select jobSelect = new Select(jobTitleSelect);
        jobSelect.selectByValue(vacancy.getJobTitleValue());

        vacancyNameInput.sendKeys(vacancy.getPosition());

        managerInput.sendKeys(" ");

        managerName = managerValue.get(vacancy.getManagerValue()).getText();
        managerInput.sendKeys(managerName);

        return this;
    }

    public boolean checkVacancy(Vacancy vacancy) {
        for (WebElement element : candidateTable) {
            if (element.getText().contains(vacancy.getPosition()) && element.getText().contains(managerName)) {
                System.out.printf("Vacancy of %s exists.%n", element.getText());
                return true;
            }
        }
        return false;
    }
}
