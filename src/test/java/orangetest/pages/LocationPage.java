package orangetest.pages;

import io.qameta.allure.Step;
import orangetest.data.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LocationPage extends BasePage {

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

    @FindBy(id = "resultTable")
    WebElement resultTable;

    @Step("Creating new Location")
    public LocationPage addLocation(String name, String country, String city,
                                    String address, String state, String zipCode) {
        adminMenu.click();
        organization.click();
        viewLocations.click();
        btnAdd.click();
        locationName.sendKeys(name);
        locationCountry.sendKeys(country);
        locationCity.sendKeys(city);
        locationAddress.sendKeys(address);
        locationProvince.sendKeys(state);
        locationZipCode.sendKeys(zipCode);
        btnSave.click();
        return this;
    }

    @Step("Checking created Location in result table")
    public boolean isLocationAdded(String name, String country, String city) {
        adminMenu.click();
        organization.click();
        viewLocations.click();
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        return tableRows.stream().map(WebElement::getText).anyMatch
                (o -> o.contains(name) &&
                        o.contains(city) &&
                        o.contains(country));
    }
}
