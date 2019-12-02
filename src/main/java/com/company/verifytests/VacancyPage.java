package com.company.verifytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VacancyPage {
    private WebDriver driver;

    @FindBy(xpath ="//select[@id='vacancySearch_jobTitle']//option[contains(text(),'AQA')]")
    private WebElement jobTitleOfVacancySearch;

    @FindBy(xpath ="//input[@id='btnSrch']")
    private WebElement searchBtnOfVacancy;

    @FindBy(xpath ="//input[@id='btnAdd']")
    private WebElement addVacancyBtn;

    @FindBy(xpath ="//option[contains(text(),'AQA')]")
    private WebElement jobTitleOfVacancy;

    @FindBy(xpath ="//input[@id='addJobVacancy_name']")
    private WebElement vacancyName;

    @FindBy(xpath ="//input[@id='addJobVacancy_hiringManager']")
    private WebElement hiringManagerName;

    @FindBy(xpath ="//input[@id='addJobVacancy_noOfPositions']")
    private WebElement numberOfPositions;

    @FindBy(xpath ="//input[@id='btnSave']")
    private WebElement saveBtn;

    @FindBy(xpath ="//input[@id='btnBack']")
    private WebElement backBtn;

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> tableWithVacancies;

    public VacancyPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public VacancyPage chooseJobTitleOfVacancy(){
        jobTitleOfVacancySearch.click();
        return this;
    }

    public VacancyPage clickSearchBtn(){
        searchBtnOfVacancy.click();
        return this;
    }

    public VacancyPage addVacancy(){
        addVacancyBtn.click();
        return this;
    }

    public VacancyPage chooseJobTitle(){
        jobTitleOfVacancy.click();
        return this;
    }

    public VacancyPage inputVacancyName(String email){
        vacancyName.click();
        vacancyName.sendKeys(email);
        return this;
    }

    public VacancyPage inputHiringManagerName(String nameOfHR){
        hiringManagerName.click();
        hiringManagerName.sendKeys(nameOfHR);
        return this;
    }

    public VacancyPage inputNumberOfPositions(String positionsNo){
        numberOfPositions.click();
        numberOfPositions.sendKeys(positionsNo);
        return this;
    }

    public VacancyPage clickSaveBtn(){
        saveBtn.click();
        return this;
    }

    public VacancyPage clickBackBtn(){
        backBtn.click();
        return this;
    }

    public boolean verifyVacancy(String jobTitle, String hiringManagerName){
        boolean vacancies = tableWithVacancies.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(jobTitle)
                        &e.contains(hiringManagerName));
        return vacancies;
    }

}
