package com.company.vTests.pages;

import com.company.vTests.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LocationPage extends BasePage {
    @FindBy(id = "btnAdd")
    private WebElement addLocationBtn;

    @FindBy(id = "btnSave")
    private WebElement saveLocationBtn;

    @FindBy(id = "location_name")
    private WebElement inputLocationName;

    @FindBy(xpath = "//option[contains(text(),'Ukraine')]")
    private WebElement selectCountry;

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> tableWithLocations;


    public LocationPage clickAddLocation(){
        addLocationBtn.click();
        return this;
    }

    public LocationPage clickSaveLocation(){
        saveLocationBtn.click();
        return this;
    }

    public LocationPage inputLocationData(String name){
        inputLocationName.click();
        inputLocationName.sendKeys(name);
        selectCountry.click();
        return this;
    }

    public boolean verifyLocation(String name, String country){
        boolean locations = tableWithLocations.stream()
                .map(WebElement::getText)
                .anyMatch(loc->loc.contains(name)
                        &loc.contains(country));
        return locations;
    }

}
