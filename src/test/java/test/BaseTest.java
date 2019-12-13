package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.WebDriverFactory;

public class BaseTest {
    static final String USERNAME = "standard_user";
    static final String PASSWORD = "secret_sauce";
    static final String URL = "https://www.saucedemo.com/index.html";
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

    public LoginPage openLoginPage() {
        return new LoginPage(driver);
    }
}
