package ua.testbiz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//a[@id='welcome']")
    private WebElement welcomeLabel;

    @FindBy(xpath = "//a[@id='menu_pim_viewMyDetails']")
    private WebElement myInfoOption;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    private WebElement pimOption;

    @FindBy(xpath = "//a[@id='menu_recruitment_viewRecruitmentModule']")
    private WebElement recruitmentOption;

    private WebDriver webDriver;

    public HomePage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public PersonalDetailsPage selectMyInfo() {
        myInfoOption.click();
        return new PersonalDetailsPage(webDriver);
    }

    public EmployeeListPage selectPim() {
        pimOption.click();
        return new EmployeeListPage(webDriver);
    }

    public RecruitmentPage selectRecruitment() {
        recruitmentOption.click();
        return new RecruitmentPage(webDriver);
    }
}
