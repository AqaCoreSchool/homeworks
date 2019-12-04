package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void loginTest() {
        HomePage homePage = getLoginPage()
                .fillUsername(getUser().getUserLoginName())
                .fillPassword(getUser().getUserPassword())
                .clickLoginButton();

        Assert.assertEquals(String.format(homePage.getWelcomeText(), "Welcome %s", getUser().getUserFirstName()),
                "Welcome " + getUser().getUserFirstName());
    }
}