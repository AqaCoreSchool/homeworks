package orangetest.pages;

import orangetest.data.Vacancy;
import orangetest.utils.JsonConverter;
import orangetest.utils.Utils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class VacanciesPage extends BasePage {

    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement btnAdd;

    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement btnSave;

    @FindBy(id="btnSrch")
    WebElement btnSrch;

    @FindBy(id="vacancySearch_jobVacancy")
    WebElement search_jobVacancy;

    @FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
    WebElement jobTitle;

    @FindBy(xpath = "//input[@id='addJobVacancy_name']")
    WebElement vacancyName;

    @FindBy(xpath = "//input[@id='addJobVacancy_hiringManager']")
    WebElement hiringManager;

    @FindBy(xpath = "//input[@id='addJobVacancy_noOfPositions']")
    WebElement numberOfPositions;

    @FindBy(xpath = "//table[@id='resultTable']//tbody")
    WebElement resultTable;

    @FindBy(css = "div.box:nth-child(1) div.inner form:nth-child(1) fieldset:nth-child(3) ol:nth-child(1) li:nth-child(1) > span.validation-error:nth-child(3)")
    WebElement errorJobTitle;

    @FindBy(css = "div.box:nth-child(1) div.inner form:nth-child(1) fieldset:nth-child(3) ol:nth-child(1) li:nth-child(2) > span.validation-error:nth-child(3)")
    WebElement errorVacancyName;

    @FindBy(css = "div.box:nth-child(1) div.inner form:nth-child(1) fieldset:nth-child(3) ol:nth-child(1) li:nth-child(3) > span.validation-error:nth-child(3)")
    WebElement errorHiringManager;

    public VacanciesPage() {
        super();
    }

    public VacanciesPage addVacancy(String name, String manager, String position) {
        menuRecruitment.click();
        viewJobVacancy.click();
        btnAdd.click();
        Utils.waitUntilIsClickable(jobTitle);
        jobTitle.click();
        jobTitle.findElement(By.xpath("//option[contains(text(),'AQA')]")).click();
        vacancyName.sendKeys(name);
        hiringManager.sendKeys(manager);
        numberOfPositions.sendKeys(position);
        btnSave.click();
        return this;
    }

    public boolean addEmptyVacancy() {
        menuRecruitment.click();
        viewJobVacancy.click();
        btnAdd.click();
        Utils.waitUntilIsClickable(btnSave);
        btnSave.click();
        try {
            errorJobTitle.isEnabled();
            errorVacancyName.isEnabled();
            errorHiringManager.isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Error messages is not displaying correctly");
            return false;
        }
    }

    public boolean isVacancyAdded(String name, String manager) {
        viewJobVacancy.click();
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        return tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(name) &&
                        o.contains(manager));
    }

    public boolean isHiringManagerPresent(String vacancyName, String hiringManager) {
        menuRecruitment.click();
        viewJobVacancy.click();
        Select drpVacancy = new Select(search_jobVacancy);
        drpVacancy.selectByVisibleText(vacancyName);
        btnSrch.click();
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        return tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(hiringManager));
    }

    public boolean checkFromJSON() {
        JsonConverter converter = new JsonConverter();
        JSONObject vacancyJson = converter.convertObjectToJson(vacancy);
        Vacancy vacancyObjFromJson = (Vacancy) converter.convertJsonToObject(vacancyJson.toString(), Vacancy.class);
        return vacancy.equals(vacancyObjFromJson);
    }
}
