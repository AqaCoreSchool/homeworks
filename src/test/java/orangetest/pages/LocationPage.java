package orangetest.pages;

import io.qameta.allure.Step;
import orangetest.data.Location;
import orangetest.utils.JsonConverter;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LocationPage extends BasePage {
    @FindBy(id = "searchLocation_name")
    WebElement searchLocation_name;
    @FindBy(id = "location_name")
    WebElement locationName;
    @FindBy(id = "location_country")
    WebElement locationCountry;
    @FindBy(id = "location_province")
    WebElement locationProvince;
    @FindBy(id = "location_city")
    WebElement locationCity;
    @FindBy(id = "location_address")
    WebElement locationAddress;
    @FindBy(id = "location_zipCode")
    WebElement locationZipCode;
    @FindBy(id = "btnSave")
    WebElement btnSave;
    @FindBy(id = "btnAdd")
    WebElement btnAdd;
    @FindBy(id = "btnSearch")
    WebElement btnSearch;
    @FindBy(id = "resultTable")
    WebElement resultTable;
    Location location = new Location();

    @Step("Creating new Location")
    public LocationPage addLocation() {
        adminMenu.click();
        organization.click();
        viewLocations.click();
        btnAdd.click();
        locationName.sendKeys(location.getName());
        locationCountry.sendKeys(location.getCountry());
        locationCity.sendKeys(location.getCity());
        locationAddress.sendKeys(location.getAddress());
        locationProvince.sendKeys(location.getState());
        locationZipCode.sendKeys(location.getZipPostalCode());
        btnSave.click();
        return this;
    }

    @Step("Checking created Location in result table")
    public boolean checkLocation() {
        adminMenu.click();
        organization.click();
        viewLocations.click();
        searchLocation_name.click();
        searchLocation_name.click();
        searchLocation_name.sendKeys(location.getName());
        btnSearch.click();
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        return tableRows.stream().map(WebElement::getText).anyMatch
                (o -> o.contains(location.getName()) &&
                        o.contains(location.getCity()) &&
                        o.contains(location.getCountry()));
    }

    public boolean checkFromJSON() {
        JsonConverter converter = new JsonConverter();
        JSONObject locationJson = converter.convertObjectToJson(location);
        Location locationObjFromJson = (Location) converter.convertJsonToObject(locationJson.toString(), Location.class);
        return location.equals(locationObjFromJson);
    }
}
