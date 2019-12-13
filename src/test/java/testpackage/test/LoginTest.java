package testpackage.test;

import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.page.LoginPage;
import testpackage.page.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    private String login = "standard_user";
    private String password = "secret_sauce";

    @Test
    public void loginTest(){
        MainPage loginPage = new LoginPage()
                .loginToTheSystem(login,password)
                .moveToMenu();
        assertThat(loginPage.verifyLogoutInDisplay())
                .as("You are not logged in").isTrue();
    }
}
