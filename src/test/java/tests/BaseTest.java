package tests;

import apps.Application;
import data.UserInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;


public class BaseTest {

    public LoginPage loginPage ;
    private WebDriver driver = Application.getDriver();

    @BeforeTest
    public void setup(){
        loginPage = openLoginPage();
    }

    @AfterTest(alwaysRun = true)
    public void shutDownDriver() {
        Application.closeDriver();
    }


    public LoginPage openLoginPage(){
        driver.get(UserInfo.URL);
        return  new LoginPage();
    }




}
