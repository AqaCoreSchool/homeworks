package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public void waitUntilIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 10, 50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilIsSelected(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 10, 50);
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }


}