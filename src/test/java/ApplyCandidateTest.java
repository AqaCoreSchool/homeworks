import io.github.bonigarcia.wdm.WebDriverManager;
import orangehrm.OrangeDashboardPage;
import orangehrm.OrangeLoginPage;
import orangehrm.OrangeRecruitmentPage;
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
    private final String CANDIDATE_NAME = "John";
    private final String CANDIDATE_LASTNAME = "Doe";
    private final String CANDIDATE_MAIL = "mail@mail.com";
    private final String CONTACT_NUMBER = "0688442616";
    private final String VACANCY_NAME = "Test vacancy";
    private final String MANAGER_NAME = "Nazariy Kushnir";
    private final String DESCRIPTION = "Vacancy Description";
    private final String DATE = "2019-11-30";
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
    public void applyCandidateToVacancy(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toCandidates().applyCandidate(CANDIDATE_NAME, CANDIDATE_LASTNAME, CANDIDATE_MAIL,
                CONTACT_NUMBER, VACANCY_NAME, DESCRIPTION, DATE);
        recruitmentPage.clickBackBtn().findCreatedCandidate(CANDIDATE_NAME, CANDIDATE_LASTNAME, MANAGER_NAME,
                VACANCY_NAME, DATE);
        Assert.assertTrue(recruitmentPage.getCreatedCandidate().isDisplayed(), "Created candidate not found!");

    }
}