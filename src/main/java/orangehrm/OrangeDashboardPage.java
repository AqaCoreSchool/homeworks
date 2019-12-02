package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebDriverWait menuWait = new WebDriverWait(driver, 10);
        menuWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_admin_viewAdminModule")));
        adminModule.click();
        return new OrangeAdminPage(driver);
    }

    public OrangeTimePage toTimeModulePage(){
        WebDriverWait menuWait = new WebDriverWait(driver, 10);
        menuWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_time_viewTimeModule")));
        timeModule.click();
        return new OrangeTimePage(driver);
    }

    public OrangeRecruitmentPage toRecruitmentModulePage(){
        WebDriverWait menuWait = new WebDriverWait(driver, 10);
        menuWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_recruitment_viewRecruitmentModule")));
        recruitmentModule.click();
        return new OrangeRecruitmentPage(driver);
    }

    public OrangeMyInfoPage toMyInfoPage(){
        WebDriverWait menuWait = new WebDriverWait(driver, 10);
        menuWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewMyDetails")));
        myInfoModule.click();
        return new OrangeMyInfoPage(driver);
    }
}
