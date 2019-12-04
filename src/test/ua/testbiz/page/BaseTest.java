package ua.testbiz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import util.Application;

public class BaseTest {
    protected WebDriverWait wait;
    private static final String URL = "http://test.biz.ua";

    @BeforeMethod
    public void setUp() {
        WebDriver driver = Application.getDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        wait = new WebDriverWait(driver, 5);

    }

    @AfterSuite
    public void tearDown() {
        Application.closeDriver();
    }
}
