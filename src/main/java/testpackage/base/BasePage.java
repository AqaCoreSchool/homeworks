package testpackage.base;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testpackage.manager.DriverManager;

public class BasePage {
    public final WebDriverWait wait;

    public  BasePage(){
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
        wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 10);
    }

}
