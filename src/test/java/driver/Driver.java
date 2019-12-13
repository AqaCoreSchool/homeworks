package driver;

import common.Common;
import org.openqa.selenium.WebDriver;

public class Driver {
    private static volatile Driver instance;
    private ThreadLocal<WebDriver> drivers;

    private Driver() {
        drivers = new ThreadLocal<>();
    }

    public static Driver getInstance() {
        if (instance == null) {
            synchronized (Driver.class) {
                if (instance == null) {
                    instance = new Driver();
                }
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            synchronized (Driver.class) {
                if (drivers.get() == null) {
                    drivers.set(new WebDriverConfigurer().getChromeDriver());
                    drivers.get().get(Common.getProperty("url"));
                }
            }
        }
        return drivers.get();
    }

    public synchronized void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.remove();
        }
    }
}
