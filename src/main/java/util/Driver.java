package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Driver {
    public static WebDriver driver;
    private static final String URL = "http://test.biz.ua";

    public static WebDriver getInstance() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);

        return driver;
    }
}
