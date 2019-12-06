package ua.testbiz.page;

import data.Location;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.Application;
import util.Convertable;

import java.util.List;
import java.util.Random;

public class LocationPage implements Convertable {
    @FindBy(xpath = "//a[@id='menu_admin_Organization']")
    private WebElement organizationOption;

    @FindBy(xpath = "//a[@id='menu_admin_viewLocations']")
    private WebElement locationSubMenu;

    @FindBy(xpath = "//input[@id='btnAdd']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='even' or @class='odd']")
    private List<WebElement> locationTable;

    // location form
    @FindBy(xpath = "//input[@id='location_name']")
    private WebElement nameInput;

    @FindBy(xpath = "//select[@id='location_country']")
    private WebElement countrySelect;

    @FindBy(xpath = "//input[@id='location_province']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='location_city']")
    private WebElement cityInput;

    @FindBy(xpath = "//textarea[@id='location_address']")
    private WebElement addressTextArea;

    @FindBy(xpath = "//input[@id='location_zipCode']")
    private WebElement postalCodeInput;

    // search
    @FindBy(xpath = "//input[@id='searchLocation_name']")
    private WebElement searchNameInput;

    @FindBy(xpath = "//input[@id='searchLocation_city']")
    private WebElement searchCityInput;

    @FindBy(xpath = "//select[@id='searchLocation_country']")
    private WebElement searchCountrySelect;

    @FindBy(xpath = "//input[@id='btnSearch']")
    private WebElement searchButton;

    private JSONObject jsonLocation;

    public LocationPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public void addLocation(Location location) {
        jsonLocation = convertToJson(location);

        organizationOption.click();
        locationSubMenu.click();
        addButton.click();

        nameInput.sendKeys(location.getLocationName());

        Select countySelect = new Select(countrySelect);
        location.setLocationCountryIndex(new Random().nextInt(countySelect.getOptions().size()));
        countySelect.selectByIndex(location.getLocationCountryIndex());

        stateInput.sendKeys(location.getLocationState());
        cityInput.sendKeys(location.getLocationCity());
        addressTextArea.sendKeys(location.getLocationAddress());
        postalCodeInput.sendKeys(location.getLocationPostalCode());

        saveButton.click();

    }

    public boolean isLocationInList(Location location) {

        for (WebElement element : locationTable) {
            if (element.getText().startsWith(String.join(" ", location.getLocationName(), location.getLocationCity()))) {
                System.out.println("Location exist: " + element.getText());
                return true;
            }
        }
        return false;
    }

    public void searchLocationByJSON() {
        Location loc = (Location) Convertable.super.getObject(jsonLocation, Location.class);
        searchNameInput.sendKeys(loc.getLocationName());
        searchCityInput.sendKeys(loc.getLocationCity());

        searchButton.click();
    }
}
