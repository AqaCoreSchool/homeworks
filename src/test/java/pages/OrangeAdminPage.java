package pages;

import data.LocationData;
import data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrangeAdminPage extends BasePage{
    private WebElement user;
    private List<WebElement> userRecord;
    private String country;

    @FindBy(id = "menu_admin_UserManagement")
    private WebElement userManagementMenu;

    @FindBy(id = "menu_admin_viewSystemUsers")
    private WebElement systemUsers;

    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> resultList;

    @FindBy(id = "menu_admin_Organization")
    private WebElement organizationMenu;

    @FindBy(id = "menu_admin_viewLocations")
    private WebElement locations;

    @FindBy(id = "btnAdd")
    private WebElement addButton;

    @FindBy(id = "btnSave")
    private WebElement saveBtn;

    @FindBy(id = "location_name")
    private WebElement locationName;

    @FindBy(id = "location_country")
    private WebElement locationCountryCode;

    @FindBy(id = "location_province")
    private WebElement locationProvince;

    @FindBy(id = "location_city")
    private WebElement locationCity;

    @FindBy(id = "location_address")
    private WebElement locationAddress;

    @FindBy(id = "location_zipCode")
    private WebElement locationZipCode;

    @FindBy(id = "location_phone")
    private WebElement locationPhone;

    @FindBy(id = "location_fax")
    private WebElement locationFax;

    @FindBy(id = "location_notes")
    private WebElement locationNotes;

    public WebElement getUser() {
        return user;
    }

    public List<WebElement> getUserRecord() {
        return userRecord;
    }

    public OrangeAdminPage toUserManagement(){
        userManagementMenu.click();
        return this;
    }

    public OrangeAdminPage toSystemUsers(){
        systemUsers.click();
        return this;
    }

    public boolean findUser(String username, UserData userData){
        return resultList.stream()
                .anyMatch(o -> o.getText().contains(username) &&
                        o.getText().contains(String.format("%s %s", userData.getFirstName(), userData.getLastName())));
    }

    public OrangeAdminPage toOrganization(){
        organizationMenu.click();
        return this;
    }

    public OrangeAdminPage toLocations(){
        locations.click();
        return this;
    }

    public OrangeAdminPage clickAddBtn(){
        addButton.click();
        return this;
    }

    public OrangeAdminPage setLocationName(String name){
        locationName.sendKeys(name);
        return this;
    }

    public OrangeAdminPage selectCountry(String code){
        Select countries = new Select(locationCountryCode);
        countries.selectByValue(code);
        country = countries.getFirstSelectedOption().getText();
        return this;
    }

    public OrangeAdminPage setProvince(String province){
        locationProvince.sendKeys(province);
        return this;
    }

    public OrangeAdminPage setCity(String city){
        locationCity.sendKeys(city);
        return this;
    }

    public OrangeAdminPage setAddress(String address){
        locationAddress.sendKeys(address);
        return this;
    }

    public OrangeAdminPage setZipCode(String zip){
        locationZipCode.sendKeys(zip);
        return this;
    }

    public OrangeAdminPage setPhone(String phone){
        locationPhone.sendKeys(phone);
        return this;
    }

    public OrangeAdminPage setFax(String Fax){
        locationFax.sendKeys(Fax);
        return this;
    }

    public OrangeAdminPage addNotes(String notes){
        locationNotes.sendKeys(notes);
        return this;
    }

    public OrangeAdminPage clickSaveBtn(){
        saveBtn.click();
        return this;
    }

    public OrangeAdminPage createLocation(LocationData location){
        return clickAddBtn()
                .setLocationName(location.getName())
                .selectCountry(location.getCountryCode())
                .setProvince(location.getState())
                .setCity(location.getCity())
                .setAddress(location.getAddress())
                .setZipCode(location.getZip())
                .setPhone(location.getPhone())
                .setFax(location.getFax())
                .addNotes(location.getNotes())
                .clickSaveBtn();
    }

    public boolean findLocation(LocationData location){
        return resultList.stream()
                .anyMatch(o -> o.getText().contains(location.getName()) &&
                        o.getText().contains(location.getCity()) &&
                        o.getText().contains(country) &&
                        o.getText().contains(location.getPhone()));

    }

}
