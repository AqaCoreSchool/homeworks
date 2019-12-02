package testpackage.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

public class MainPage extends BasePage {

    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement timeBtnHeader;

    @FindBy(id = "menu_attendance_Attendance")
    private WebElement attendanceBtnHeader;

    @FindBy(id = "menu_attendance_punchIn")
    private WebElement punchInOutBtnDropDown;

    @FindBy(id = "menu_attendance_viewMyAttendanceRecord")
    private WebElement myRecordsBtnDropDown;

    @FindBy(id = "menu_pim_viewMyDetails")
    private WebElement myInfoBtnDropDown;

    @FindBy(xpath = " //b[contains(text(),'Recruitment')]")
    private WebElement recruitmentBtnDropDown;

    @FindBy(id = "menu_recruitment_viewCandidates")
    private WebElement candidatesBtnDropDown;

    @FindBy(id = "menu_recruitment_viewJobVacancy")
    private WebElement vacancyBtnDropDown;

    public MainPage moveToTime(){
        timeBtnHeader.click();
        return this;
    }

    public MainPage moveToAttendance(){
        attendanceBtnHeader.click();
        return this;
    }

    public PunchInOutPage clickPunchInOut(){
        punchInOutBtnDropDown.click();
        return new PunchInOutPage();
    }

    public MyRecordsPage clickMyRecords(){
        myRecordsBtnDropDown.click();
        return new MyRecordsPage();
    }

    public MyInfoPage clickMyInfo(){
        wait.until(ExpectedConditions.elementToBeClickable(myInfoBtnDropDown));
        myInfoBtnDropDown.click();
        return new MyInfoPage();
    }

    public MainPage moveToRecruitment(){
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentBtnDropDown));
        recruitmentBtnDropDown.click();
        return this;
    }

    public CandidatesPage moveToCandidates(){
        wait.until(ExpectedConditions.elementToBeClickable(candidatesBtnDropDown));
        candidatesBtnDropDown.click();
        return new CandidatesPage();
    }

    public VacanciesPage moveToVacancies(){
        wait.until(ExpectedConditions.elementToBeClickable(vacancyBtnDropDown));
        vacancyBtnDropDown.click();
        return new VacanciesPage();
    }

}
