package desingpatterns.facadeandbuilder.pages;

public class ItemPage {

    public ItemPage navigate(String itemUrl) {
        // code implementation
        return new ItemPage();
    }

    public SignInPage clickBuyButton() {
        // code implementation
        return new SignInPage();
    }
}
