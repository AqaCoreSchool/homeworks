package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.common.Utils;
import selenium.data.UserData;
import selenium.page.MyRecordsPage;

public class MyRecordsPageTest extends BaseTest {

    @Test
    public void myRecordsTest() {
        MyRecordsPage page = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .moveToTimeItem()
                .moveMenuAttendanceItem()
                .clickMyRecords()
                .clearAttendanceDate()
                .fillAttendanceDate(Utils.getCurrentDate().toString())
                .getMyLastRecordsDetails();

        Assert.assertEquals(page.getLatestPunchIn(), Utils.getCurrentDateTime());
        Assert.assertEquals(UserData.IN_NOTE, page.getLatestPunchInNote());
        Assert.assertEquals(page.getLatestPunchOut(), Utils.getCurrentDateTime());
        Assert.assertEquals(UserData.OUT_NOTE, page.getLatestPunchOutNote());

    }
}
