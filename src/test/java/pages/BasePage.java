package pages;


import apps.Application;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Application.getDriver(), this);
    }
}
