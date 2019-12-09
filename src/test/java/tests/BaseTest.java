package tests;

import apps.Application;
import data.LoginInfo;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;


public class BaseTest {

    public LoginPage loginPage ;
    private WebDriver driver = Application.getDriver();

    @BeforeMethod
    public void login(){
        loginPage = openLoginPage();
    }

    @AfterTest(alwaysRun = true)
    public void shutDownDriver() {
        Application.closeDriver();
    }


    public LoginPage openLoginPage(){
        driver.get(LoginInfo.URL);
        return  new LoginPage();
    }




}
