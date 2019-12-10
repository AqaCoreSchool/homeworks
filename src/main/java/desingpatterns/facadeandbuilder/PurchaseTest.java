package desingpatterns.facadeandbuilder;

import desingpatterns.facadeandbuilder.pages.ItemPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class PurchaseTest {

    private ItemPage itemPage;
    private String itemUrl;
    private ClientInfo clientInfo;
    private PurchaseFacade purchaseFacade;


    @BeforeTest
    public void setup() {
        itemPage = new ItemPage();
        itemUrl = "/casio-45g20";
        clientInfo = new ClientInfo.Builder()
                .setName("Corey")
                .setSurname("Taylor")
                .setAddress("USA, CA, LA, Washington Str. 8")
                .setCardNumber("8888 4505 0001 5555")
                .setPassport("qwery57")
                .setShippingDate(LocalDate.now().plusDays(3))
                .build();
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
