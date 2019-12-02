package ua.biz.test.punch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.biz.test.BaseTest;
import ua.biz.test.entity.PunchData;
import ua.biz.test.pages.PunchPage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PunchTimeTest extends BaseTest {

    private final PunchData TEST_PUNCH_DATA =
            new PunchData("IMO punch in","IMO punch out");

    @Test
    public void testPunchDate() {
        PunchPage punchPage = mainPage.openPunchPage(driver);
        punchPage.punchInOut(TEST_PUNCH_DATA);
        mainPage.openMyRecordsPage(driver).showRecordDataByDate(LocalDate.now());

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                getRecordDataByPunchMessage(TEST_PUNCH_DATA.getPunchInMessage(), 2, 1)
                .contains(TEST_PUNCH_DATA.getPunchInTime()));
        softAssert.assertTrue(
                getRecordDataByPunchMessage(TEST_PUNCH_DATA.getPunchOutMessage(), 4, 3)
                .contains(TEST_PUNCH_DATA.getPunchInTime()));
        softAssert.assertAll();
    }



    private String getRecordDataByPunchMessage(String punchMessage, int messageIndex, int timeIndex) {
        String punchDate = "";
        List<WebElement> recordData=driver.findElements(By.
                xpath("//form[@id='employeeRecordsForm']//tr[@class='odd' or @class='even']"));
        List<WebElement> employeeRecord = new ArrayList<>();

        for (WebElement employeeData : recordData) {
            employeeRecord = employeeData.findElements(By.tagName("td"));
            if (employeeRecord.get(messageIndex).getText().equals(punchMessage)) {
                punchDate = employeeRecord.get(timeIndex).getText();
            }
        }
        return punchDate;
    }
}
