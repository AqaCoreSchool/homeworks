package orangetest.utils;

import org.openqa.selenium.WebDriver;

public class Application {
    private static ThreadLocal<DriverFactory> driverInstance = ThreadLocal.withInitial(DriverFactory::new);

    public static WebDriver getDriver() {
        return driverInstance.get().getDriver();
    }

    public static WebDriver closeDriver() {
        return driverInstance.get().closeDriver();
    }
}