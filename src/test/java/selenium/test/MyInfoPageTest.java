package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.MyInfoPage;

public class MyInfoPageTest extends BaseTest {
    @Test
    public void myInfoTest() {
        MyInfoPage page = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .clickMyInfo()
                .btnClick()
                .clearAllFields()
                .fillEmployeeName(getUser().getUserFirstName())
                .fillEmployeeLastName(getUser().getUserLastName())
                .fillEmployeeId(getUser().getUserId())
                .fillEmployeeBirthDate(getUser().getUserBirthDate())
                .fillEmployeeNation(getUser().getUserNation())
                .btnClick();

        Assert.assertEquals(page.getEmployeeFirstName(), "Pavlo");
    }
}
