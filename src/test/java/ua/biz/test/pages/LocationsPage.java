package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.Location;

import java.util.List;

public class LocationsPage extends BasePage {

    @FindBy(id = "btnAdd")
    private WebElement addLocationButton;

    @FindBy(xpath = "//table[@id='resultTable']//tbody//tr[@class='odd' or @class='even']")
    private List<WebElement> locationsList;

    public LocationsPage() {
        super();
    }

    public CreateLocationPage openCreateLocationPage() {
        WaitUtil.waitAndClick(addLocationButton);
        return new CreateLocationPage();
    }

    public boolean isLocationPresent(Location location) {
        return locationsList.stream().map(WebElement::getText).anyMatch(data -> data.contains(location.getName()) &&
                data.contains(location.getCity()) &&
                data.contains(location.getCountry()) &&
                data.contains(String.valueOf(location.getNumber())));
    }
}
