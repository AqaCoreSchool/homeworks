package tests;

import data.LoginInfo;
import data.User;
import org.testng.annotations.Test;
import pages.EmployeeListPage;

import static org.assertj.core.api.Assertions.*;


public class EditUserInfoTest extends BaseTest{

    @Test
    public void testUserInfo() {
        User user = new User();
        EmployeeListPage employeeListPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .moveToMyInfoPage()
                .editInfo(user)
                .moveToEmployeeListPage();

        assertThat(employeeListPage.findEmployeeInfo(user))
                .as("String should contain employee's name and id").isNotEmpty();
    }
}
