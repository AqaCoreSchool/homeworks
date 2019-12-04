package orangetest.tests;

import orangetest.pages.LoginPage;
import orangetest.utils.Application;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    protected LoginPage loginPage;
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = Application.getDriver();
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser05", "Vfylhfujhf!1");
    }

    @Test
    public LoginPage openLoginPage( ) {
        driver = Application.getDriver();
        driver.get("http://test.biz.ua");
        return new LoginPage();
    }
    @AfterTest
    public void close() {
        Application.closeDriver();
    }
}