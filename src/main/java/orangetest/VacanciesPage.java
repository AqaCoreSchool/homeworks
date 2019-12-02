package orangetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VacanciesPage {

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    WebElement menuRecruitment;

    @FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
    WebElement viewJobVacancy;

    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement btnAdd;

    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement btnSave;

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

    public VacanciesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addVacancy(String vacancy, String manager) {
        menuRecruitment.click();
        viewJobVacancy.click();
        btnAdd.click();
        jobTitle.click();
        jobTitle.findElement(By.xpath("//option[contains(text(),'AQA')]")).click();
        vacancyName.sendKeys(vacancy);
        hiringManager.sendKeys(manager);
        numberOfPositions.sendKeys("2");
        btnSave.click();
    }

    public boolean checkAddedVacancy(String vacancy, String manager) {
        viewJobVacancy.click();
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        boolean stringSearch = tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(vacancy) &&
                        o.contains(manager));
        return stringSearch;
    }
}
