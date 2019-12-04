package pages;

import data.VacancyInfo;
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

    public VacanciesPage addNewVacancy(){
        clickAddBtn();
        selectJobTittle();
        vacancyNameInput(VacancyInfo.VACANCY);
        hiringManagerInput(VacancyInfo.HIRING_MANAGER);
        selectStatus();
        selectPublishedInFeed();
        clickSaveBtn();
        clickBackBtn();
        return this;
    }

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

}
