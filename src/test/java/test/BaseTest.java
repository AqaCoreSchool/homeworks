package test;

import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;

public class BaseTest {
    private LoginPage loginPage;

    public LoginPage openLoginPage() {
        return new LoginPage();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    @BeforeMethod
    public void setup() {
        loginPage = openLoginPage();
    }

    @AfterMethod
    public void teardown() {
        Driver.getInstance().quitDriver();
    }
}
