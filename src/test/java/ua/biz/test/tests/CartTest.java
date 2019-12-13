package ua.biz.test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseTest;
import ua.biz.test.pages.CartPage;

public class CartTest extends BaseTest {
    @Test
    public void testCart(){
        product = mainPage.getProduct();
        mainPage.addProductToCart(product);
        CartPage cartPage=mainPage.openCartPage();

        Assert.assertTrue(cartPage.isProductPresent(product),"Product isn't present");
    }
}
