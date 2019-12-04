package pages;

import data.UserInfo;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Utils;


public class MyInfoPage extends MainPage{

    @FindBy(id = "btnSave")
    private WebElement editOrSaveBtn;

    @FindBy(id = "personal_txtEmpFirstName")
    private WebElement firstNameInput;

    @FindBy(id = "personal_txtEmpLastName")
    private WebElement lastNameInput;

    @FindBy(id = "personal_txtEmployeeId")
    private WebElement idInput;

    @FindBy(id = "personal_optGender_1")
    private WebElement genderRadioBtn;

    @FindBy(xpath = "//option[contains(text(),'Ukrainian')]")
    private WebElement nationalityUkrainian;

    @FindBy(xpath = "//option[contains(text(),'Married')]")
    private WebElement maritalStatusMarried;

    @FindBy(id = "personal_DOB")
    private WebElement dateOfBirthInput;

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement pimBtn;

    @FindBy(id = "menu_pim_viewEmployeeList")
    private WebElement employeeListBtn;


    public MyInfoPage clickEditOrSave(){
        Utils.waitAndClick(editOrSaveBtn);
        return this;
    }

    public MyInfoPage clickfirstNameInput(String firstName){
        Utils.waitAndSendKeys(firstNameInput, firstName);
        return this;
    }

    public MyInfoPage clicklastNameInput(String lastName){
        Utils.waitAndSendKeys(lastNameInput, lastName);
        return this;
    }

    public MyInfoPage clickIdInput(String id){
        Utils.waitAndSendKeys(idInput, id);
        return this;
    }

    public MyInfoPage clickGenderMale(){
        Utils.waitAndClick(genderRadioBtn);
        return this;
    }

    public MyInfoPage clickNationalityUkrainian(){
        Utils.waitAndClick(nationalityUkrainian);
        return this;
    }

    public MyInfoPage clickMaritalStatus(){
        Utils.waitAndClick(maritalStatusMarried);
        return this;
    }

    public MyInfoPage clickinputDateOfBirth(String dateOfBirths){
        Utils.waitAndSendKeys(dateOfBirthInput, dateOfBirths);
        return this;
    }

    public MyInfoPage clickPimBtn(){
        Utils.waitAndClick(pimBtn);
        return this;
    }

    @Step
    public EmployeeListPage clickEmployeeListBtn(){
        Utils.waitAndClick(employeeListBtn);
        return new EmployeeListPage();
    }

    @Step
    public MyInfoPage editInfo(){
        clickEditOrSave();
        clickfirstNameInput(UserInfo.FIRST_NAME);
        clicklastNameInput(UserInfo.LAST_NAME);
        clickIdInput(UserInfo.ID);
        clickGenderMale();
        clickMaritalStatus();
        clickNationalityUkrainian();
        clickinputDateOfBirth(UserInfo.BIRTH_DATE);
        clickEditOrSave();
        clickPimBtn();
        clickEmployeeListBtn();
        return this;
    }
}
