package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    private ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setUp(){
        if(driverLocal.get()==null){
            driverLocal.set(WebDriverFactory.getDriver());
            driverLocal.get().manage().window().maximize();
            driverLocal.get().get(URL);
        }
    }

    @AfterMethod
    public void tearDown(){
        try {
            if(driverLocal.get() != null){
                driverLocal.get().quit();
            }
        } finally {
                driverLocal.set(null);
            }
    }

    public OrangeLoginPage openLoginPage() {
        return new OrangeLoginPage(driverLocal.get());
    }
}
