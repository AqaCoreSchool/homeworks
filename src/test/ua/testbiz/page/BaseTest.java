package ua.testbiz.page;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import util.Application;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String URL = "http://test.biz.ua";

    @BeforeMethod
    public void setUp() {
        WebDriver driver = Application.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterSuite
    public void tearDown() {
        Application.closeDriver();
    }
}
