package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;
import testpackage.entity.User;

public class MyInfoPage extends BasePage {

    @FindBy(id = "btnSave")
    private WebElement editSaveBtn;

    @FindBy(id = "personal_txtEmpFirstName")
    private WebElement firstNameInput;

    @FindBy(id = "personal_txtEmpMiddleName")
    private WebElement middleNameInput;

    @FindBy(id = "personal_txtEmpLastName")
    private WebElement lastNameInput;

    @FindBy(id = "personal_txtEmployeeId")
    private WebElement employeeIdInput;

    @FindBy(id = "personal_optGender_1")
    private WebElement genderMale;

    @FindBy(xpath = "//option[contains(text(),'Ukrainian')]")
    private WebElement nationalityUkrainian;

    @FindBy(xpath = "//option[contains(text(),'Other')]")
    private WebElement maritalStatus;

    @FindBy(id = "personal_DOB")
    private WebElement dateOfBirth;

    public MyInfoPage createUser(User user){
        editSaveBtn.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(user.getFirstName());
        middleNameInput.clear();
        middleNameInput.sendKeys(user.getMiddleName());
        lastNameInput.clear();
        lastNameInput.sendKeys(user.getLastName());
        employeeIdInput.clear();
        employeeIdInput.sendKeys(user.getId());
        genderMale.click();
        maritalStatus.click();
        dateOfBirth.clear();
        dateOfBirth.sendKeys(user.getDateOfBirth());
        editSaveBtn.click();
        return this;
    }
}
