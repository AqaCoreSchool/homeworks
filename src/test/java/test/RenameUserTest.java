package test;

import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.pages.EmployeeListPage;
import testpackage.pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RenameUserTest extends BaseTest {

    private String login = "TestUser03";
    private String password = "Vfylhfujhf!1";
    private String firstName = "Danylo";
    private String middleName = "Alexandrovich";
    private String lastName = "Pazykov";
    private String id = "646558";
    private String dateOfBirth = "2001-05-04";

    @Test
    public void userRenameTest(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .loginToTheSystem(login,password)
                .clickMyInfo()
                .clickEditSave()
                .inputFirstName(firstName)
                .inputMiddleName(middleName)
                .inputLastName(lastName)
                .inputId(id)
                .clickGenderMale()
                .clickNationalityUkrainian()
                .clickMaritalStatus()
                .inputDateOfBirth(dateOfBirth)
                .clickEditSave()
                .moveToPIM()
                .moveToEmployeeList();
        assertThat(new EmployeeListPage().filterEmployeeList(firstName,middleName,lastName,id))
                .as("").isTrue();
    }
}
