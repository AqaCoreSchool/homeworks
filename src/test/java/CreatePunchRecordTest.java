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

public class CreatePunchRecordTest {
    private WebDriver driver;
    private final String USERNAME = "TestUser06";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String START_MESSAGE = "Start work TEST!";
    private final String END_MESSAGE = "Stop work TEST!";
    private final String TODAY_DATE = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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
    public void createPunchAndCheckRecordDataTest(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeTimePage timePage = dashboardPage.toTimeModulePage();
        timePage.createPunch(START_MESSAGE);
        timePage.createPunch(END_MESSAGE);
        timePage.checkPunchInRecordsTable(TODAY_DATE);
        Assert.assertEquals(timePage.getLatestRecordPunchIn().getText(), timePage.getPunchInDateTime(),
                "record Punch In datetime is different then actual Punch In datetime!");
        Assert.assertEquals(timePage.getLatestRecordPunchInNote().getText(), START_MESSAGE,
                "record Punch In note is different then actual Punch In note!");
        Assert.assertEquals(timePage.getLatestRecordPunchOut().getText(), timePage.getPunchOutDateTime(),
                "record Punch Out datetime is different then actual Punch Out datetime!");
        Assert.assertEquals(timePage.getLatestRecordPunchOutNote().getText(), END_MESSAGE,
                "record Punch Out datetime is different then actual Punch Out datetime!");
    }
}
