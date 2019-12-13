package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmOrderPage extends BasePage{

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement confirmMessage;

    public WebElement getConfirmMessage() {
        return confirmMessage;
    }
}
