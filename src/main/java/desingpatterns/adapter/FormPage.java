package desingpatterns.adapter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FormPage {

    @FindBy(css = ".email")
    private WebElement email;

    @FindBy(css = ".phone")
    private WebElement phone;

    @FindBy(css = ".city")
    private WebElement city;

    @FindBy(css = ".country")
    private WebElement country;

    @FindBy(css = ".region")
    private WebElement region;


    public List<WebElement> fields = new ArrayList<>();

    public List<WebElement> getFields() {
        fields.add(email);
        fields.add(phone);
        fields.add(city);
        fields.add(country);
        fields.add(region);
        return fields;
    }

    public FormPage selectForm(FormList formName) {
        formName.getName();
        // code implementation
        return new FormPage();
    }

    public FormPage clearInputFields() {
        // code implementation
        return new FormPage();
    }

    public FormPage confirmChanges() {
        // code implementation
        return new FormPage();
    }
}
