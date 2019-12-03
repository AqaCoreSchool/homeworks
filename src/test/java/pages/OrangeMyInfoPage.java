package pages;

import data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeMyInfoPage {
    private final WebDriver driver;
    private WebDriverWait editWait;
    private WebDriverWait saveWait;

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

    public OrangeMyInfoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        editWait = new WebDriverWait(driver, 10);
        saveWait = new WebDriverWait(driver, 10);
    }

    public OrangeMyInfoPage clickEdit(){
        editWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
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
        editWait.until(ExpectedConditions.visibilityOf(editBtn));
        editBtn.click();
        saveWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("message.success.fadable")));
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

    public OrangeAdminPage toAdminPage(){
        adminModule.click();
        return new OrangeAdminPage(driver);
    }
}
