package orangetest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.List;

public class HomePage {
    private static final String NOTE_IN = "I am a good worker :-)";
    private static final String NOTE_OUT = "I am already finished my work :-)";
    @FindBy(xpath = "//b[contains(text(),'Time')]")
    WebElement timeMenu;
    @FindBy(xpath = "//a[@id='menu_attendance_Attendance']")
    WebElement attendance;
    @FindBy(linkText = ("Punch In/Out"))
    WebElement punchInOut;
    @FindBy(xpath = "//textarea[@id='note']")
    WebElement note;
    @FindBy(xpath = ("//span[@id='currentTime']"))
    WebElement timeInOut;
    @FindBy(xpath = "//input[@id='btnPunch']")
    WebElement btnPunch;
    @FindBy(xpath = "//a[@id='menu_attendance_viewMyAttendanceRecord']")
    WebElement viewMyAttendanceRecord;
    @FindBy(xpath = "//input[@id='attendance_date']")
    WebElement attendanceDate;
    @FindBy(xpath = "//table[@class='table']")
    WebElement baseTable;

    private String timeString;
    private LocalDate dateNow = LocalDate.now();

    public HomePage(WebDriver driver) {
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

    public boolean checkRecord() {
        timeMenu.click();
        attendance.click();
        viewMyAttendanceRecord.click();
        attendanceDate.click();
        attendanceDate.sendKeys(dateNow.toString(), Keys.ENTER);
        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
        boolean stringSearch = tableRows.stream().map(WebElement::getText).anyMatch(
                o -> o.contains(NOTE_IN) &&
                        o.contains(NOTE_OUT) &&
                        o.contains(timeString));
        return stringSearch;
    }

    public boolean checkPreviousOrNextWeek(String date) {
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
