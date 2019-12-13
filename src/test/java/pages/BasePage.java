package pages;

import org.openqa.selenium.support.PageFactory;
import utils.Application;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Application.getDriver(), this);
    }
}
