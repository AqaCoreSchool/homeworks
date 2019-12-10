package desingpatterns.facade;

import desingpatterns.facade.pages.ItemPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PurchaseTest {

    private ItemPage itemPage;
    private String itemUrl;
    private ClientInfo clientInfo;
    private PurchaseFacade purchaseFacade;


    @BeforeTest
    public void setup() {
        itemPage = new ItemPage();
        itemUrl = "/casio-45g20";
        clientInfo = new ClientInfo("Corey Taylor", "USA, CA, LA, Washington Str. 8");
    }

    @Test
    public void testPurchaseWithoutFacade() {
        itemPage.navigate(itemUrl)
                .clickBuyButton()
                .clickContinueAsGuestButton()
                .fillShippingInfo(clientInfo)
                .clickContinue()
                .finishPurchase();
    }

    @Test
    public void testPurchaseWithFacade() {
        purchaseFacade.purchaseItem(itemUrl, clientInfo);
    }


}
