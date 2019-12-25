package orangetest.tests;

import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String PATH = Paths.get("src", "main", "resources", "chromedriver.exe").toString();
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser05", "Vfylhfujhf!1");
    }

    @Test
    public LoginPage openLoginPage() {
        System.setProperty("webdriver.chrome.driver", PATH);
        driver = new ChromeDriver();
        driver.get("http://test.biz.ua");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return new LoginPage(driver);
    }

    @AfterClass (alwaysRun = true)
    public void close() {
        driver.close();
    }
}