package tests;

import data.LoginInfo;
import org.testng.annotations.Test;
import pages.ConfirmOrderPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PlacingOrderTest extends BaseTest{

    @Test
    public void TestPlacingOrder(){

        ConfirmOrderPage confirmOrderPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .moveToCartPage()
                .moveToCheckoutPage()
                .inputAllFields("Andrew", "Shtyiuk", "123")
                .moveToCheckoutOverview()
                .moveToConfirmOrderPage();

        assertThat(confirmOrderPage.getConfirmMessage().getText())
                .as("Confirm Error").isEqualTo("THANK YOU FOR YOUR ORDER");
    }
}
