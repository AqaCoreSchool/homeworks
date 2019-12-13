package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import utils.Application;

public class BaseTest {
    protected LoginPage loginPage;
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = Application.getDriver();
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("standard_user", "secret_sauce");
    }

    public LoginPage openLoginPage( ) {
        driver = Application.getDriver();
        driver.get("https://www.saucedemo.com/");
        return new LoginPage();
    }

    @AfterTest
    public void close() {
        Application.closeDriver();
    }
}