package desingpatterns.facadeandbuilder.pages;

public class SignInPage {

    public ShippingAddressPage clickContinueAsGuestButton() {
        // code implementation
        return new ShippingAddressPage();
    }
}
