package com.company.verifytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CandidatesPage {
    public WebDriver driver;

    @FindBy(xpath ="//select[@id='candidateSearch_jobTitle']//option[contains(text(),'AQA')]")
    private WebElement jobTitleCandidates;

    @FindBy(xpath ="//input[@id='btnAdd']")
    private WebElement addCandidateButton;

    @FindBy(xpath ="//input[@id='btnSrch']")
    private WebElement searchCandidateButton;

    @FindBy(xpath ="//input[@id='addCandidate_firstName']")
    private WebElement firstNameOfCandidate;

    @FindBy(xpath ="//input[@id='addCandidate_lastName']")
    private WebElement lastNameOfCandidate;

    @FindBy(xpath ="//input[@id='addCandidate_email']")
    private WebElement emailOfCandidate;

    @FindBy(xpath ="//input[@id='addCandidate_contactNo']")
    private WebElement contactNo;

    @FindBy(xpath ="//option[contains(text(),'AQA Lead')]")
    private WebElement jobVacancy;

    @FindBy(xpath ="//input[@id='btnSave']")
    private WebElement saveBtn;

    @FindBy(xpath ="//input[@id='btnBack']")
    private WebElement backBtn;

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> tableWithCandidates;

    public CandidatesPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public CandidatesPage chooseJobTitle(){
        jobTitleCandidates.click();
        return new CandidatesPage(driver);
    }

    public CandidatesPage clickAddCandidate(){
        addCandidateButton.click();
        return new CandidatesPage(driver);
    }

    public CandidatesPage searchCandidates(){
        searchCandidateButton.click();
        return new CandidatesPage(driver);
    }

    public CandidatesPage inputFirstName(String firstName){
        firstNameOfCandidate.click();
        firstNameOfCandidate.sendKeys(firstName);
        return new CandidatesPage(driver);
    }

    public CandidatesPage inputLastName(String lastName){
        lastNameOfCandidate.click();
        lastNameOfCandidate.sendKeys(lastName);
        return new CandidatesPage(driver);
    }

    public CandidatesPage inputEmail(String email){
        emailOfCandidate.click();
        emailOfCandidate.sendKeys(email);
        return new CandidatesPage(driver);
    }

    public CandidatesPage inputContactNo(String phoneNo){
        contactNo.click();
        contactNo.sendKeys(phoneNo);
        return new CandidatesPage(driver);
    }

    public CandidatesPage chooseJobVacancy(){
        jobVacancy.click();
        return new CandidatesPage(driver);
    }

    public CandidatesPage clickSaveBtn(){
        saveBtn.click();
        return new CandidatesPage(driver);
    }

    public CandidatesPage clickBackBtn(){
        backBtn.click();
        return new CandidatesPage(driver);
    }

    public boolean verifyCandidates(String fullName, String date){
        boolean candidates = tableWithCandidates.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(fullName)
                        &e.contains(date));
        return candidates;
    }

}
