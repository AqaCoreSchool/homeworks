package com.company.sqlTest.pages;

import org.openqa.selenium.WebDriver;

public class BaseTest {
    public WebDriver driver = Application.getDriver();

    public LoginPage openLoginPage(){
        driver.get("http://test.biz.ua");
        return new LoginPage();
    }
}
