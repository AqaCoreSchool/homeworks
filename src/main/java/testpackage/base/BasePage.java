package testpackage.base;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private static BasePage instance;
    private ThreadLocal<WebDriver> drivers;

    private BasePage() {
        drivers = new ThreadLocal<>();
    }

    public WebDriver getChromeDriver() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            synchronized (this) {
                if (drivers.get() == null) {
                    drivers.set(getChromeDriver());
                }
            }
        }
        return drivers.get();
    }

    public static BasePage getInstance() {
        if (instance == null) {
            synchronized (BasePage.class) {
                if (instance == null) {
                    instance = new BasePage();
                }
            }
        }
        return instance;
    }
}
