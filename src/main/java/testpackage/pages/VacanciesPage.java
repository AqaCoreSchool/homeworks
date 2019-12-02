package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testpackage.base.BasePage;

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
