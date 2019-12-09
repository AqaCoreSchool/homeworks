package testpackage.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testpackage.manager.DriverManager;
import testpackage.pages.*;

public class BasePage {
    public final WebDriverWait wait;

    @FindBy(id = "menu_admin_Organization")
    private WebElement organizationMenu;

    @FindBy(id = "menu_admin_viewLocations")
    private WebElement locations;

    @FindBy(id="menu_admin_viewAdminModule")
    private  WebElement adminMenu;

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement pIMBtnHeader;

    @FindBy(id = "menu_pim_viewEmployeeList")
    private WebElement employeeListBtnHeader;

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

    public  BasePage(){
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
        wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 10);
    }

    public EmployeeListPage moveToEmployeeList(){
        pIMBtnHeader.click();
        employeeListBtnHeader.click();
        return new EmployeeListPage();
    }

    public PunchInOutPage clickPunchInOut(){
        timeBtnHeader.click();
        attendanceBtnHeader.click();
        punchInOutBtnDropDown.click();
        return new PunchInOutPage();
    }

    public MyRecordsPage clickMyRecords(){
        timeBtnHeader.click();
        attendanceBtnHeader.click();
        myRecordsBtnDropDown.click();
        return new MyRecordsPage();
    }

    public MyInfoPage clickMyInfo(){
        wait.until(ExpectedConditions.elementToBeClickable(myInfoBtnDropDown));
        myInfoBtnDropDown.click();
        return new MyInfoPage();
    }

    public CandidatesPage moveToCandidates(){
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentBtnDropDown));
        recruitmentBtnDropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(candidatesBtnDropDown));
        candidatesBtnDropDown.click();
        return new CandidatesPage();
    }

    public VacanciesPage moveToVacancies(){
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentBtnDropDown));
        recruitmentBtnDropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(vacancyBtnDropDown));
        vacancyBtnDropDown.click();
        return new VacanciesPage();
    }

    public LocationPage moveToLocation(){
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu));
        adminMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(organizationMenu));
        organizationMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(locations));
        locations.click();
        return new LocationPage();
    }
}
