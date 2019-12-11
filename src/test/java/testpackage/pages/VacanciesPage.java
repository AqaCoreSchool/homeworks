package testpackage.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testpackage.base.BasePage;
import testpackage.entity.Vacancy;

import java.util.List;

public class VacanciesPage extends BasePage {

    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy (id = "addJobVacancy_jobTitle")
    private WebElement btnSelectVacancy;

    @FindBy (xpath = "//option[contains(text(),'AQA')]")
    private WebElement selectAQA;

    @FindBy (id = "addJobVacancy_name")
    private WebElement inputVacancyName;

    @FindBy (id = "addJobVacancy_hiringManager")
    private WebElement inputHiringManager;

    @FindBy (id = "btnSave")
    private WebElement btnSave;

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> tableVacancies;

    @FindBy(xpath = "//span[contains(text(),'Already exists')]")
    private WebElement vacancyExistError;

    @FindBy(xpath = "//span[contains(text(),'Invalid')]")
    private WebElement invalidManagerInput;

    @FindBy (xpath = "//form[@id='frmAddJobVacancy']//fieldset//ol")
    private WebElement titleNotSelected;

    @Step
    public VacanciesPage createVacancy(Vacancy vacancy){
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        inputHiringManager.sendKeys(vacancy.getHiringManagerID());
        inputVacancyName.sendKeys(vacancy.getVacancy());
        wait.until(ExpectedConditions.elementToBeClickable(btnSelectVacancy));
        btnSelectVacancy.click();
        selectAQA.click();
        btnSave.click();
        return this;
    }

    @Step
    public boolean filterVacancies(Vacancy vacancy){
        boolean vacancies = tableVacancies.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(vacancy.getJobTitle())
                        &e.contains(vacancy.getHiringManagerID()));
        return vacancies;
    }

    @Step
    public VacanciesPage addVacancyForNegativeTest(String vacancy, String manager){
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        inputHiringManager.sendKeys(manager);
        inputVacancyName.sendKeys(vacancy);
        btnSave.click();
        return this;
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
    @Step
    public boolean filterVacancies(String jobTitle, String hiringManagerID){
        boolean vacancies = tableVacancies.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(jobTitle)
                        &e.contains(hiringManagerID));
        return vacancies;
    }
}
