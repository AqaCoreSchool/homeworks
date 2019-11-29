package testpackage.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testpackage.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

     private WebDriverWait wait;

    @FindBy(xpath = "//a[@id='menu_time_viewTimeModule']")
    private WebElement timeBtnHeader;

    @FindBy(xpath = "//a[@id='menu_attendance_Attendance']")
    private WebElement attendanceBtnHeader;

    @FindBy(xpath = "//a[@id='menu_attendance_punchIn']")
    private WebElement punchInOutBtnDropDown;

    @FindBy(xpath = "//a[@id='menu_attendance_viewMyAttendanceRecord']")
    private WebElement myRecordsBtnDropDown;

    @FindBy(xpath = " //a[@id='menu_pim_viewMyDetails']")
    private WebElement myInfoBtnDropDown;


    public MainPage(){
        PageFactory.initElements(BasePage.getInstance().getDriver(), this);
        wait = new WebDriverWait(BasePage.getInstance().getDriver(), 10);
    }

    public MainPage moveToTime(){
        timeBtnHeader.click();
        return new MainPage();
    }

    public MainPage moveToAttendance(){
        attendanceBtnHeader.click();
        return new MainPage();
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

}
