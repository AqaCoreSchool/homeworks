package com.company.sqlTest.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            this.driver = driver;
            return driver;
        } else {
            return driver;
        }
    }

    public WebDriver closeDriver(){
        try {
            if(driver != null){
                driver.quit();
            }
        } finally {
            driver = null;
        }
        return driver;
    }
}
