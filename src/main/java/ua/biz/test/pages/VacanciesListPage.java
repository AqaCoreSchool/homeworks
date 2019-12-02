package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacanciesListPage {

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement addVacancyButton;

    public VacanciesListPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public CreateVacancyPage addNewVacancy(WebDriver driver){
    addVacancyButton.click();
        return new CreateVacancyPage(driver);
    }
}
