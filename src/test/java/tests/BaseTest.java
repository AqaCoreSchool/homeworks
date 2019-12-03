package tests;

import data.UserInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;


public class BaseTest {
    WebDriver driver;
    LoginPage loginPage ;

    @BeforeTest
    public void setup(){
        loginPage = openLoginPage();
    }

    @AfterTest(alwaysRun = true)
    public void shutDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public LoginPage openLoginPage(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        driver.get(UserInfo.URL);
        return  new LoginPage(driver);
    }




}
