package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.data.UserData;
import selenium.page.PunchInOutPage;

public class PunchInOutOperationsTest extends BaseTest {

    @Test
    public void punchInOutVerifyingTest() {
        PunchInOutPage page = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .moveToTimeItem()
                .moveMenuAttendanceItem()
                .clickPunchIn()
                .fillTextArea(UserData.IN_NOTE)
                .clickPunchButton()
                .fillTextArea(UserData.OUT_NOTE)
                .clickPunchButton();

        String successMessage = page.getSuccessMessage();
        Assert.assertEquals(successMessage, "Successfully Saved\nClose");
    }

}
