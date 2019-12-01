package automation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.testbiz.pages.HomePage;
import ua.testbiz.pages.LoginPage;
import ua.testbiz.pages.RecruitmentPage;
import util.Driver;

public class VacancyAutomationTest {
    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getInstance();
    }

    @org.testng.annotations.Test
    public void test() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectRecruitment();

        recruitmentPage.switchToVacancy();

        recruitmentPage.addVacancy();

        recruitmentPage.switchToVacancy();

        Assert.assertNotNull(recruitmentPage.checkVacancy(), "Vacancy is not found!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
