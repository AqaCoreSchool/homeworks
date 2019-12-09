package testpackage.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testpackage.base.BasePage;
import testpackage.entity.Candidate;

import java.util.List;

public class CandidatesPage extends BasePage {

    @FindBy (id = "btnAdd")
    private WebElement btnAdd;

    @FindBy (id = "addCandidate_firstName")
    private WebElement firstNameInput;

    @FindBy (id = "addCandidate_middleName")
    private WebElement middleNameInput;

    @FindBy (id = "addCandidate_lastName")
    private WebElement lastNameInput;

    @FindBy (id = "addCandidate_email")
    private WebElement emailInput;

    @FindBy (id = "addCandidate_contactNo")
    private WebElement phoneNumberInput;

    @FindBy (id = "addCandidate_vacancy")
    private WebElement btnSelectVacancy;

    @FindBy (xpath = "//option[contains(text(),'AQA Junior')]")
    private WebElement selectAQAJunior;

    @FindBy (id = "addCandidate_resume")
    private WebElement resumeInput;

    @FindBy (id = "addCandidate_consentToKeepData")
    private WebElement consentToKeepData;

    @FindBy (id = "btnSave")
    private WebElement btnSave;

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> tableCandidates;

    @FindBy(xpath ="//li[@class='line nameContainer']//li[1]//span[1]")
    private WebElement firstNameInputError;

    @FindBy(xpath ="//li[@class='line nameContainer']//li[3]//span[1]")
    private WebElement lastNameInputError;

    @FindBy(xpath ="//span[contains(text(),'Expected format: admin@example.com')]")
    private WebElement emailFormatError;

    @FindBy(xpath ="//span[contains(text(),'Should be less than 30 characters')]")
    private WebElement phoneFormatError;

    @Step
    public CandidatesPage createdCandidate(Candidate candidate){
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        firstNameInput.sendKeys(candidate.getFirstName());
        middleNameInput.sendKeys(candidate.getMiddleName());
        lastNameInput.sendKeys(candidate.getLastName());
        emailInput.sendKeys(candidate.getEmail());
        phoneNumberInput.sendKeys(candidate.getPhoneNumber());
        btnSelectVacancy.click();
        selectAQAJunior.click();
        resumeInput.sendKeys(candidate.getResume());
        consentToKeepData.click();
        btnSave.click();
        return this;
    }

    @Step
    public CandidatesPage addCandidateInfoForNegativeTest(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        btnSave.click();
        return this;
    }

    @Step
    public boolean filterCandidates(Candidate candidate){
        boolean candidates = tableCandidates.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(candidate.getFirstName())
                        &e.contains(candidate.getMiddleName())
                        &e.contains(candidate.getLastName())
                        &e.contains(candidate.getVacancy())
                        &e.contains(candidate.getDate()));
        return candidates;
    }
    @Step
    public boolean isCandidateNameErrorDisplayed(){
        try{
            return firstNameInputError.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    @Step
    public boolean isCandidateLastNameErrorDisplayed(){
        try{
            return lastNameInputError.isDisplayed();
        }catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    @Step
    public boolean isEmailFormatErrorDisplayed(){
        try{
            return emailFormatError.isDisplayed();
        }catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    @Step
    public boolean isPhoneFormatErrorDisplayed(){
        try{
            return phoneFormatError.isDisplayed();
        }catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
}
