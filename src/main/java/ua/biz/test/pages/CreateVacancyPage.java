package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ua.biz.test.entity.Vacancy;

public class CreateVacancyPage {

    @FindBy(xpath = "//input[@id='addJobVacancy_name']")
    private WebElement vacancyNameField;
    @FindBy(xpath = "//input[@id='addJobVacancy_hiringManager']")
    private WebElement hiringManagerField;
    @FindBy(xpath = "//input[@id='addJobVacancy_noOfPositions']")
    private WebElement numberOfPositionField;
    @FindBy(xpath = "//input[@id='addJobVacancy_status']")
    private WebElement isActiveCheckBox;
    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveVacancyButton;
    @FindBy(xpath = "//input[@id='btnBack']")
    private WebElement backToVacancyListPageButton;
    @FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
    private WebElement jobTitle;

    public CreateVacancyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createNewVacancy(Vacancy vacancy) {
        Select select = new Select(jobTitle);
        select.selectByValue("1");

        vacancyNameField.sendKeys(vacancy.getName());
        hiringManagerField.sendKeys(vacancy.getHiringManagerName());
        numberOfPositionField.sendKeys(String.valueOf(vacancy.getNubmerOfPositions()));
        if (!vacancy.isActive()) {
            isActiveCheckBox.click();
        }
        saveVacancyButton.click();
    }

    public VacanciesListPage backToVacanciesPage(WebDriver driver) {
        backToVacancyListPageButton.click();
        return new VacanciesListPage(driver);
    }
}

