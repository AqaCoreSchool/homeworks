package orangetest.tests;

import orangetest.utils.Application;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public static final String PASSWORD = "Vfylhfujhf!1";
    public static final String LOGIN = "TestUser05";

    @BeforeTest
    public void beforeTest() {
        loginPage = openLoginPage();
    }

    @Test
    public void loginTest() {
        loginPage.loginIntoSystem(LOGIN, PASSWORD);
        Assert.assertTrue(loginPage.isHomePageOpened());
    }

    @AfterSuite
    public void close() {
        Application.closeDriver();
    }
}
