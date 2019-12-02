package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

public class MyInfoPage extends BasePage {

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement editSaveBtn;

    @FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='personal_txtEmpMiddleName']")
    private WebElement middleNameInput;

    @FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = " //input[@id='personal_txtEmployeeId']")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//input[@id='personal_optGender_1']")
    private WebElement genderMale;

    @FindBy(xpath = "//option[contains(text(),'Ukrainian')]")
    private WebElement nationalityUkrainian;

    @FindBy(xpath = "//option[contains(text(),'Other')]")
    private WebElement maritalStatus;

    @FindBy(xpath = "//input[@id='personal_DOB']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    private WebElement pIMBtnHeader;

    @FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
    private WebElement employeeListBtnHeader;

    public MyInfoPage clickEditSave(){
        editSaveBtn.click();
        return this;
    }

    public MyInfoPage inputFirstName(String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public MyInfoPage inputMiddleName(String middleName){
        middleNameInput.clear();
        middleNameInput.sendKeys(middleName);
        return this;
    }

    public MyInfoPage inputLastName(String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public MyInfoPage inputId(String id){
        employeeIdInput.clear();
        employeeIdInput.sendKeys(id);
        return this;
    }

    public MyInfoPage clickGenderMale(){
        genderMale.click();
        return this;
    }

    public MyInfoPage clickNationalityUkrainian(){
        nationalityUkrainian.click();
        return this;
    }

    public MyInfoPage clickMaritalStatus(){
        maritalStatus.click();
        return this;
    }

    public MyInfoPage inputDateOfBirth(String dateOfBirths){
        dateOfBirth.clear();
        dateOfBirth.sendKeys(dateOfBirths);
        return this;
    }

    public MyInfoPage moveToPIM(){
        pIMBtnHeader.click();
        return this;
    }

    public EmployeeListPage moveToEmployeeList(){
        employeeListBtnHeader.click();
        return new EmployeeListPage();
    }
}
