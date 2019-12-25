package orangetest.pages;

import orangetest.utils.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement adminMenu;
    @FindBy(id = "menu_admin_Organization")
    WebElement organization;
    @FindBy(id = "menu_admin_viewLocations")
    WebElement viewLocations;

    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    WebElement pimMenuItem;
    @FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
    WebElement viewEmployeeList;

    @FindBy(xpath = "//b[contains(text(),'Time')]")
    WebElement timeMenu;
    @FindBy(xpath = "//a[@id='menu_attendance_Attendance']")
    WebElement attendance;
    @FindBy(linkText = ("Punch In/Out"))
    WebElement punchInOut;
    @FindBy(xpath = "//a[@id='menu_attendance_viewMyAttendanceRecord']")
    WebElement viewMyAttendanceRecord;

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    WebElement menuRecruitment;
    @FindBy(xpath = "//a[@id='menu_recruitment_viewCandidates']")
    WebElement viewCandidates;
    @FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
    WebElement viewJobVacancy;


    public BasePage() {
        PageFactory.initElements(Application.getDriver(), this);
    }
}
