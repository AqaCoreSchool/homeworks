package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.NoSuchElementException;

public class CandidatesPage{

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

    public CandidatesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public CandidatesPage clickAddCandidate(){
        btnAdd.click();
        return this;
    }

    public  CandidatesPage fullNameInput(String firstName, String lastName){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public  CandidatesPage emailInput(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public  CandidatesPage phoneNumberInput(String phoneNumber){
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public CandidatesPage selectJobVacancy(){
        selectAQAJuniorVacancy.click();
        return this;
    }


    public CandidatesPage clickConsentAndSave(){
        consentToKeepData.click();
        btnSave.click();
        return this;
    }

    public CandidatesPage clickBackBtn(){
        btnBack.click();
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
