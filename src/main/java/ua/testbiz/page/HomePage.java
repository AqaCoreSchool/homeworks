package ua.testbiz.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    private WebDriverWait wait;

    public HomePage() {
        PageFactory.initElements(Application.getDriver(), this);
        wait = new WebDriverWait(Application.getDriver(),30);
    }

    public boolean isOpened() {
        return welcomeLabel.isDisplayed();
    }

    public PersonalDetailsPage selectMyInfo() {
        wait.until(ExpectedConditions.visibilityOf(myInfoOption));
        myInfoOption.click();
        return new PersonalDetailsPage();
    }

    public EmployeeListPage selectPim() {
        wait.until(ExpectedConditions.visibilityOf(pimOption));
        pimOption.click();
        return new EmployeeListPage();
    }

    public RecruitmentPage selectRecruitment() {
        wait.until(ExpectedConditions.visibilityOf(recruitmentOption));
        recruitmentOption.click();
        return new RecruitmentPage();
    }

    public LocationPage selectAdmin() {
        wait.until(ExpectedConditions.visibilityOf(adminOption));
        adminOption.click();
        return new LocationPage();
    }
}
