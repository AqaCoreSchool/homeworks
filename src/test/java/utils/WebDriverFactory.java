package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    public static WebDriver setupDriver() {
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        driverLocal.set(new ChromeDriver());
        return driverLocal.get();
    }

    public static WebDriver getDriver(){
        return driverLocal.get();
    }
}
