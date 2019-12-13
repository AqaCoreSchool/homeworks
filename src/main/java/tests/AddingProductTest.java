package tests;

import data.LoginInfo;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;

public class AddingProductTest extends BaseTest{

    @Test
    public void TestAddingProduct(){
        MainPage mainPage = new MainPage();
        loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .addProductToCart(mainPage.getBackPack())
                .addProductToCart(mainPage.getJacket())
                .moveToCartPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mainPage.getBackPack().getText(), "Sauce Labs Backpack");
        softAssert.assertEquals(mainPage.getJacket().getText(), "Sauce Labs Fleece Jacket");
        softAssert.assertAll();
    }
}
