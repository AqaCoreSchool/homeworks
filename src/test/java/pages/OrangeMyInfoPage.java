package pages;

import data.UserData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Waits;
import utils.WebDriverFactory;

public class OrangeMyInfoPage extends BasePage{
    Waits wait = new Waits(WebDriverFactory.getDriver());

    @FindBy(id = "btnSave")
    private WebElement editBtn;

    @FindBy(id = "personal_txtEmpFirstName")
    private WebElement nameField;

    @FindBy(id = "personal_txtEmpLastName")
    private WebElement surnameField;

    @FindBy(id = "personal_optGender_1")
    private WebElement genderMaleRadioBtn;

    @FindBy(id = "personal_cmbMarital")
    private WebElement maritalStatus;

    @FindBy(id = "personal_cmbNation")
    private WebElement nationality;

    @FindBy(id = "personal_DOB")
    private WebElement dateOfBirthField;

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminModule;

    public OrangeMyInfoPage clickEdit(){
        wait.waitForVisibility(editBtn);
        editBtn.click();
        return this;
    }

    public OrangeMyInfoPage enterName(String name){
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public OrangeMyInfoPage enterSurname(String surname){
        surnameField.clear();
        surnameField.sendKeys(surname);
        return this;
    }

    public OrangeMyInfoPage setGenderMale(){
        genderMaleRadioBtn.click();
        return this;
    }

    public OrangeMyInfoPage setMartialStatus(int option){
        Select maritalStatusSelect = new Select(maritalStatus);
        maritalStatusSelect.selectByIndex(option);
        return this;
    }

    public OrangeMyInfoPage setNationality(String nationalityValue){
        Select nationalitySelect = new Select(nationality);
        nationalitySelect.selectByValue(nationalityValue);
        return this;
    }

    public OrangeMyInfoPage setBirthDate(String date){
        dateOfBirthField.clear();
        dateOfBirthField.sendKeys(date + Keys.ENTER);
        return this;
    }

    public OrangeMyInfoPage clickSave(){
        wait.waitForVisibility(editBtn);
        editBtn.click();
        wait.waitForInvisibilityByXpath("//input[@id='btnSave' and @value='Processing");
        return this;
    }

    public OrangeMyInfoPage editUserData(UserData userData){
        return clickEdit()
                .enterName(userData.getFirstName())
                .enterSurname(userData.getLastName())
                .setBirthDate(userData.getBirthdayDate())
                .setGenderMale()
                .setMartialStatus(userData.getMaritalStatus())
                .setNationality(userData.getNationality())
                .clickSave();
    }
}
