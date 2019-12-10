package desingpatterns.facade.pages;

public class SignInPage {

    public ShippingAddressPage clickContinueAsGuestButton() {
        // code implementation
        return new ShippingAddressPage();
    }
}
