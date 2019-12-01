package ua.testbiz.pages;

import com.github.javafaker.Faker;
import data.Candidate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

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

    private String position;
    private String managerName;

    public RecruitmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void switchToCandidate() {
        candidateSubOption.click();
    }

    public void switchToVacancy() {
        vacancySubOption.click();
    }

    public void addCandidate(Candidate candidate) {
        addButton.click();

        firstNameInput.sendKeys(candidate.getFirstName());
        lastNameInput.sendKeys(candidate.getLastName());
        emailInput.sendKeys(candidate.getEmail());
        contactNoInput.sendKeys(candidate.getContactNo());

        Select selectVacancy = new Select(jobVacancySelect);
        selectVacancy.selectByValue(Integer.toString(new Random().nextInt(5) + 1));

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

    public void addVacancy() {
        addButton.click();

        Select jobSelect = new Select(jobTitleSelect);
        jobSelect.selectByValue("1");

        position = new Faker().job().position();
        vacancyNameInput.sendKeys(position);

        managerInput.sendKeys(" ");

        managerName = managerValue.get(new Random().nextInt(managerValue.size() + 1)).getText();
        managerInput.sendKeys(managerName);

        saveButton.click();
    }

    public String checkVacancy() {
        for (WebElement element : candidateTable) {
            List<WebElement> vacancies = element.findElements(By.tagName("a"));
            List<WebElement> managers = element.findElements(By.xpath("//td[4]"));

            if (vacancies.get(0).getText().equals(position) && managers.get(0).getText().equals(managerName)) {
                System.out.printf("Vacancy of %s [manager %s] exists.%n", vacancies.get(0).getText(), managers.get(0).getText());
                return vacancies.get(0).getText() + " " + managers.get(0).getText();
            }
        }
        return null;
    }
}
