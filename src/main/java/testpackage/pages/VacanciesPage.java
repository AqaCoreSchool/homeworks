package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testpackage.base.BasePage;

import java.util.List;

public class VacanciesPage extends BasePage {

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement btnAdd;

    @FindBy (xpath = "//select[@id='addJobVacancy_jobTitle']")
    private WebElement btnSelectVacancy;

    @FindBy (xpath = "//option[contains(text(),'AQA')]")
    private WebElement selectAQA;

    @FindBy (xpath = "//input[@id='addJobVacancy_name']")
    private WebElement inputVacancyName;

    @FindBy (xpath = "//input[@id='addJobVacancy_hiringManager']")
    private WebElement inputHiringManager;

    @FindBy (xpath = "//input[@id='btnSave']")
    private WebElement btnSave;

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> tableVacancies;

    @FindBy (xpath = "//select[@id='vacancySearch_jobTitle']")
    private WebElement jobTitleDropDown;

    @FindBy (xpath = "//select[@id='vacancySearch_jobVacancy']")
    private WebElement vacancyDropDown;

    @FindBy (xpath = "//select[@id='vacancySearch_hiringManager']")
    private WebElement hiringManagerDropDown;

    @FindBy (xpath = "//select[@id='vacancySearch_status']")
    private WebElement statusDropDown;

    @FindBy(xpath = "//input[@id='btnSrch']")
    private WebElement btnSearch;

    public VacanciesPage clickAddVacancy(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        return this;
    }

    public  VacanciesPage inputHiringManager(String hiringManager){
        inputHiringManager.sendKeys(hiringManager);
        return this;
    }

    public VacanciesPage inputVacancyName(String vacancy){
        inputVacancyName.sendKeys(vacancy);
        return this;
    }

    public VacanciesPage selectJobTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSelectVacancy));
        btnSelectVacancy.click();
        selectAQA.click();
        return this;
    }

    public VacanciesPage clickSaveVacancy(){
        btnSave.click();
        return this;
    }

    public VacanciesPage  moveToVacancies(){
        new MainPage().moveToRecruitment()
                .moveToVacancies();
        return this;
    }

    public boolean filterVacancies(String jobTitle, String vacancy,String managerHiring, String  status){
        boolean vacancies = tableVacancies.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(jobTitle)
                        &e.contains(vacancy)
                        &e.contains(managerHiring)
                        &e.contains(status));
        return vacancies;
    }
}
