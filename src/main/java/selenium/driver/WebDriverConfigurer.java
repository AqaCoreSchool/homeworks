package selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class WebDriverConfigurer {
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String userDir = System.getProperty("user.dir");

    public WebDriver getChromeDriver() {
        Path path = Paths.get(userDir, "src", "main", "resources");
        if (OS.contains("win")) {
            System.setProperty("webdriver.chrome.driver", path + File.separator + "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", path + File.separator + "chromedriver");
        }
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }
}
