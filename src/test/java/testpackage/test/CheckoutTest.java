package testpackage.test;

import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.page.CheckoutPage;
import testpackage.page.InventoryPage;
import testpackage.page.LoginPage;

public class CheckoutTest extends BaseTest {

    private String login = "standard_user";
    private String password = "secret_sauce";

    @Test
    public void checkoutTest() {
        CheckoutPage checkoutPage = new LoginPage()
                .loginToTheSystem(login, password)
                .moveToMenu()
                .moveToAllItem()
                .addTShirtInInventory()
                .moveToMenu()
                .moveToAllItem()
                .addJacketInInventory()
                .moveToInventory()
                .moveToCheckout();
    }
}
