package orangetest.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final String PATH = Paths.get("src", "main", "resources", "chromedriver.exe").toString();
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        } else {
            return driver;
        }
    }

    public WebDriver closeDriver() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            driver = null;
        }
        return driver;
    }
}