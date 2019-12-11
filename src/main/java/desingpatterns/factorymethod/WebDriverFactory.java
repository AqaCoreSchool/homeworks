package desingpatterns.factorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    public WebDriver createInstance(String browser) {
        if ("Chrome".equalsIgnoreCase(browser))
        {
            return new ChromeDriver();
        }
        else if ("InternetExplorer".equalsIgnoreCase(browser)) {
            return new InternetExplorerDriver();
        }
        else if ("Firefox".equalsIgnoreCase(browser)) {
            return new FirefoxDriver();
        }
        throw new IllegalStateException(String.format("Browser [%s] is not supported.", browser));
    }
}
