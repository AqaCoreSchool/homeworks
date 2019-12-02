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

public class CreateVacancyTest {
    private WebDriver driver;
    private final String USERNAME = "TestUser06";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String VACANCY_NAME = "Test vacancy";
    private final String MANAGER_NAME = "Nazariy Kushnir";
    private final String DESCRIPTION = "Vacancy Description";
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
    public void createVacancyTest(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeRecruitmentPage recruitmentPage = dashboardPage.toRecruitmentModulePage();
        recruitmentPage.toVacancies().createVacancy(VACANCY_NAME, MANAGER_NAME, DESCRIPTION);
        recruitmentPage.clickBackBtn().findCreatedVacancy(VACANCY_NAME, MANAGER_NAME);
        Assert.assertTrue(recruitmentPage.getCreatedVacancy().isDisplayed(), "Created vacancy not found!");

    }
}
