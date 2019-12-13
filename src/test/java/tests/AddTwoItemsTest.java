package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class AddTwoItemsTest extends BaseTest {

    @Test
    public void byTwoItems(){
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.addItemsToCart().openShoppingCart().isTwoItems());
    }
}
