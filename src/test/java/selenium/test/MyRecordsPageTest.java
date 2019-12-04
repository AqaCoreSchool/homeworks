package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.common.Utils;
import selenium.page.MyRecordsPage;

public class MyRecordsPageTest extends BaseTest {

    @Test
    public void myRecordsTest() {
        MyRecordsPage page = getLoginPage()
                .fillUsername(getUser().getUserLoginName())
                .fillPassword(getUser().getUserPassword())
                .clickLoginButton()
                .moveToTimeItem()
                .moveMenuAttendanceItem()
                .clickMyRecords()
                .clearAttendanceDate()
                .fillAttendanceDate(Utils.getCurrentDate().toString())
                .getMyLastRecordsDetails();

        Assert.assertEquals(page.getLatestPunchIn(), Utils.getCurrentDateTime());
        Assert.assertEquals(Utils.getProperty("inNote"), page.getLatestPunchInNote());
        Assert.assertEquals(page.getLatestPunchOut(), Utils.getCurrentDateTime());
        Assert.assertEquals(Utils.getProperty("outNote"), page.getLatestPunchOutNote());

    }
}
