package orangetest.tests;

import orangetest.pages.LoginPage;
import orangetest.utils.Application;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {
    public WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        driver = Application.getDriver();
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser05", "Vfylhfujhf!1");
    }

    @Test
    public LoginPage openLoginPage() {
        driver = Application.getDriver();
        driver.get("http://test.biz.ua");
        return new LoginPage();
    }

    @AfterClass(alwaysRun = true)
    public void close() {
        Application.closeDriver();
    }
}