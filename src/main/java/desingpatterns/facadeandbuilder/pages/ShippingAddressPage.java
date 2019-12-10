package desingpatterns.facadeandbuilder.pages;

import desingpatterns.facadeandbuilder.ClientInfo;

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
