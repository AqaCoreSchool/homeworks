package tests;

import data.UserInfo;
import org.testng.annotations.Test;
import pages.EmployeeListPage;
import static org.assertj.core.api.Assertions.*;


public class EditUserInfoTest extends BaseTest{

    @Test
    public void  testEditUser() {
        loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .moveToMyInfoPage()
                .editInfo();

        assertThat(new EmployeeListPage().findEmployeeInfo(UserInfo.FIRST_NAME, UserInfo.LAST_NAME, UserInfo.ID))
                .as("String should contain employee's name and id").isNotEmpty();
    }
}
