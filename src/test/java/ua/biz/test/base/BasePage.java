package ua.biz.test.base;

import org.openqa.selenium.support.PageFactory;
import ua.biz.test.driver.DriverManager;

public class BasePage{

    public BasePage() {
        PageFactory.initElements(DriverManager.getBrowserInstance(), this);
    }
}
