package ua.testbiz.pages;

import data.Candidate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    // candidate
    @FindBy(xpath = "//input[@id='addCandidate_firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='addCandidate_lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='addCandidate_email']")
    private WebElement email;

    @FindBy(xpath = "//select[@id='addCandidate_vacancy']")
    private WebElement jobVacancy;

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

        firstName.sendKeys(candidate.getFirstName());
        lastName.sendKeys(candidate.getLastName());
        email.sendKeys(candidate.getEmail());

        Select selectVacancy = new Select(jobVacancy);
        selectVacancy.selectByValue(Integer.toString((new Random().nextInt(selectVacancy.getOptions().size())) + 1));

        saveButton.click();
    }
}
