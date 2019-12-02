package testpackage.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import testpackage.manager.DriverManager;
import testpackage.pages.LoginPage;

public class BaseTest {

    public WebDriver driver = DriverManager.getInstance().getDriver();

    @BeforeTest
    public LoginPage openLoginPage() {
        driver.get("http://test.biz.ua/");
        return new LoginPage();
    }

    @AfterTest
    public void  close(){
        driver.quit();
    }
}
