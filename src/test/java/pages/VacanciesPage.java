package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.util.List;
import java.util.NoSuchElementException;

public class VacanciesPage extends MainPage {

    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy (id = "addJobVacancy_jobTitle")
    private WebElement clickJobTittle;

    @FindBy (xpath = "//option[contains(text(),'AQA')]")
    private WebElement selectJobTittle;

    @FindBy (id = "addJobVacancy_name")
    private WebElement inputVacancyName;

    @FindBy (id = "addJobVacancy_hiringManager")
    private WebElement inputHiringManager;

    @FindBy(id = "addJobVacancy_status")
    private WebElement status;

    @FindBy(id = "addJobVacancy_publishedInFeed")
    private WebElement publishedInFeed;

    @FindBy (id = "btnSave")
    private WebElement btnSave;

    @FindBy(id = "btnBack")
    private WebElement btnBack;

    @FindBy(tagName = "tr")
    private List<WebElement> vacanciesList;

    @FindBy(xpath = "//span[contains(text(),'Already exists')]")
    private WebElement vacancyExistError;

    @FindBy(xpath = "//span[contains(text(),'Invalid')]")
    private WebElement invalidManagerInput;

    @FindBy (xpath = "//form[@id='frmAddJobVacancy']//fieldset//ol")
    private WebElement titleNotSelected;


    public VacanciesPage clickAddBtn(){
        Utils.waitAndClick(btnAdd);
        return this;
    }

    public VacanciesPage selectJobTittle(){
        Utils.waitAndClick(clickJobTittle);
        Utils.waitAndClick(selectJobTittle);
        return this;
    }

    public VacanciesPage vacancyNameInput(String vacancy){
        Utils.waitAndSendKeys(inputVacancyName, vacancy);
        return this;
    }

    public VacanciesPage hiringManagerInput(String manager){
        Utils.waitAndSendKeys(inputHiringManager, manager);
        return this;
    }

    public VacanciesPage selectStatus() {
        if (!status.isSelected()) {
            Utils.waitAndClick(status);
        }
        return this;
    }

    public VacanciesPage selectPublishedInFeed() {
        if (!publishedInFeed.isSelected()) {
            Utils.waitAndClick(publishedInFeed);
        }
        return this;
    }

    public VacanciesPage clickSaveBtn(){
        Utils.waitAndClick(btnSave);
        return  this;

    }
    public VacanciesPage clickBackBtn(){
        Utils.waitAndClick(btnBack);
        return this;
    }

    @Step
    public VacanciesPage addNewVacancy(String vacancy, String manager){
        clickAddBtn();
        selectJobTittle();
        vacancyNameInput(vacancy);
        hiringManagerInput(manager);
        selectStatus();
        selectPublishedInFeed();
        clickSaveBtn();
        clickBackBtn();
        return this;
    }

    @Step
    public VacanciesPage addVacancyForNegativeTest(String vacancy, String manager){
        clickAddBtn();
        vacancyNameInput(vacancy);
        hiringManagerInput(manager);
        clickSaveBtn();
        return this;
    }

    @Step
    public String findVacancies(String vacancy, String jobTitle, String manager, String  status){
        return vacanciesList.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(vacancy))
                .filter(s -> s.contains(jobTitle))
                .filter(s -> s.contains(manager))
                .filter(s -> s.contains(status))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    @Step
    public boolean isTitleNotSelectedErrorDisplayed(){
        try {
            return titleNotSelected.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    @Step
    public boolean isVacancyExistsErrorDisplayed(){
        try {
            return vacancyExistError.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    @Step
    public boolean isManagerInputErrorDisplayed(){
        try {
            return invalidManagerInput.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
                return false;
        }
    }

}
