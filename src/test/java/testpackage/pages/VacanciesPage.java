package testpackage.pages;

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

    public VacanciesPage createVacancy(Vacancy vacancy){
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
        btnAdd.click();
        inputHiringManager.sendKeys(vacancy.getHiringManager());
        inputVacancyName.sendKeys(vacancy.getVacancy());
        wait.until(ExpectedConditions.elementToBeClickable(btnSelectVacancy));
        btnSelectVacancy.click();
        selectAQA.click();
        btnSave.click();
        return this;
    }

    public boolean filterVacancies(Vacancy vacancy){
        boolean vacancies = tableVacancies.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(vacancy.getJobTitle())
                        &e.contains(vacancy.getVacancy())
                        &e.contains(vacancy.getHiringManager())
                        &e.contains(vacancy.getStatus()));
        return vacancies;
    }
}
