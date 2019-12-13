package testpackage.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    private List<String> itemNameList;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> cartItem;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    private WebElement checkoutBtn;

    public List<String> getItemNameList(){
        itemNameList = cartItem.stream().map(WebElement::getText)
                .collect(Collectors.toList());
        return itemNameList;
    }

    public boolean verifyItemList(){
        if((getItemNameList().size() == 2)&&(getItemNameList().isEmpty())){
            return true;
        }else {
            return false;
        }
    }

    public CheckoutPage moveToCheckout(){
        checkoutBtn.click();
        return new CheckoutPage();
    }
}
