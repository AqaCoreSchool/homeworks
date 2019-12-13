package automation.exam;

import automation.exam.page.CartPage;
import automation.exam.page.HomePage;
import automation.exam.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationTest extends BaseTest {
    @Test
    public void verifyLogin() {
        boolean isAuthorized =
                new LoginPage()
                        .loginIntoSystem()
                        .verify();

        Assert.assertTrue(isAuthorized, "Not logged in!");
    }

    @Test(dependsOnMethods = "verifyLogin")
    public void test1() {
        boolean hasProduct =
                new HomePage()
                        .sortList()
                        .addProduct()
                        .switchToShoppingCart()
                        .checkProduct();
        Assert.assertTrue(hasProduct, "Threre arent 2 products!");

    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        boolean isComplete =
                new CartPage()
                        .switchToCheckout()
                        .fillInformation()
                        .confirmInformation()
                        .continuePayment()
                        .isOrderComplete();

        Assert.assertTrue(isComplete, "Payment is not completed!");
    }
}
