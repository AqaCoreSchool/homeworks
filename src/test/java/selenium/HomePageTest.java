package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.data.UserData;
import selenium.page.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void loginTest() {
        HomePage homePage = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton();

        Assert.assertEquals(homePage.getWelcomeText(), "Welcome Pavlo");
    }
}