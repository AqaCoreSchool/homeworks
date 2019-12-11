package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.Location;

public class CreateLocationPage extends BasePage {

    @FindBy(id = "location_name")
    private WebElement nameField;
    @FindBy(id = "location_country")
    private WebElement countrySelect;
    @FindBy(id = "location_city")
    private WebElement cityField;
    @FindBy(id = "location_phone")
    private WebElement number;
    @FindBy(id = "btnSave")
    private WebElement saveButton;

    public CreateLocationPage createNewLocation(Location location){
        WaitUtil.waitAndType(nameField,location.getName());
        Select select = new Select(countrySelect);
        select.selectByVisibleText(location.getCountry());
        cityField.sendKeys(location.getCity());
        number.sendKeys(String.valueOf(location.getNumber()));
        saveButton.click();
        return this;
    }


}
