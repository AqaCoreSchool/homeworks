package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.common.Utils;
import selenium.page.PunchInOutPage;

public class PunchInOutPageTest extends BaseTest {

    @Test
    public void punchInPageDateVerifyingTest() {
        PunchInOutPage homePage = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .moveToTimeItem()
                .moveMenuAttendanceItem()
                .clickPunchIn();

        String expectationDate = Utils.getCurrentDate().toString();
        Assert.assertEquals(expectationDate, homePage.getCurrentDateLabel());
    }
}
