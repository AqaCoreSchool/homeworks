package pageobject.logic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class VacanciesPage {

    private WebDriverWait wait;

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

    public VacanciesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public VacanciesPage clickAddBtn(){
        btnAdd.click();
        return this;
    }

    public VacanciesPage selectJobTittle(String title){
        clickJobTittle.click();
        selectJobTittle.click();
        return this;
    }

    public VacanciesPage vacancyNameInput(String vacancy){
        inputVacancyName.sendKeys(vacancy);
        return this;
    }

    public VacanciesPage hiringManagerInput(String manager){
        inputHiringManager.sendKeys(manager, Keys.ENTER);
        return this;
    }

    public VacanciesPage clickSaveBtn(){
        btnSave.click();
        return  this;

    }
    public VacanciesPage clickBackBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(btnBack));
        btnBack.click();
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
