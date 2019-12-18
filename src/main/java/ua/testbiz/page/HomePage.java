package ua.testbiz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Application;

public class HomePage {
    @FindBy(xpath = "//a[@id='welcome']")
    private WebElement welcomeLabel;

    @FindBy(xpath = "//a[@id='menu_pim_viewMyDetails']")
    private WebElement myInfoOption;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    private WebElement pimOption;

    @FindBy(xpath = "//a[@id='menu_recruitment_viewRecruitmentModule']")
    private WebElement recruitmentOption;

    @FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
    private WebElement adminOption;

    @FindBy(xpath = "//a[@id='menu_admin_viewLocations']")
    private WebElement locationSubMenu;

    public HomePage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public boolean isOpened() {
        return welcomeLabel.isDisplayed();
    }

    public PersonalDetailsPage selectMyInfo() {
        myInfoOption.click();
        return new PersonalDetailsPage();
    }

    public EmployeeListPage selectPim() {
        pimOption.click();

        return new EmployeeListPage();
    }

    public RecruitmentPage selectRecruitment() {
        recruitmentOption.click();

        return new RecruitmentPage();
    }

    public LocationPage selectAdmin(){
        adminOption.click();

        return new LocationPage();
    }
}
