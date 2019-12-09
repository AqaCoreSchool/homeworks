package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.OrangeLoginPage;
import utils.WebDriverFactory;

public class BaseTest {
    static final String USERNAME = "TestUser06";
    static final String PASSWORD = "Vfylhfujhf!1";
    static final String URL = "http://test.biz.ua";
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        if(driver==null){
            driver = WebDriverFactory.setupDriver();
            driver.manage().window().maximize();
            driver.get(URL);
        }
    }

    @AfterMethod
    public void tearDown(){
        try {
            if(driver != null){
                driver.quit();
            }
        } finally {
            driver = null;
        }
    }

    public OrangeLoginPage openLoginPage() {
        return new OrangeLoginPage(driver);
    }

}
