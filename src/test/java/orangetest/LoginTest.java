package orangetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static orangetest.OrangeTest.*;

public class LoginTest {
    public static final String FIRST_NAME = "Mariana";
    public static final String LAST_NAME = "Mykytovych";
    public static final String MIDDLE_NAME = "Romanivna";
    public static final String BIRTHDAY = "1993-09-07";
    public static WebDriver driver;
    public static Actions actions;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", PATH);
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.get("http://test.biz.ua");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        WebElement login = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        login.sendKeys(LOGIN);
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys(PASSWORD);
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        submitButton.click();
        Assert.assertTrue((driver.findElements(By.xpath("//a[@id='welcome']")).size() > 0));
    }
}
