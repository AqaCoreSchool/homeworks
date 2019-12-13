package testpackage.test;

import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.page.InventoryPage;
import testpackage.page.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AddProductTest extends BaseTest {

    private String login = "standard_user";
    private String password = "secret_sauce";

    @Test
    public void addProductTest() {
        InventoryPage inventoryPage = new LoginPage()
                .loginToTheSystem(login,password)
                .moveToMenu()
                .moveToAllItem()
                .addTShirtInInventory()
                .moveToMenu()
                .moveToAllItem()
                .addJacketInInventory()
                .moveToInventory();
        assertThat(inventoryPage.verifyItemList())
                .as("You have not added items or more than two").isTrue();
    }
}
