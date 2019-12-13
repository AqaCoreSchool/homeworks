package testpackage.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import testpackage.manager.DriverManager;
import testpackage.page.LoginPage;

public class BaseTest {
    public WebDriver driver = DriverManager.getInstance().getDriver();

    @BeforeTest
    public LoginPage openLoginPage() {
        driver.get("https://www.saucedemo.com/index.html");
        return new LoginPage();
    }

    @AfterTest
    public void  close(){
        try {if (driver!= null){
            driver.quit();
        }
        }finally {
            driver = null;
        }
    }
}
