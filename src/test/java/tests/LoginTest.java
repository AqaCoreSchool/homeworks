package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Application;

public class LoginTest extends BaseTest {
    public static final String PASSWORD = "secret_sauce";
    public static final String LOGIN = "standard_user";

    @BeforeTest
    public void beforeTest() {
        loginPage = openLoginPage();
    }

    @Test
    public void loginTest() {
        loginPage.loginIntoSystem(LOGIN, PASSWORD);
        Assert.assertTrue(loginPage.checkLogin());
    }

    @AfterSuite
    public void close() {
        Application.closeDriver();
    }
}
