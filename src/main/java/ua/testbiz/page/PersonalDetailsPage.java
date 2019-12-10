package ua.testbiz.page;

import data.UserInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.Application;

public class PersonalDetailsPage {
    @FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='personal_optGender_1']")
    private WebElement genderOption;

    @FindBy(xpath = "//select[@id='personal_cmbMarital']")
    private WebElement maritalStatusSelect;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    private WebElement nationalitySelect;

    @FindBy(xpath = "//input[@id='personal_DOB']")
    private WebElement birthdayInput;

    @FindBy(xpath = "//input[@id='btnSave']")
    public static WebElement saveButton;

    public PersonalDetailsPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public HomePage setPersonalDetail(UserInformation information) {
        saveButton.click();

        firstNameInput.clear();
        firstNameInput.sendKeys(information.getFirstName());

        lastNameInput.clear();
        lastNameInput.sendKeys(information.getLastName());

        genderOption.click();

        Select status = new Select(maritalStatusSelect);
        status.selectByValue(information.getMaritalStatus());

        Select nation = new Select(nationalitySelect);
        nation.selectByValue(information.getNationValue());

        birthdayInput.clear();
        birthdayInput.sendKeys(information.getBirthdayValue());

        saveButton.click();

        return new HomePage();
    }
}
