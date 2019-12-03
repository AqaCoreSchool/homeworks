package test;

import data.CandidateData;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeDashboardPage;
import pages.OrangeLoginPage;
import pages.OrangeRecruitmentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplyCandidateTest {
    private WebDriver driver;
    private final String USERNAME = "TestUser06";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String URL = "http://test.biz.ua";
    private CandidateData candidateData = new CandidateData("TEST_VACANCY_IMO", "Ivan Mosiychuk");

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void applyCandidateToVacancy(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toCandidates().applyCandidate(candidateData);
        recruitmentPage.clickBackBtn();
        Assert.assertTrue(recruitmentPage.findCreatedCandidate(candidateData), "Created candidate not found!");

    }

    @Test(priority = 2)
    public void applyCandidateForFuture(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toCandidates().applyCandidateForFuture(candidateData);
        Assert.assertTrue( recruitmentPage.futureDateErrorDisplayed(), "Error notification not displayed");

    }
}