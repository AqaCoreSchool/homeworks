package com.company.verifytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenuPage {
    public static WebDriver driver;
    private WebDriverWait wait;

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


    public MainMenuPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

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

    public PunchPage clickPunchInOut(){
        punchInOut.click();
        return new PunchPage(driver);
    }

    public VacancyPage moveToVacancy(){
        vacancyBtn.click();
        return new VacancyPage(driver);
    }

    public CandidatesPage moveToCandidate(){
        candidateBtn.click();
        return new CandidatesPage(driver);
    }

    public MyInfoPage clickMyInfo(){
        info.click();
        return new MyInfoPage(driver);
    }

}
