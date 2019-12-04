package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;


public class BasePage {
    private WebDriverWait menuWait = new WebDriverWait(WebDriverFactory.getDriver(), 10);

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminModule;

    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement timeModule;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    private WebElement recruitmentModule;

    @FindBy(id = "menu_pim_viewMyDetails")
    private WebElement myInfoModule;

    public BasePage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    public OrangeAdminPage toAdminModulePage(){
        menuWait.until(ExpectedConditions.visibilityOf(adminModule));
        adminModule.click();
        return new OrangeAdminPage();
    }

    public OrangeTimePage toTimeModulePage(){
        menuWait.until(ExpectedConditions.visibilityOf(timeModule));
        timeModule.click();
        return new OrangeTimePage();
    }

    public OrangeRecruitmentPage toRecruitmentModulePage(){
        menuWait.until(ExpectedConditions.visibilityOf(recruitmentModule));
        recruitmentModule.click();
        return new OrangeRecruitmentPage();
    }

    public OrangeMyInfoPage toMyInfoPage(){
        menuWait.until(ExpectedConditions.visibilityOf(myInfoModule));
        myInfoModule.click();
        return new OrangeMyInfoPage();
    }
}
