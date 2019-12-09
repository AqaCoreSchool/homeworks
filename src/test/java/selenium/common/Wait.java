package selenium.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.driver.Driver;

public class Wait {
    public static WebDriverWait wait;

    private Wait(){

    }

    public static void waitForVisible(WebElement element) {
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
