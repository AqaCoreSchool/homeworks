package pages;

import org.openqa.selenium.support.PageFactory;
import utils.WebDriverFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }
}
