package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;


public class MainPage extends BasePage{

    @FindBy(id = "menu_admin_viewAdminModule")
    private  WebElement adminBtn;

    @FindBy(id = "menu_admin_Organization")
    private  WebElement organizationBtn;

    @FindBy(id = "menu_admin_viewLocations")
    private  WebElement locationsBtn;

    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement timeBtn;

    @FindBy(id = "menu_attendance_Attendance")
    private WebElement attendanceBtn;

    @FindBy(id = "menu_attendance_punchIn")
    private WebElement punchInOutBtn;

    @FindBy(id = "menu_attendance_viewMyAttendanceRecord")
    private WebElement myRecordsBtn;

    @FindBy(id = "menu_pim_viewMyDetails")
    private WebElement myInfoBtn;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    private WebElement recruitmentBtn;

    @FindBy(id = "menu_recruitment_viewCandidates")
    private WebElement candidatesBtn;

    @FindBy(id = "menu_recruitment_viewJobVacancy")
    private WebElement vacancyBtn;

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement pimBtn;

    @FindBy(id = "menu_pim_viewEmployeeList")
    private WebElement employeeListBtn;


    public MainPage clickTimeBtn() {
        Utils.waitAndClick(timeBtn);
        return this;
    }

    public MainPage clickAttendanceBtn(){
        Utils.waitAndClick(attendanceBtn);
        return this;
    }

    public MainPage clickPunchInOutBtn(){
        Utils.waitAndClick(punchInOutBtn);
        return this;
    }

    public MainPage clickMyRecordsBtn(){
        Utils.waitAndClick(myRecordsBtn);
        return this;
    }

    public MainPage clickRecruitmentBtn(){
        Utils.waitAndClick(recruitmentBtn);
        return this;
    }

    @Step
    public EmployeeListPage moveToEmployeeListPage(){
        Utils.waitAndClick(pimBtn);
        Utils.waitAndClick(employeeListBtn);
        return new EmployeeListPage();
    }

    @Step
    public MyInfoPage moveToMyInfoPage(){
        Utils.waitAndClick(myInfoBtn);
        return new MyInfoPage();
    }
    @Step("qwweer")
    public CandidatesPage moveToCandidatesPage(){
        Utils.waitAndClick(recruitmentBtn);
        Utils.waitAndClick(candidatesBtn);
        return new CandidatesPage();
    }

    @Step
    public VacanciesPage moveToVacanciesPage(){
        Utils.waitAndClick(recruitmentBtn);
        Utils.waitAndClick(vacancyBtn);
        return new VacanciesPage();
    }

    @Step
    public LocationsPage moveToLocationsPage(){
        Utils.waitAndClick(adminBtn);
        Utils.waitAndClick(organizationBtn);
        Utils.waitAndClick(locationsBtn);
        return new LocationsPage();
    }
}
