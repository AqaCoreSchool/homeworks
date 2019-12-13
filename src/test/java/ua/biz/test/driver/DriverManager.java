package ua.biz.test.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getBrowserInstance() {
       if(driverThreadLocal.get() ==null){
            WebDriverManager.chromedriver().setup();
            driverThreadLocal.set(new ChromeDriver());
       }
        return driverThreadLocal.get();
    }
}
