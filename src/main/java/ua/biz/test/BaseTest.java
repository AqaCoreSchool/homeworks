package ua.biz.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ua.biz.test.entity.Employee;
import ua.biz.test.pages.LoginPage;
import ua.biz.test.pages.MainPage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    private final String URL = "http://test.biz.ua/symfony/web/index.php/auth/login";

    @BeforeClass
    protected void configure() {
        Path driverPath = Paths.get("src","main", "resources");
        System.setProperty("webdriver.chrome.driver", driverPath + File.separator + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(URL);
        mainPage = new LoginPage(driver).login(driver);
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}
