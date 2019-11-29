package testpackage.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {

    public WebDriver driver =BasePage.getInstance().getDriver();

    @AfterTest
    public void  close(){
        driver.close();
    }
}
