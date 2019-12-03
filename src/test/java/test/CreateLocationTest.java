package test;

import data.LocationData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OrangeAdminPage;
import pages.OrangeDashboardPage;
import pages.OrangeLoginPage;

public class CreateLocationTest {
    private WebDriver driver;
    private final String USERNAME = "TestUser06";
    private final String PASSWORD = "Vfylhfujhf!1";
    private final String URL = "http://test.biz.ua";
    LocationData location = new LocationData();

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

    @Test(priority = 1)
    public void createVacancyTest(){
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        OrangeDashboardPage dashboardPage = loginPage.loginCorrect(USERNAME, PASSWORD);
        OrangeAdminPage adminPage = dashboardPage.toAdminModulePage();
        adminPage.toOrganization().toLocations().createLocation(location);
        Assert.assertTrue(adminPage.findLocation(location), "Created location not found!");
    }
}
