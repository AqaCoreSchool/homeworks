package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemcartPage extends BasePage{
    private final WebDriver driver;

    @FindBy(className = "cart_list")
    private List<WebElement> itemsList;

    public ItemcartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int getItemCartSize() {
        return itemsList.size();
    }
}
