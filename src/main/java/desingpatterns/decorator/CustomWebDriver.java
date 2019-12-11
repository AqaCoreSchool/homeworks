package desingpatterns.decorator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;


public abstract class CustomWebDriver implements WebDriver, JavascriptExecutor, HasCapabilities, TakesScreenshot {

    protected WebDriver driver;

    public CustomWebDriver(WebDriver driver) {
        driver = driver;
    }
}
