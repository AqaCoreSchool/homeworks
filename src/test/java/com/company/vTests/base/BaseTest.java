package com.company.vTests.base;

import com.company.vTests.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {
    public WebDriver driver = Application.getDriver();

    public LoginPage openLoginPage(){
        driver.get("https://www.saucedemo.com/index.html");
        return new LoginPage();
    }
    @AfterTest
    public void close(){
        Application.closeDriver();
    }
}
