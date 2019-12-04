package testpackage.test;

import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.entity.User;
import testpackage.factory.UserFactory;
import testpackage.pages.EmployeeListPage;
import testpackage.pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RenameUserTest extends BaseTest {

    private String login = "TestUser03";
    private String password = "Vfylhfujhf!1";

    @Test
    public void userRenameTest(){
        User user = new UserFactory().defaultUser();
        LoginPage loginPage = new LoginPage();
        loginPage
                .loginToTheSystem(login,password)
                .clickMyInfo()
                .createUser(user)
                .moveToEmployeeList();
        assertThat(new EmployeeListPage().filterEmployeeList(user))
                .as("User no created").isTrue();
    }
}
