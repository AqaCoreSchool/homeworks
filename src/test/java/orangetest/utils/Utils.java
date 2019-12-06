package orangetest.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static void waitUntilIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 8, 50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilIsSelected(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Application.getDriver(), 8, 50);
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }


}