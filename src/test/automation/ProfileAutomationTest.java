package automation;

import data.UserInformation;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.testbiz.pages.EmployeeListPage;
import ua.testbiz.pages.HomePage;
import ua.testbiz.pages.LoginPage;
import ua.testbiz.pages.PersonalDetailsPage;
import util.Driver;

public class ProfileAutomationTest {
    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getInstance();
    }

    @org.testng.annotations.Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(driver);
        EmployeeListPage employeeListPage = new EmployeeListPage(driver);

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectMyInfo();

        UserInformation userInformation = new UserInformation();
        userInformation.setUserInformation();
        personalDetailsPage.setPersonalDetail(userInformation);

        homePage.selectPim();
        employeeListPage.checkEmployee(userInformation);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
