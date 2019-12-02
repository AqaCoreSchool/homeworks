package orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeDashboardPage {
    private final WebDriver driver;

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminModule;

    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement timeModule;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    private WebElement recruitmentModule;

    @FindBy(id = "menu_pim_viewMyDetails")
    private WebElement myInfoModule;

    public OrangeDashboardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrangeAdminPage toAdminModulePage(){
        adminModule.click();
        return new OrangeAdminPage(driver);
    }

    public OrangeTimePage toTimeModulePage(){
        timeModule.click();
        return new OrangeTimePage(driver);
    }

    public OrangeRecruitmentPage toRecruitmentModulePage(){
        recruitmentModule.click();
        return new OrangeRecruitmentPage(driver);
    }

    public OrangeMyInfoPage toMyInfoPage(){
        myInfoModule.click();
        return new OrangeMyInfoPage(driver);
    }
}
