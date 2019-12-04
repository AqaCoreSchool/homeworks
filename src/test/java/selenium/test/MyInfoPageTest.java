package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.MyInfoPage;

public class MyInfoPageTest extends BaseTest {
    @Test
    public void myInfoTest() {
        MyInfoPage page = getLoginPage()
                .fillUsername(getUser().getUserLoginName())
                .fillPassword(getUser().getUserPassword())
                .clickLoginButton()
                .clickMyInfo()
                .btnClick()
                .clearAllFields()
                .fillEmployeeName(getUser().getUserFirstName())
                .fillEmployeeLastName(getUser().getUserLastName())
                .fillEmployeeOtherId(getUser().getUserOtherId())
                .fillEmployeeId(getUser().getUserId())
                .fillEmployeeLicenceNo(getUser().getUserLicenceNo())
                .fillEmployeeLicenceExpDate(getUser().getUserLicenceExpDate())
                .fillEmployeeBirthDate(getUser().getUserBirthDate())
                .selectEmployeeGender()
                .fillEmployeeNation(getUser().getUserNation())
                .fillEmployeeMarital(getUser().getUserMarital())
                .btnClick();

        Assert.assertFalse(page.getEmployeeFirstName().isEnabled());
        Assert.assertEquals(page.getEmployeeFirstName().getAttribute("value"), "Pavlo");
    }
}
