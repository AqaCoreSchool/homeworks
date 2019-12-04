package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testpackage.base.BasePage;
import testpackage.entity.Location;

import java.util.List;

public class LocationPage extends BasePage {

    @FindBy(id = "btnAdd")
    private WebElement addButton;

    @FindBy(id = "btnSave")
    private WebElement saveBtn;

    @FindBy(id = "location_name")
    private WebElement locationName;

    @FindBy(id = "location_country")
    private WebElement locationCountry;

    @FindBy(id = "location_city")
    private WebElement locationCity;

    @FindBy(id = "location_address")
    private WebElement locationAddress;

    @FindBy(id = "location_zipCode")
    private WebElement locationZipCode;

    @FindBy(id = "location_phone")
    private WebElement locationPhone;

    @FindBy(xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> table;

    public LocationPage createLocation(Location location ){
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(locationName));
        locationName.sendKeys(location.getName());
        locationCountry.sendKeys(location.getCountry());
        locationCity.sendKeys(location.getCity());
        locationAddress.sendKeys(location.getAddress());
        locationPhone.sendKeys(location.getPhoneNumber());
        locationZipCode.sendKeys(location.getPostalCode());
        saveBtn.click();
        return this;
    }

    public boolean filterTable(Location location){
        boolean locations = table.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(location.getName())
                        &e.contains(location.getCity())
                        &e.contains(location.getCountry())
                        &e.contains(location.getPhoneNumber()));
        return locations;
    }
}
