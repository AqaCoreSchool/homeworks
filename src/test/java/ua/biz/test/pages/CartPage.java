package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.Product;
import ua.biz.test.utils.WaitUtil;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart_list']")
    private List<WebElement> productsList;
    @FindBy(className = "btn_primary btn_inventory")
    private WebElement productName;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement productPrise;

    @FindBy(xpath = "//div[@class='subheader']")
    private WebElement title;



    public boolean isProductPresent(Product product) {
        WaitUtil.waitForVisible(productName);
        return productName.getText().
                equals(product.getName())
                && productPrise.getText().equals(product.getPrice());
    }
}
