package selenium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.driver.Driver;
import selenium.model.User;
import selenium.model.Vacancy;
import selenium.page.LoginPage;

public class BaseTest {
    private LoginPage loginPage;
    private User user;
    private Vacancy vacancy;

    public LoginPage openLoginPage() {
        return new LoginPage();
    }

    @BeforeMethod
    public void setup() {
        loginPage = openLoginPage();
        vacancy = new Vacancy();
        user = new User();
    }

    @AfterMethod
    public void teardown() {
        Driver.getInstance().quitDriver();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public User getUser() {
        return user;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }
}
