package page;

import driver.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
    }
}
