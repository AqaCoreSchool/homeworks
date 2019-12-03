package apps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    private WebDriver driver;
    WebDriverWait wait;
    public WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
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
