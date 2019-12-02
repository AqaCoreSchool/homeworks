package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.common.Utils;
import selenium.data.UserData;
import selenium.page.PunchInOutPage;

public class PunchInOutPageTest extends BaseTest {

    @Test
    public void punchInPageDateVerifyingTest() {
        PunchInOutPage homePage = getLoginPage()
                .fillUsername(UserData.USER_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .moveToTimeItem()
                .moveMenuAttendanceItem()
                .clickPunchIn();

        String expectationDate = Utils.getCurrentDate().toString();
        Assert.assertEquals(expectationDate, homePage.getCurrentDateLabel());
    }
}
