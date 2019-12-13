package automation.exam.page;

import automation.exam.util.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    @FindBy(xpath = "//div[@class='cart_list']//div[@class='cart_item']")
    private List<WebElement> cartItemList;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    private WebElement checkoutButton;

    public CartPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public boolean checkProduct(){
        return (cartItemList.size() == 2);
    }

    public InformationPage switchToCheckout(){
        checkoutButton.click();
        return new InformationPage();
    }
}
