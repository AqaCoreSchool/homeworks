package desingpatterns.facade;

import desingpatterns.facade.pages.ItemPage;

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
