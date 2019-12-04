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

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isOpened() {
        return welcomeLabel.isDisplayed();
    }

    public void selectMyInfo() {
        myInfoOption.click();
    }

    public void selectPim() {
        pimOption.click();
    }

    public void selectRecruitment() {
        recruitmentOption.click();
    }
}
