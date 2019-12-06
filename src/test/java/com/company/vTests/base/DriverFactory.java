package com.company.vTests.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory{
    private WebDriver driver;

    public WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
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

