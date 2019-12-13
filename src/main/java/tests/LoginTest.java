package tests;

import data.LoginInfo;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin(){
        MainPage mainPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD);

        assertThat(mainPage.getLogoElement().isDisplayed()).as("Login is incorrect");

    }
}
