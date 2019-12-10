package desingpatterns.facade.pages;

import desingpatterns.facade.ClientInfo;

public class ShippingAddressPage {

    public ShippingAddressPage fillShippingInfo(ClientInfo clientInfo) {
        clientInfo.getAddress();
        clientInfo.getName();
        // code implementation
        return new ShippingAddressPage();
    }

    public CheckoutPage clickContinue() {
        // code implementation
        return new CheckoutPage();
    }
}
