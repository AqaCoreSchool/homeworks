package selenium.page;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.driver.Driver;

public class BasePage {
    WebDriverWait wait;
    public BasePage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
