package utils;

import apps.Application;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

        public static void waitAndClick(WebElement element){
        WebDriverWait wait;
        wait = new WebDriverWait(Application.getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitAndSendKeys(WebElement element, String inputString){
        WebDriverWait wait;
        wait = new WebDriverWait(Application.getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(inputString);
    }
}
