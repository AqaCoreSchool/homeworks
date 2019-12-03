package com.company.vTests.pages;

import com.company.vTests.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuPage extends BasePage {

    @FindBy(xpath = "//a[@id='menu_time_viewTimeModule']")
    private WebElement timeBtnHeader;

    @FindBy(xpath = "//a[@id='menu_attendance_Attendance']")
    private WebElement attendanceBtnHeader;

    @FindBy(xpath = "//a[@id='menu_attendance_punchIn']")
    private WebElement punchInOut;

    @FindBy(xpath = "//a[@id='menu_attendance_viewMyAttendanceRecord']")
    private WebElement myRecordsBtnDropDown;

    @FindBy(xpath = "//a[@id='menu_pim_viewMyDetails']")
    private WebElement info;

    @FindBy(xpath = "//b[contains(text(),'Recruitment')]")
    private WebElement recruitment;

    @FindBy(xpath ="//a[@id='menu_recruitment_viewJobVacancy']")
    private WebElement vacancyBtn;

    @FindBy(xpath ="//a[@id='menu_recruitment_viewCandidates']")
    private WebElement candidateBtn;

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    private WebElement adminBtn;

    @FindBy(xpath = "//a[@id='menu_admin_Organization']")
    private WebElement organizationBtn;

    @FindBy(xpath = "//a[@id='menu_admin_viewLocations']")
    private WebElement locationBtn;

    public MainMenuPage moveToTime(){
        timeBtnHeader.click();
        return this;
    }

    public MainMenuPage moveToAttendance(){
        attendanceBtnHeader.click();
        return this;
    }

    public MainMenuPage moveToRecruitment(){
        recruitment.click();
        return this;
    }

    public VacancyPage moveToVacancy(){
        vacancyBtn.click();
        return new VacancyPage();
    }

    public CandidatesPage moveToCandidate(){
        candidateBtn.click();
        return new CandidatesPage();
    }

    public MainMenuPage moveToAdmin(){
        adminBtn.click();
        return this;
    }

    public MainMenuPage moveToOrganization(){
        organizationBtn.click();
        return this;
    }

    public LocationPage moveToLocation(){
        locationBtn.click();
        return new LocationPage();
    }

}

