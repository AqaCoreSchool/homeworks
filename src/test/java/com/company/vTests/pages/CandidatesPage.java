package com.company.vTests.pages;

import com.company.vTests.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidatesPage extends BasePage {

    @FindBy(id = "btnAdd")
    private WebElement addCandidateButton;

    @FindBy(id = "addCandidate_firstName")
    private WebElement firstNameOfCandidate;

    @FindBy(id = "addCandidate_lastName")
    private WebElement lastNameOfCandidate;

    @FindBy(id = "addCandidate_email")
    private WebElement emailOfCandidate;

    @FindBy(id = "btnSave")
    private WebElement saveBtn;

    @FindBy(xpath = ".//form[@id='frmAddCandidate']/fieldset/ol")
    private WebElement requiredDataOfCandidate;

    public CandidatesPage clickAddCandidate(){
        addCandidateButton.click();
        return new CandidatesPage();
    }

    public CandidatesPage inputCandidateData(){
        firstNameOfCandidate.click();
        firstNameOfCandidate.sendKeys("O");
        lastNameOfCandidate.click();
        lastNameOfCandidate.sendKeys("B");
        emailOfCandidate.click();
        emailOfCandidate.sendKeys("bimf@gmail.com");
        return this;
    }

    public CandidatesPage clickSaveBtn(){
        saveBtn.click();
        return this;
    }
    @Step("Empty CANDIDATES")
    public boolean verifyEmptyCandidates(){
        return requiredDataOfCandidate.getText().contains("Required");
    }

}
