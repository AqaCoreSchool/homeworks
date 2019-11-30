package automation;

import data.Candidate;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.testbiz.pages.HomePage;
import ua.testbiz.pages.LoginPage;
import ua.testbiz.pages.RecruitmentPage;
import util.Driver;

public class RecruitmentAutomationTest {
    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getInstance();
    }

    @org.testng.annotations.Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        loginPage.loginIntoSystem();
        Assert.assertTrue(homePage.isOpened(), "Not a home page");

        homePage.selectRecruitment();

        recruitmentPage.switchToCandidate();

        Candidate candidate = new Candidate();
        candidate.setCandidateInfo();
        recruitmentPage.addCandidate(candidate);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
