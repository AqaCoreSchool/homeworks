package com.testBiz.util.driver;

import com.testBiz.data.Url;
import org.openqa.selenium.WebDriver;

public class Driver {
    private static volatile Driver singleton;
    private ThreadLocal<WebDriver> drivers;

    private Driver() {
        drivers = new ThreadLocal<>();
    }

    public static Driver getInstance() {
        if (singleton == null) {
            synchronized (Driver.class) {
                if (singleton == null) {
                    singleton = new Driver();
                }
            }
        }
        return singleton;
    }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            synchronized (this) {
                if (drivers.get() == null) {
                    drivers.set(new WebDriverFactory().getDriver(DriverType.CHROME));
                    drivers.get().get(Url.BASE_URL);
                }
            }
        }
        return drivers.get();
    }

    public synchronized boolean quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.remove();
            return true;
        }
        return false;
    }
}