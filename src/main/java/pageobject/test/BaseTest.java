package pageobject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageobject.logic.LoginPage;

public class BaseTest {
    WebDriver driver;

    public LoginPage openLoginPage(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("http://test.biz.ua/");
        return  new LoginPage(driver);
    }




}
