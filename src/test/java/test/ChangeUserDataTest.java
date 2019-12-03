package test;

import data.UserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeAdminPage;
import pages.OrangeDashboardPage;
import pages.OrangeLoginPage;
import pages.OrangeMyInfoPage;
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
    private final String URL = "http://test.biz.ua";
    UserData userData = new UserData();

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
        infoPage.editUserData(userData);
        OrangeAdminPage adminPage = infoPage.toAdminPage();
        Assert.assertTrue(adminPage.findUser(USERNAME, userData),
                "User name and surname in list is different!");
    }
}
