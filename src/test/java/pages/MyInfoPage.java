package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyInfoPage extends BasePage{

    private WebDriver driver;

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
        editOrSaveBtn.click();
        return this;
    }

    public MyInfoPage clickfirstNameInput(String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public MyInfoPage clicklastNameInput(String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public MyInfoPage clickIdInput(String id){
        idInput.clear();
        idInput.sendKeys(id);
        return this;
    }

    public MyInfoPage clickGenderMale(){
        genderRadioBtn.click();
        return this;
    }

    public MyInfoPage clickNationalityUkrainian(){
        nationalityUkrainian.click();
        return this;
    }

    public MyInfoPage clickMaritalStatus(){
        maritalStatusMarried.click();
        return this;
    }

    public MyInfoPage clickinputDateOfBirth(String dateOfBirths){
        dateOfBirthInput.clear();
        dateOfBirthInput.sendKeys(dateOfBirths);
        return this;
    }

    public MyInfoPage clickPimBtn(){
        pimBtn.click();
        return this;
    }

    public EmployeeListPage clickEmployeeListBtn(){
        employeeListBtn.click();
        return new EmployeeListPage();
    }
}
