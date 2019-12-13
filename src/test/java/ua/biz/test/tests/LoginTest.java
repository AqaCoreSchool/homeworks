package ua.biz.test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void testUserLogin(){
        Assert.assertTrue(mainPage.isOpened(),"Page is not opened");
    }
}
