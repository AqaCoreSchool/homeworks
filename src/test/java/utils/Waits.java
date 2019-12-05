package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    private WebDriverWait wait;

    public Waits(WebDriver driver){
        this.wait = new WebDriverWait(driver, 10);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisibilityByClass(String classname){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(classname)));
    }

    public void waitForInvisibilityByXpath(String xpath){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
}
