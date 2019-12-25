package orangetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VacanciesPage {

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    private WebElement menuRecruitment;

    @FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
    private WebElement viewJobVacancy;

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement btnAdd;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement btnSave;

    @FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
    private WebElement jobTitle;

    @FindBy(xpath = "//input[@id='addJobVacancy_name']")
    private WebElement vacancyName;

    @FindBy(xpath = "//input[@id='addJobVacancy_hiringManager']")
    private WebElement hiringManager;

    @FindBy(xpath = "//input[@id='addJobVacancy_noOfPositions']")
    private WebElement numberOfPositions;

    @FindBy(xpath = "//table[@id='resultTable']//tbody")
    private WebElement resultTable;

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

    public boolean isVacancyAdded(String vacancy, String manager) {
        viewJobVacancy.click();
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        return tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(vacancy) &&
                        o.contains(manager));
    }
}
