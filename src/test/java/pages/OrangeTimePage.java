package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrangeTimePage extends BasePage{
    private String punchInDateTime;
    private String punchOutDateTime;
    private List<WebElement> latestRecord;
    private WebElement latestRecordPunchIn;
    private WebElement latestRecordPunchInNote;
    private WebElement latestRecordPunchOut;
    private WebElement latestRecordPunchOutNote;
    private WebElement emptyRecord;
    private WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);

    @FindBy(id = "menu_attendance_Attendance")
    private WebElement attendanceMenu;

    @FindBy(id = "menu_attendance_punchIn")
    private WebElement punchInOut;

    @FindBy(id = "currentDate")
    private WebElement punchDate;

    @FindBy(id = "currentTime")
    private WebElement punchTime;

    @FindBy(xpath = "//textarea[@id='note']")
    private WebElement inTextArea;

    @FindBy(id = "btnPunch")
    private WebElement buttonConfirmPunch;

    @FindBy(id = "menu_attendance_viewMyAttendanceRecord")
    private WebElement attendanceRecords;

    @FindBy(id = "attendance_date")
    private WebElement attendanceDate;

    @FindBy(xpath = "//form[@id='employeeRecordsForm']//tr[@class='odd' or @class='even']")
    private List<WebElement> employeeRecords;

    @FindBy(xpath = "//form[@id='employeeRecordsForm']//tr/td[@id='noRecordsColumn']")
    private List<WebElement> noRecords;


    public String getPunchInDateTime() {
        return punchInDateTime;
    }

    public String getPunchOutDateTime() {
        return punchOutDateTime;
    }

    public WebElement getLatestRecordPunchIn() {
        return latestRecordPunchIn;
    }

    public WebElement getLatestRecordPunchInNote() {
        return latestRecordPunchInNote;
    }

    public WebElement getLatestRecordPunchOut() {
        return latestRecordPunchOut;
    }

    public WebElement getLatestRecordPunchOutNote() {
        return latestRecordPunchOutNote;
    }

    public WebElement getEmptyRecord() {
        return emptyRecord;
    }


    public OrangeTimePage toAttendanceMenu(){
        attendanceMenu.click();
        return this;
    }

    public OrangeTimePage toPunchInOut(){
        punchInOut.click();
        if(buttonConfirmPunch.getAttribute("value").equals("In")){
            punchInDateTime = String.format("%s %s:00 GMT 2", punchDate.getText(), punchTime.getText());
        } else if(buttonConfirmPunch.getAttribute("value").equals("Out")){
            punchOutDateTime = String.format("%s %s:00 GMT 2", punchDate.getText(), punchTime.getText());
        }
        return this;
    }

    public OrangeTimePage enterPunchText(String message){
        inTextArea.sendKeys(message);
        return this;
    }

    public OrangeTimePage savePunch(){
        buttonConfirmPunch.click();
        return this;
    }

    public OrangeTimePage createPunch(String message){
        return toAttendanceMenu().toPunchInOut().enterPunchText(message).savePunch();
    }

    public OrangeTimePage toRecords(){
        attendanceRecords.click();
        return this;
    }

    public OrangeTimePage getRecordsByDate(String date){
        attendanceDate.clear();
        attendanceDate.sendKeys(date + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recordsTable")));
        return this;
    }

    public OrangeTimePage getLastRecordData(){
        latestRecord = employeeRecords.get(employeeRecords.size()-1).findElements(By.xpath("./td"));
        latestRecordPunchIn = latestRecord.get(1);
        latestRecordPunchInNote = latestRecord.get(2);
        latestRecordPunchOut = latestRecord.get(3);
        latestRecordPunchOutNote = latestRecord.get(4);
        return this;
    }

    public OrangeTimePage getNoRecords(){
        emptyRecord = noRecords.get(0);
        return this;
    }

    public OrangeTimePage checkPunchInRecordsTable(String date){
        return toAttendanceMenu().toRecords().getRecordsByDate(date).getLastRecordData();
    }

    public OrangeTimePage checkEmptyRecordsTable(String date){
        return toAttendanceMenu().toRecords().getRecordsByDate(date).getNoRecords();
    }
}
