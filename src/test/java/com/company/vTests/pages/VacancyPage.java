package com.company.vTests.pages;

import com.company.vTests.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacancyPage extends BasePage {

    @FindBy(xpath ="//select[@id='vacancySearch_jobTitle']//option[contains(text(),'AQA')]")
    private WebElement jobTitleOfVacancySearch;

    @FindBy(id="btnSrch")
    private WebElement searchBtnOfVacancy;

    @FindBy(id ="btnAdd")
    private WebElement addVacancyBtn;

    @FindBy(xpath ="//option[contains(text(),'AQA')]")
    private WebElement jobTitleOfVacancy;

    @FindBy(id="addJobVacancy_name")
    private WebElement vacancyName;

    @FindBy(id="addJobVacancy_hiringManager")
    private WebElement hiringManagerName;

    @FindBy(id="btnSave")
    private WebElement saveBtn;

    @FindBy (xpath = "//form[@id='frmAddJobVacancy']//fieldset//ol")
    private WebElement requiredDataOfVacancy;

    public VacancyPage chooseJobTitleOfVacancy(){
        jobTitleOfVacancySearch.click();
        return this;
    }

    public VacancyPage clickSearchBtn(){
        searchBtnOfVacancy.click();
        System.out.println("search");
        return this;
    }

    public VacancyPage addVacancy(){
        addVacancyBtn.click();
        System.out.println("add");
        return this;
    }
 public VacancyPage inputVacancyData(String email, String newName){
        jobTitleOfVacancy.click();
        vacancyName.click();
        vacancyName.sendKeys(email);
        hiringManagerName.click();
        hiringManagerName.sendKeys(newName);
        return this;
    }

    public VacancyPage clickSaveBtn(){
        saveBtn.click();
        return this;
    }

    public boolean verifyEmptyVacancy(){
        return requiredDataOfVacancy.getText().contains("Required") && requiredDataOfVacancy.getText().contains("Invalid");
    }

}
