package ua.biz.test.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.biz.test.driver.DriverManager;

public class WaitUtil {
    private static WebDriverWait wait;

    public static void waitAndClick(WebElement element) {
        waitAndClick(element, 5);
    }


    public static void waitAndClick(WebElement element, long sec) {
        wait = new WebDriverWait(DriverManager.getBrowserInstance(), sec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitAndType(WebElement element, String data) {
        waitAndType(element, data, 5);
    }

    public static void waitAndType(WebElement element, String data, long sec) {
        wait = new WebDriverWait(DriverManager.getBrowserInstance(), sec);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(data);
    }

    public static void waitAndClear(WebElement element) {
        waitAndClear(element, 5);
    }

    public static void waitAndClear(WebElement element, long sec) {
        wait = new WebDriverWait(DriverManager.getBrowserInstance(), sec);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    public static void waitForVisible(WebElement element) {
        waitForVisible(element, 5);
    }

    public static void waitForVisible(WebElement element, long sec) {
        wait = new WebDriverWait(DriverManager.getBrowserInstance(), sec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}