package automation.exam;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import automation.exam.util.Application;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String URL = "https://www.saucedemo.com/index.html";

    @BeforeSuite
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