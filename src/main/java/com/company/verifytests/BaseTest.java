package com.company.verifytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;

    public LoginPage openLoginPage(){
        String userDir = System.getProperty("user.home");
        System.setProperty("webdriver.chrome.driver", userDir + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://test.biz.ua");
        return new LoginPage(driver);
    }
}
