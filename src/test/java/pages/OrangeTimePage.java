package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;
import utils.WebDriverFactory;

import java.util.List;

public class OrangeTimePage extends BasePage{
    private String punchInDateTime;
    private String punchOutDateTime;
    private List<WebElement> latestRecord;
    private String latestRecordPunchIn;
    private String latestRecordPunchInNote;
    private String latestRecordPunchOut;
    private String latestRecordPunchOutNote;
    private WebElement emptyRecord;
    Waits wait = new Waits(WebDriverFactory.getDriver());

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

    @FindBy(id = "recordsTable")
    private WebElement recordsTable;


    public String getPunchInDateTime() {
        return punchInDateTime;
    }

    public String getPunchOutDateTime() {
        return punchOutDateTime;
    }

    public String getLatestRecordPunchIn() {
        return latestRecordPunchIn;
    }

    public String getLatestRecordPunchInNote() {
        return latestRecordPunchInNote;
    }

    public String getLatestRecordPunchOut() {
        return latestRecordPunchOut;
    }

    public String getLatestRecordPunchOutNote() {
        return latestRecordPunchOutNote;
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
        wait.waitForVisibility(recordsTable);
        return this;
    }

    public OrangeTimePage getLastRecordData(){
        latestRecord = employeeRecords.get(employeeRecords.size()-1).findElements(By.xpath("./td"));
        latestRecordPunchIn = latestRecord.get(1).getText();
        latestRecordPunchInNote = latestRecord.get(2).getText();
        latestRecordPunchOut = latestRecord.get(3).getText();
        latestRecordPunchOutNote = latestRecord.get(4).getText();
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

    public boolean noRecordsIsDisplayed(){
        return emptyRecord.isDisplayed();
    }
}
