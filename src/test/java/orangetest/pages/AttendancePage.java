package orangetest.pages;

import io.qameta.allure.Step;
import orangetest.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;

public class AttendancePage extends BasePage {
    private static final String NOTE_IN = "I am a good worker :-)";
    private static final String NOTE_OUT = "I am already finished my work :-)";

    @FindBy(xpath = "//textarea[@id='note']")
    WebElement note;
    @FindBy(xpath = ("//span[@id='currentTime']"))
    WebElement timeInOut;
    @FindBy(xpath = "//input[@id='btnPunch']")
    WebElement btnPunch;
    @FindBy(xpath = "//input[@id='attendance_date']")
    WebElement attendanceDate;
    @FindBy(xpath = "//table[@class='table']")
    WebElement baseTable;

    private String timeString;
    private LocalDate dateNow = LocalDate.now();

    public AttendancePage() {
        super();
    }

    @Step("User's punch IN/OUT")
    public AttendancePage punchInOut(String punchInNote) {
        timeMenu.click();
        attendance.click();
        punchInOut.click();
        note.sendKeys(punchInNote);
        timeString = timeInOut.getText();
        btnPunch.click();
        return this;
    }

    @Step("Checking of user's punch record")
    public boolean isRecordAdded() {
        timeMenu.click();
        attendance.click();
        viewMyAttendanceRecord.click();
        attendanceDate.click();
        attendanceDate.clear();
        attendanceDate.sendKeys(dateNow.toString(), Keys.ENTER);
        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
        return tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(NOTE_IN) &&
                        o.contains(NOTE_OUT) &&
                        o.contains(timeString));
    }

    @Step("Checking if there are no punch records from current user in Next/Previous week")
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
