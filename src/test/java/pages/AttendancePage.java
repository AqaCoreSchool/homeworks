package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.List;

public class AttendancePage {
    private static final String NOTE_IN = "I am a good worker :-)";
    private static final String NOTE_OUT = "I am already finished my work :-)";
    @FindBy(xpath = "//b[contains(text(),'Time')]")
    private WebElement timeMenu;
    @FindBy(xpath = "//a[@id='menu_attendance_Attendance']")
    private WebElement attendance;
    @FindBy(linkText = ("Punch In/Out"))
    private WebElement punchInOut;
    @FindBy(xpath = "//textarea[@id='note']")
    private WebElement note;
    @FindBy(xpath = ("//span[@id='currentTime']"))
    private WebElement timeInOut;
    @FindBy(xpath = "//input[@id='btnPunch']")
    private WebElement btnPunch;
    @FindBy(xpath = "//a[@id='menu_attendance_viewMyAttendanceRecord']")
    private WebElement viewMyAttendanceRecord;
    @FindBy(xpath = "//input[@id='attendance_date']")
    private WebElement attendanceDate;
    @FindBy(xpath = "//table[@class='table']")
    private WebElement baseTable;

    private String timeString;
    private LocalDate dateNow = LocalDate.now();

    public AttendancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void punchInOut(String punchInNote) {
        timeMenu.click();
        attendance.click();
        punchInOut.click();
        note.sendKeys(punchInNote);
        timeString = timeInOut.getText();
        btnPunch.click();
    }

    public boolean isRecordAdded() {
        timeMenu.click();
        attendance.click();
        viewMyAttendanceRecord.click();
        attendanceDate.click();
        attendanceDate.sendKeys(dateNow.toString(), Keys.ENTER);
        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
        return tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(NOTE_IN) &&
                        o.contains(NOTE_OUT) &&
                        o.contains(timeString));
    }

    public boolean isPrevOrNextWeekWithoutRecords(String date) {
        timeMenu.click();
        attendance.click();
        viewMyAttendanceRecord.click();
        attendanceDate.click();
        attendanceDate.clear();
        attendanceDate.sendKeys(date, Keys.ENTER);
        List<WebElement> result = baseTable.findElements(By.xpath("//td[@id='noRecordsColumn']"));
        return result.size() == 1;
    }
}
