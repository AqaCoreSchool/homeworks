import io.github.bonigarcia.wdm.WebDriverManager;
import orangehrm.OrangeAdminPage;
import orangehrm.OrangeDashboardPage;
import orangehrm.OrangeLoginPage;
import orangehrm.OrangeMyInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeUserDataTest {
    private WebDriver driver;
    private final String USERNAME = "TestUser06";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String NAME = "Nazariy";
    private final String SURNAME = "Kushnir";
    private final String BIRTHDAY_DATE = "1989-10-23";
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
    public void changeUserDataAndCheckUsersTest(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeMyInfoPage infoPage = dashboardPage.toMyInfoPage();
        infoPage.editUserData(NAME, SURNAME, BIRTHDAY_DATE);
        OrangeAdminPage adminPage = infoPage.toAdminPage();
        adminPage.findUser(USERNAME);
        Assert.assertEquals(adminPage.getUserRecord().get(3).getText(), String.format("%s %s", NAME, SURNAME),
                "User name and surname in list is different!");
    }
}
