package test;

import data.PunchData;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeDashboardPage;
import pages.OrangeLoginPage;
import pages.OrangeTimePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckEmptyPunchesTest {
    private WebDriver driver;
    private final String USERNAME = "TestUser06";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String URL = "http://test.biz.ua";
    private PunchData punch = new PunchData();

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

    @Test
    public void recordsTableIsEmptyTest(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeTimePage timePage = dashboardPage.toTimeModulePage();
        timePage.checkEmptyRecordsTable(punch.getWeekAfter());
        Assert.assertTrue(timePage.getEmptyRecord().isDisplayed(), "Record table isn't empty!");
    }
}
