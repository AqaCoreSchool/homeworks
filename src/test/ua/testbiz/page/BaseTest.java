package ua.testbiz.page;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import util.Driver;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = Driver.getInstance();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
