package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class HomePageTest extends BaseTest {
    @Test
    public void loginTest() {
        HomePage homePage = getLoginPage()
                .fillUserName()
                .fillUserPassword()
                .clickLoginButton()
                .addToCart("Backpack")
                .addToCart("Sauce Labs Onesie");

        Assert.assertTrue(homePage.isAppLogoVisible(), "AppLogo isn't visible. Check your credentials.");
    }
}
