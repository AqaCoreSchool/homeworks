import io.github.bonigarcia.wdm.WebDriverManager;
import orangehrm.OrangeDashboardPage;
import orangehrm.OrangeLoginPage;
import orangehrm.OrangeTimePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckEmptyPunchesTest {
    private WebDriver driver;
    private final String USERNAME = "TestUser06";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String WEEK_BEFORE = LocalDateTime.now().minusWeeks(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private final String URL = "http://test.biz.ua";

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
        timePage.checkEmptyRecordsTable(WEEK_BEFORE);
        Assert.assertTrue(timePage.getEmptyRecord().isDisplayed(), "Record table isn't empty!");
    }
}
