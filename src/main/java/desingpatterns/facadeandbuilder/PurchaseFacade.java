package desingpatterns.facadeandbuilder;

import desingpatterns.facadeandbuilder.pages.ItemPage;

public class PurchaseFacade {

    private ItemPage itemPage;

    public void purchaseItem(String itemUrl, ClientInfo clientInfo) {
        // code implementation
        itemPage.navigate(itemUrl)
                .clickBuyButton()
                .clickContinueAsGuestButton()
                .fillShippingInfo(clientInfo)
                .clickContinue()
                .finishPurchase();
    }
}
