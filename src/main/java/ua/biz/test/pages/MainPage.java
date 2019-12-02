package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

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

    public  MainPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public CandidatesListPage openCandidatesListPage(WebDriver driver) {
        recruitmentButton.click();
        candidatesButton.click();
        return new CandidatesListPage(driver);
    }

    public VacanciesListPage openVacanciesListPage(WebDriver driver) {
        recruitmentButton.click();
        vacanciesButton.click();
        return new VacanciesListPage(driver);
    }

    public EmployeeListPage openEmployeeListPage(WebDriver driver) {
        pimButton.click();
        emloyeeListButton.click();
        return new EmployeeListPage(driver);
    }

    public PunchPage openPunchPage(WebDriver driver) {
        timeButton.click();
        attendanceButton.click();
        punchButton.click();
        return new PunchPage(driver);
    }

    public MyRecordsPage openMyRecordsPage(WebDriver driver) {
        timeButton.click();
        attendanceButton.click();
        myRecordButton.click();
        return new MyRecordsPage(driver);
    }

    public MyInfoPage openMyInfoPage(WebDriver driver) {
        myInfoButtom.click();
        return new MyInfoPage(driver);
    }
}
