package ua.biz.test.base;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ua.biz.test.driver.DriverManager;
import ua.biz.test.entity.*;
import ua.biz.test.pages.LoginPage;
import ua.biz.test.pages.MainPage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class BaseTest {


    protected WebDriver driver;
    protected MainPage mainPage;
    protected Faker faker = new Faker();


    protected final Employee MY_TEST_EMPLOYEE
            = new Employee("Ivan", "Mosiychuk");
    protected final Vacancy TEST_VACANCY =
            new Vacancy("Engineer of automatization", MY_TEST_EMPLOYEE, 2, true);
    protected final Candidate TEST_CANDIDATE =
            new Candidate("Oleg", "Olegov", "Oleg@mail.ua", TEST_VACANCY);
    protected final Location TEST_LOCATION =
            new Location("A" + faker.name(), "Ukraine", "Lviv", 4657);
    protected final PunchData TEST_PUNCH_DATA =
            new PunchData(" PunchIn", "PunchOut");

    private final String URL = "http://test.biz.ua/symfony/web/index.php/auth/login";

    @BeforeSuite(alwaysRun = true)
    public void init() {
        Path driverPath = Paths.get("src", "main", "resources");
        System.setProperty("webdriver.chrome.driver", driverPath + File.separator + "chromedriver.exe");
        driver = DriverManager.getBrowserInstance();
        driver.manage().window().maximize();
        driver.get(URL);
        new LoginPage(DriverManager.getBrowserInstance()).login();
    }

    @BeforeMethod(alwaysRun = true)
    protected void configure() {
        mainPage = new MainPage();
    }

    @AfterSuite(alwaysRun = true)
    protected void tearDown() {
        driver.quit();
    }
}
