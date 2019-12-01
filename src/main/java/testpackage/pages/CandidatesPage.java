package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testpackage.base.BasePage;

import java.util.List;

public class CandidatesPage {

    private WebDriverWait wait;

    @FindBy (xpath = "//input[@id='btnAdd']")
    private WebElement btnAdd;

    @FindBy (xpath = "//input[@id='addCandidate_firstName']")
    private WebElement firstNameInput;

    @FindBy (xpath = "//input[@id='addCandidate_middleName']")
    private WebElement middleNameInput;

    @FindBy (xpath = "//input[@id='addCandidate_lastName']")
    private WebElement lastNameInput;

    @FindBy (xpath = "//input[@id='addCandidate_email']")
    private WebElement emailInput;

    @FindBy (xpath = " //input[@id='addCandidate_contactNo']")
    private WebElement phoneNumberInput;

    @FindBy (xpath = "//select[@id='addCandidate_vacancy']")
    private WebElement btnSelectVacancy;

    @FindBy (xpath = "//option[contains(text(),'AQA Junior')]")
    private WebElement selectAQAJunior;

    @FindBy (xpath = "//input[@id='addCandidate_resume']")
    private WebElement resumeInput;

    @FindBy (xpath = "//input[@id='addCandidate_consentToKeepData']")
    private WebElement consentToKeepData;

    @FindBy (xpath = "//input[@id='btnSave']")
    private WebElement btnSave;

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> tableCandidates;

    public CandidatesPage() {
        PageFactory.initElements(BasePage.getInstance().getDriver(), this);
        wait = new WebDriverWait(BasePage.getInstance().getDriver(), 10);
    }

    public CandidatesPage clickAddCandidate(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        return this;
    }

    public  CandidatesPage inputFullName(String firstName, String secondName, String lastName){
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        firstNameInput.sendKeys(firstName);
        middleNameInput.sendKeys(secondName);
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public  CandidatesPage inputEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public  CandidatesPage inputPhoneNumber(String phoneNumber){
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public CandidatesPage selectAQAJunior(){
        btnSelectVacancy.click();
        selectAQAJunior.click();
        return this;
    }

    public CandidatesPage inputResume(String file){
        resumeInput.sendKeys(file);
        return this;
    }

    public CandidatesPage clickConsentAndSave(){
        consentToKeepData.click();
        btnSave.click();
        return this;
    }

    public CandidatesPage  moveToCandidates(){
        new MainPage().moveToRecruitment()
                .moveToCandidates();
        return this;
    }

    public boolean filterCandidates(String firstName, String middleName, String lastName, String vacancy,String date){
        boolean candidate = tableCandidates.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(firstName)
                        &e.contains(middleName)
                        &e.contains(lastName)
                        &e.contains(vacancy)
                        &e.contains(date));
        return candidate;
    }
}
