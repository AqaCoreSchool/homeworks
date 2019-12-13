package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ShoppingCart;

public class ShoppingCartTest extends BaseTest {
    @Test
    public void shoppingCartTest() {
        ShoppingCart page = getLoginPage()
                .fillUserName()
                .fillUserPassword()
                .clickLoginButton()
                .addToCart("Backpack")
                .addToCart("Sauce Labs Onesie")
                .goToShoppingCart();

        Assert.assertEquals(page.getCartSize(), "2");
    }
}
