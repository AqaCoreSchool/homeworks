package orangetest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    public static final String PASSWORD = "Vfylhfujhf!1";
    public static final String LOGIN = "TestUser05";

    @BeforeTest
    public void beforeClass() {
        loginPage = openLoginPage();
    }

    @Test
    public void loginTest() {
        loginPage.loginIntoSystem(LOGIN, PASSWORD);
        Assert.assertTrue((driver.findElements(By.xpath("//a[@id='welcome']")).size() > 0));
    }

    @AfterTest
    public void tearDown(){
        //driver.close();
    }
}
