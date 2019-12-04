package selenium.page;

import org.openqa.selenium.support.PageFactory;
import selenium.driver.Driver;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
    }
}
