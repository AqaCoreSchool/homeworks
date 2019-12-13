package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class LoginTest extends BaseTest{

    @Test
    public void testLogin(){
        InventoryPage inventoryPage = openLoginPage().loginCorrect(USERNAME, PASSWORD);
        Assert.assertEquals(inventoryPage.getTitle(), "Swag Labs");
        Assert.assertEquals(inventoryPage.getUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
