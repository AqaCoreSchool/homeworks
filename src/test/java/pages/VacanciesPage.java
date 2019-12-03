package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utilities;

import java.util.List;
import java.util.NoSuchElementException;

public class VacanciesPage extends BasePage{


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

    @FindBy (id = "btnSave")
    private WebElement btnSave;

    @FindBy(id = "btnBack")
    private WebElement btnBack;

    @FindBy(tagName = "tr")
    private List<WebElement> vacanciesList;


    public VacanciesPage clickAddBtn(){
        Utilities.waitAndClick(btnAdd);
        return this;
    }

    public VacanciesPage selectJobTittle(){
        clickJobTittle.click();
        selectJobTittle.click();
        return this;
    }

    public VacanciesPage vacancyNameInput(String vacancy){
        Utilities.waitAndSendKeys(inputVacancyName, vacancy);
        return this;
    }

    public VacanciesPage hiringManagerInput(String manager){
        Utilities.waitAndSendKeys(inputHiringManager, manager);
        return this;
    }

    public VacanciesPage clickSaveBtn(){
        Utilities.waitAndClick(btnSave);
        return  this;

    }
    public VacanciesPage clickBackBtn(){
        Utilities.waitAndClick(btnBack);
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
