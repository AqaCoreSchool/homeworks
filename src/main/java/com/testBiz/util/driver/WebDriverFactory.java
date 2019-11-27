package com.testBiz.util.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class WebDriverFactory {
    static final String localDirectory = System.getProperty("user.dir");

    public WebDriver getDriver(DriverType type) {
        switch (type) {
            case MOZILLA:
                return getMozillaDriver();
            case CHROME:
                return getChromeDriver();
            case EDGE:
                return getEdgeDriver();
            case IEXPLORER:
                return getInternetExplorerDriver();
            default:
                return getChromeDriver();
        }
    }

    private WebDriver getMozillaDriver() {
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        WebDriver mozillaDriver = new FirefoxDriver();
        mozillaDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mozillaDriver.manage().window().maximize();
        return mozillaDriver;
    }

    private WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", localDirectory + File.separator +"chromedriver.exe");
        //ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }

    private WebDriver getEdgeDriver() {
        EdgeDriverManager.getInstance(DriverManagerType.EDGE).setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        edgeDriver.manage().window().maximize();
        return edgeDriver;
    }

    private WebDriver getInternetExplorerDriver() {
        InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
        WebDriver internetExplorerDriver = new InternetExplorerDriver();
        internetExplorerDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        internetExplorerDriver.manage().window().maximize();
        return internetExplorerDriver;
    }
}