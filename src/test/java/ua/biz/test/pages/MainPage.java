package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"menu_time_viewTimeModule\"]")
    private WebElement timeButton;

    @FindBy(xpath = "//a[@id=\"menu_attendance_Attendance\"]")
    private WebElement attendanceButton;

    @FindBy(xpath = "//a[@id=\"menu_attendance_viewMyAttendanceRecord\"]")
    private WebElement myRecordButton;

    @FindBy(xpath = "//a[@id='menu_attendance_punchIn']")
    private WebElement punchButton;

    @FindBy(xpath = "//a[@id='menu_pim_viewMyDetails']")
    private WebElement myInfoButtom;

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    private WebElement recruitmentButton;

    @FindBy(xpath = "//a[@id='menu_recruitment_viewCandidates']")
    private WebElement candidatesButton;

    @FindBy(xpath = "//a[@id='menu_recruitment_viewJobVacancy']")
    private WebElement vacanciesButton;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    private WebElement pimButton;

    @FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
    private WebElement emloyeeListButton;

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminButton;

    @FindBy(id = "menu_admin_Organization")
    private WebElement organizationButton;

    @FindBy(id = "menu_admin_viewLocations")
    private WebElement locationButton;


    public MainPage() {
        super();

    }

    public CandidatesListPage openCandidatesListPage() {
        WaitUtil.waitAndClick(recruitmentButton);
        WaitUtil.waitAndClick(candidatesButton);
        return new CandidatesListPage();
    }

    public VacanciesListPage openVacanciesListPage() {
        WaitUtil.waitAndClick(recruitmentButton);
        WaitUtil.waitAndClick(vacanciesButton);
        return new VacanciesListPage();
    }

    public EmployeeListPage openEmployeeListPage() {
        WaitUtil.waitAndClick(pimButton);
        WaitUtil.waitAndClick(emloyeeListButton);
        return new EmployeeListPage();
    }

    public PunchPage openPunchPage() {
        WaitUtil.waitAndClick(timeButton);
        WaitUtil.waitAndClick(attendanceButton);
        WaitUtil.waitAndClick(punchButton);
        return new PunchPage();
    }

    public MyRecordsPage openMyRecordsPage() {
        WaitUtil.waitAndClick(timeButton);
        WaitUtil.waitAndClick(attendanceButton);
        WaitUtil.waitAndClick(myRecordButton);
        return new MyRecordsPage();
    }

    public MyInfoPage openMyInfoPage() {
        WaitUtil.waitAndClick(myInfoButtom);
        return new MyInfoPage();
    }

    public LocationsPage openLocationPage() {
        WaitUtil.waitAndClick(adminButton);
        WaitUtil.waitAndClick(organizationButton);
        WaitUtil.waitAndClick(locationButton);
        return new LocationsPage();
    }
}
