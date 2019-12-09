package selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.Wait;

public class CreateLocationPage extends BasePage {

    @FindBy(id = "frmLocation")
    private WebElement locationForm;

    @FindBy(id = "location_name")
    private WebElement locationName;

    @FindBy(id = "location_country")
    private WebElement locationCountry;

    @FindBy(id = "location_city")
    private WebElement locationCity;

    @FindBy(id = "location_phone")
    private WebElement locationPhone;

    @FindBy(id = "btnSave")
    private WebElement btnSave;

    public CreateLocationPage fillLocationName(String name) {
        Wait.waitForVisible(locationCity);
        locationName.sendKeys(name);
        return this;
    }

    public CreateLocationPage fillCountry(String country) {
        locationCountry.sendKeys(country, Keys.ENTER);
        return this;
    }

    public CreateLocationPage fillCity(String city) {
        locationCity.sendKeys(city);
        return this;
    }

    public CreateLocationPage fillPhone(String phone) {
        locationPhone.sendKeys(phone);
        return this;
    }

    public CreateLocationPage saveLocation() {
        Wait.waitForVisible(btnSave);
        btnSave.click();
        return this;
    }

    public LocationPage toLocationPage() {
        return new LocationPage();
    }
}
