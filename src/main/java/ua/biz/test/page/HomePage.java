package ua.biz.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.biz.test.util.LocalDriver;

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
        PageFactory.initElements(LocalDriver.getDriver(), this);
        wait = new WebDriverWait(LocalDriver.getDriver(), 30);
    }

    public RecruitmentPage selectRecruitment() {
        wait.until(ExpectedConditions.visibilityOf(recruitmentOption));
        recruitmentOption.click();
        return new RecruitmentPage();
    }
}
