package pages;

import data.LocationInfo;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.util.List;

public class LocationsPage extends MainPage{

    @FindBy(id = "btnAdd")
    private WebElement btnAdd;

    @FindBy(id = "location_name")
    private WebElement locatioName;

    @FindBy(id = "location_country")
    private WebElement country;

    @FindBy(xpath = "//option[contains(text(),'Ukraine')]")
    private WebElement selectCountry;

    @FindBy(id = "location_province")
    private WebElement province;

    @FindBy(id = "location_city")
    private WebElement city;

    @FindBy(id = "location_address")
    private WebElement address;

    @FindBy(id = "location_zipCode")
    private WebElement postalCode;

    @FindBy(id = "location_phone")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement btnSave;

    @FindBy(tagName = "tr")
    private List<WebElement> locations;

    public LocationsPage clickAddBtn(){
        Utils.waitAndClick(btnAdd);
        return this;
    }

    public LocationsPage locationNameInput(String nameString){
        Utils.waitAndSendKeys(locatioName, nameString);
        return this;
    }

    public LocationsPage selectCountryInDropDown(){
        Utils.waitAndClick(selectCountry);
        return this;
    }

    public LocationsPage provinceInput(String provinceString){
        Utils.waitAndSendKeys(province, provinceString);
        return this;
    }

    public LocationsPage cityInput(String cityString){
        Utils.waitAndSendKeys(city, cityString);
        return this;
    }

    public LocationsPage addressInput(String addressString){
        Utils.waitAndSendKeys(address, addressString);
        return this;
    }

    public LocationsPage postalCodeInput(String code){
        Utils.waitAndSendKeys(postalCode, code);
        return this;
    }

    public LocationsPage phoneNumberInput(String phone){
        Utils.waitAndSendKeys(phoneNumber, phone);
        return this;
    }

    public LocationsPage clickSaveBtn(){
        Utils.waitAndClick(btnSave);
        return this;
    }

    @Step
    public LocationsPage createLocation(){
        clickAddBtn();
        locationNameInput(LocationInfo.LOCATION_NAME);
        selectCountryInDropDown();
        provinceInput(LocationInfo.PROVINCE);
        cityInput(LocationInfo.CITY);
        addressInput(LocationInfo.ADDRESS);
        postalCodeInput(LocationInfo.POSTAL_CODE);
        phoneNumberInput(LocationInfo.PHONE_NUMBER);
        clickSaveBtn();
        return this;
    }

    @Step
    public boolean isLocationCreated(String name,
                                     String city, String country, String phone){
        return  locations.stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(name)
                        && s.contains(city)
                        && s.contains(country)
                        && s.contains(phone));
    }
}
