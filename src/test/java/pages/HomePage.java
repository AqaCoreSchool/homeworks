package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage{
    private WebDriver driver;

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


    public HomePage clickTimeBtn() {
        timeBtn.click();
        return this;
    }

    public HomePage clickAttendanceBtn(){
        attendanceBtn.click();
        return this;
    }

    public HomePage clickPunchInOutBtn(){
        punchInOutBtn.click();
        return this;
    }

    public HomePage clickMyRecordsBtn(){
        myRecordsBtn.click();
        return this;
    }

    public MyInfoPage clickMyInfoBtn(){
        myInfoBtn.click();
        return new MyInfoPage();
    }

    public HomePage clickRecruitmentBtn(){
        recruitmentBtn.click();
        return this;
    }

    public CandidatesPage clickCandidatesBtn(){
        candidatesBtn.click();
        return new CandidatesPage();
    }

    public VacanciesPage clickVacanciesBtn(){
        vacancyBtn.click();
        return new VacanciesPage();
    }
}
