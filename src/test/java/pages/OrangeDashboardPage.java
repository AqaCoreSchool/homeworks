package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;
import utils.WebDriverFactory;

public class OrangeDashboardPage extends BasePage{
    Waits wait = new Waits(WebDriverFactory.getDriver());

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminModule;

    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement timeModule;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    private WebElement recruitmentModule;

    @FindBy(id = "menu_pim_viewMyDetails")
    private WebElement myInfoModule;

    public OrangeAdminPage toAdminModulePage(){
        wait.waitForVisibility(adminModule);
        adminModule.click();
        return new OrangeAdminPage();
    }

    public OrangeTimePage toTimeModulePage(){
        wait.waitForVisibility(timeModule);
        timeModule.click();
        return new OrangeTimePage();
    }

    public OrangeRecruitmentPage toRecruitmentModulePage(){
        wait.waitForVisibility(recruitmentModule);
        recruitmentModule.click();
        return new OrangeRecruitmentPage();
    }

    public OrangeMyInfoPage toMyInfoPage(){
        wait.waitForVisibility(myInfoModule);
        myInfoModule.click();
        return new OrangeMyInfoPage();
    }
}
