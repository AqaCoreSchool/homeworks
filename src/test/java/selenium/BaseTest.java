package selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.driver.Driver;
import selenium.page.LoginPage;

public class BaseTest {
    private LoginPage loginPage;

    public LoginPage openLoginPage() {
        return new LoginPage();
    }

    @BeforeMethod
    public void setup() {
        loginPage = openLoginPage();
    }

    @AfterMethod
    public void teardown() {
        Driver.getInstance().quitDriver();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
