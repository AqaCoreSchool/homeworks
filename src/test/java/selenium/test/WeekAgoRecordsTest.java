package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.common.Utils;
import selenium.data.UserData;
import selenium.page.MyRecordsPage;

public class WeekAgoRecordsTest extends BaseTest {

    @Test
    public void weekAgoRecordsTest() {
        MyRecordsPage page = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .moveToTimeItem()
                .moveMenuAttendanceItem()
                .clickMyRecords()
                .clearAttendanceDate()
                .fillAttendanceDate(Utils.getCurrentDate().minusWeeks(1).toString());

        String recordColumnText = page.getRecordColumnText();
        Assert.assertEquals(recordColumnText, "No attendance records to display");
    }
}
