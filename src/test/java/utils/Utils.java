package utils;

import apps.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class Utils {


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

    public void wait(int millisec){
        try {
            sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
