package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.common.Utils;
import selenium.page.PunchInOutPage;

public class PunchInOutOperationsTest extends BaseTest {

    @Test
    public void punchInOutVerifyingTest() {
        PunchInOutPage page = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .moveToTimeItem()
                .moveMenuAttendanceItem()
                .clickPunchIn()
                .fillTextArea(Utils.getProperty("inNote"))
                .clickPunchButton()
                .fillTextArea(Utils.getProperty("outNote"))
                .clickPunchButton();

        String successMessage = page.getSuccessMessage();
        Assert.assertEquals(successMessage, "Successfully Saved\nClose", "Successfully message isn't displayed");
    }

}
