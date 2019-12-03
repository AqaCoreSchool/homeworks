package test;

import data.VacancyData;
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

public class CreateVacancyTest {
    private WebDriver driver;
    private final String USERNAME = "TestUser06";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String URL = "http://test.biz.ua";
    VacancyData vacancy = new VacancyData("Test vacancy", "Nazariy Kushnir");

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
    public void createVacancyTest(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toVacancies().createVacancy(vacancy);
        recruitmentPage.clickBackBtn();
        Assert.assertTrue(recruitmentPage.findCreatedVacancy(vacancy), "Created vacancy not found!");
    }

    @Test(priority = 2)
    public void createIncorrectVacancyTest(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toVacancies().createVacancyWithoutTitle(vacancy);
        Assert.assertTrue( recruitmentPage.noTitleErrorDisplayed(), "Error notification not displayed");
    }
}
