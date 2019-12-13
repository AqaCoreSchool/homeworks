package ua.biz.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import ua.biz.test.driver.DriverManager;
import ua.biz.test.entity.Product;
import ua.biz.test.pages.LoginPage;
import ua.biz.test.pages.MainPage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class BaseTest {


    protected WebDriver driver;
    protected MainPage mainPage;
    protected Product product;


    private final String URL = "https://www.saucedemo.com/index.html";

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
