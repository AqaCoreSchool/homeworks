package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.data.UserData;
import selenium.page.MyInfoPage;

public class MyInfoPageTest extends BaseTest {
    @Test
    public void myInfoTest() {
        MyInfoPage page = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .clickMyInfo()
                .btnClick()
                .clearAllFields()
                .fillEmployeeName(UserData.USER_NAME)
                .fillEmployeeLastName(UserData.USER_LASTNAME)
                .fillEmployeeOtherId(UserData.USER_OTHER_ID)
                .fillEmployeeId(UserData.USER_EMPLOYEE_ID)
                .fillEmployeeLicenceNo(UserData.USER_LICENCE_NO)
                .fillEmployeeLicenceExpDate(UserData.USER_LICENCE_EXP_DATE)
                .fillEmployeeBirthDate(UserData.USER_BIRTH_DATE)
                .selectEmployeeGender()
                .fillEmployeeNation(UserData.USER_NATION)
                .fillEmployeeMarital(UserData.USER_MARITAL)
                .btnClick();

        Assert.assertFalse(page.getEmployeeFirstName().isEnabled());
        Assert.assertEquals(page.getEmployeeFirstName().getAttribute("value"), "Pavlo");
    }
}
