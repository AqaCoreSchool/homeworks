package com.company.vTests.tests;

import com.company.vTests.base.BaseTest;
import com.company.vTests.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    LoginPage loginPage;


    @Test
    public void testLogin() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isLogoDisplayed());
    }
}
