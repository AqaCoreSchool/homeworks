package com.company.vTests.tests;

import com.company.vTests.base.BaseTest;
import com.company.vTests.pages.BasketPage;
import com.company.vTests.pages.LoginPage;
import com.company.vTests.pages.MainMenuPage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class checkProductsTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void testNegativeCandidates() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("standard_user", "secret_sauce")
                .addTwoProducts()
                .moveToShoppingBasket();
        BasketPage basket = new BasketPage();
        assertThat(basket.verifyProductBasket("Sauce Labs Backpack")).as("Products don't present").isTrue();

        basket.clickCheckout()
        .fillUserInfo("Olya","Bilynska","79059")
        .moveToBasket();
    }

}