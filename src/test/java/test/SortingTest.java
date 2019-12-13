package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class SortingTest extends BaseTest {

    @Test
    public void sortNameTest() {
        InventoryPage inventoryPage = openLoginPage().loginCorrect(USERNAME, PASSWORD);
        inventoryPage.sortByNameDesc();
//        Assert.assertTrue(inventoryPage.getFirstElementName().contains("Test.allTheThings() T-Shirt (Red)"));
    }

    @Test
    public void sortPriceTest() {
        InventoryPage inventoryPage = openLoginPage().loginCorrect(USERNAME, PASSWORD);
        inventoryPage.sortByPriceDesc();
//        Assert.assertTrue(inventoryPage.getFirstElementPrice().contains("$49.99"));
    }
}
