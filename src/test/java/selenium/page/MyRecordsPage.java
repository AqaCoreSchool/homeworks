package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.Wait;

import java.util.List;

public class MyRecordsPage extends BasePage {
    private String latestPunchIn;
    private String latestPunchOut;
    private String latestPunchInNote;
    private String latestPunchOutNote ;

    @FindBy(id = "attendance_date")
    private WebElement attendanceDate;

    @FindBy(xpath = "//form[@id='employeeRecordsForm']/table/tbody/tr[@class='odd' or @class='even']")
    private List<WebElement> recordsFormRows;

    @FindBy(xpath = "./td")
    private List<WebElement> myLastRecordDetails;

    @FindBy(id = "noRecordsColumn")
    private WebElement noRecordColumn;

    @FindBy(id = "employeeRecordsForm")
    private WebElement employeeRecordsForm;

    private By lastRecordRow = By.xpath("./td");

    public MyRecordsPage clearAttendanceDate() {
        Wait.waitForVisible(attendanceDate);
        attendanceDate.clear();
        return this;
    }

    public MyRecordsPage fillAttendanceDate(String date) {
        attendanceDate.sendKeys(date, Keys.ENTER);
        return this;
    }

    public MyRecordsPage getMyLastRecordsDetails() {
        Wait.waitForVisible(employeeRecordsForm);
        WebElement myLastRecordRow = recordsFormRows.get(recordsFormRows.size() - 1);
        myLastRecordDetails = myLastRecordRow.findElements(lastRecordRow);
        latestPunchIn = myLastRecordDetails.get(1).getText();
        latestPunchInNote = myLastRecordDetails.get(2).getText();
        latestPunchOut = myLastRecordDetails.get(3).getText();
        latestPunchOutNote = myLastRecordDetails.get(4).getText();
        return this;
    }

    public String getRecordColumnText() {
        Wait.waitForVisible(noRecordColumn);
        return noRecordColumn.getText();
    }

    public String getLatestPunchIn() {
        return latestPunchIn;
    }

    public String getLatestPunchOut() {
        return latestPunchOut;
    }

    public String getLatestPunchInNote() {
        return latestPunchInNote;
    }

    public String getLatestPunchOutNote() {
        return latestPunchOutNote;
    }
}
