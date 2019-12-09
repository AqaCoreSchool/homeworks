package pages;

import data.Candidate;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.util.List;
import java.util.NoSuchElementException;

public class CandidatesPage extends MainPage{

    @FindBy (id = "btnAdd")
    private WebElement btnAdd;

    @FindBy (id = "addCandidate_firstName")
    private WebElement firstNameInput;

    @FindBy (id = "addCandidate_lastName")
    private WebElement lastNameInput;

    @FindBy (id = "addCandidate_email")
    private WebElement emailInput;

    @FindBy (id = "addCandidate_contactNo")
    private WebElement phoneNumberInput;

    @FindBy(xpath ="//option[contains(text(),'AQA Junior')]")
    private WebElement selectAQAJuniorVacancy;

    @FindBy (id = "addCandidate_consentToKeepData")
    private WebElement consentToKeepData;

    @FindBy (id = "btnSave")
    private WebElement btnSave;

    @FindBy(id = "btnBack")
    private WebElement btnBack;

    @FindBy(tagName = "tr")
    private List<WebElement> candidatesList;

    @FindBy(xpath ="//li[@class='line nameContainer']//li[1]//span[1]")
    private WebElement firstNameInputError;

    @FindBy(xpath ="//li[@class='line nameContainer']//li[3]//span[1]")
    private WebElement lastNameInputError;

    @FindBy(xpath ="//span[contains(text(),'Expected format: admin@example.com')]")
    private WebElement emailFormatError;

    @FindBy(xpath ="//span[contains(text(),'Should be less than 30 characters')]")
    private WebElement phoneFormatError;

    @FindBy(id ="addCandidate_appliedDate")
    private WebElement applicationData;

    @FindBy(xpath ="//span[contains(text(),'Should be less than current date')]")
    private WebElement futureDataError;

    public CandidatesPage clickAddCandidate(){
        Utils.waitAndClick(btnAdd);
        return this;
    }

    public  CandidatesPage fullNameInput(String firstName, String lastName){
        Utils.waitAndSendKeys(firstNameInput, firstName);
        Utils.waitAndSendKeys(lastNameInput, lastName);
        return this;
    }

    public  CandidatesPage emailInput(String email){
        Utils.waitAndSendKeys(emailInput, email);
        return this;
    }

    public  CandidatesPage phoneNumberInput(String phoneNumber){
        Utils.waitAndSendKeys(phoneNumberInput, phoneNumber);
        return this;
    }

    public CandidatesPage selectJobVacancy(){
        Utils.waitAndClick(selectAQAJuniorVacancy);
        return this;
    }

    public CandidatesPage applicationDateInput(String date){
        Utils.waitAndSendKeys(lastNameInput, date);
        return this;
    }

    public CandidatesPage clickConsentAndSave(){
        Utils.waitAndClick(consentToKeepData);
        Utils.waitAndClick(btnSave);
        return this;
    }

    public CandidatesPage clickBackBtn(){
        Utils.waitAndClick(btnBack);
        return this;
    }
    @Step
    public CandidatesPage addCandidateInfo(Candidate candidate){
        clickAddCandidate();
        fullNameInput(candidate.getFirstName(), candidate.getLastName());
        emailInput(candidate.getEmail());
        phoneNumberInput(candidate.getPhoneNumber());
        selectJobVacancy();
        clickConsentAndSave();
        clickBackBtn();
        return this;
    }
    @Step
    public CandidatesPage addCandidateInfoForNegativeTest(){
        clickAddCandidate();
        emailInput("email");
        phoneNumberInput("222222222222222222222222222222222222222222222222222222222222222222222222222222222222");
        clickConsentAndSave();
        return this;
    }
    @Step
    public String findCandidate(Candidate candidate){
        return candidatesList.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(candidate.getFirstName()))
                .filter(s -> s.contains(candidate.getLastName()))
                .filter(s -> s.contains(candidate.getVacancy()))
                .findAny()
                .orElse("");
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
    public boolean isFutureDataErrorDisplayed(){
        try{
            return futureDataError.isDisplayed();
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
