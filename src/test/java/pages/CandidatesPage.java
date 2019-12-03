package pages;

import data.UserInfo;
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


    public CandidatesPage clickConsentAndSave(){
        Utils.waitAndClick(consentToKeepData);
        Utils.waitAndClick(btnSave);
        return this;
    }

    public CandidatesPage clickBackBtn(){
        Utils.waitAndClick(btnBack);
        return this;
    }

    public CandidatesPage addCandidateInfo(){
        clickAddCandidate();
        fullNameInput(UserInfo.FIRST_NAME,UserInfo.LAST_NAME);
        emailInput(UserInfo.EMAIL);
        phoneNumberInput(UserInfo.PHONE_NUMBER);
        selectJobVacancy();
        clickConsentAndSave();
        clickBackBtn();
        return this;
    }

    public String findCandidate(String firstName, String lastName, String vacancy){
        return candidatesList.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(firstName))
                .filter(s -> s.contains(lastName))
                .filter(s -> s.contains(lastName))
                .filter(s -> s.contains(vacancy))
                .findAny()
                .orElseThrow(NoSuchElementException::new);

    }

}
