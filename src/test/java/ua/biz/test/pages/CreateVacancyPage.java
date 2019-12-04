package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import ua.biz.test.driver.DriverManager;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.Vacancy;

public class CreateVacancyPage extends BasePage {

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
    @FindBy(xpath="//span[contains(text(),'Already exists')]")
    private WebElement incorectVacancyNameMessage;
    @FindBy(xpath="//span[contains(text(),'Required')]")
    private WebElement incorectJobSelectMessage;
    @FindBy(xpath="//span[contains(text(),'Invalid')]")
    private WebElement invalidManagerNameMessage;

    public CreateVacancyPage() {
        super();
    }

    public void createNewVacancy(Vacancy vacancy) {
        WaitUtil.waitAndType(vacancyNameField,vacancy.getName());
        Select select = new Select(jobTitle);
        select.selectByValue("1");
        hiringManagerField.sendKeys(vacancy.getHiringManagerName());
        numberOfPositionField.sendKeys(String.valueOf(vacancy.getNubmerOfPositions()));
        if (!vacancy.isActive()) {
            isActiveCheckBox.click();
        }
        saveVacancyButton.click();
    }

    public VacanciesListPage backToVacanciesPage() {
WaitUtil.waitAndClick( backToVacancyListPageButton);
        return new VacanciesListPage();
    }

    public boolean isIncorrectVacancyNameMessageVisible(){
        return  incorectVacancyNameMessage.isDisplayed();
    }
}

