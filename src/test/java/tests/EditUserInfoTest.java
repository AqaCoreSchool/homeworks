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
                .clickMyInfoBtn()
                .clickEditOrSave()
                .clickfirstNameInput(UserInfo.NAME)
                .clicklastNameInput(UserInfo.LASTNAME)
                .clickIdInput(UserInfo.ID)
                .clickGenderMale()
                .clickMaritalStatus()
                .clickNationalityUkrainian()
                .clickinputDateOfBirth(UserInfo.BIRTH_DATE)
                .clickEditOrSave()
                .clickPimBtn()
                .clickEmployeeListBtn();

        assertThat(new EmployeeListPage(driver).findEmployeeInfo(UserInfo.NAME, UserInfo.LASTNAME, UserInfo.ID))
                .as("String should contain employee's name and id").isNotEmpty();
    }

}
