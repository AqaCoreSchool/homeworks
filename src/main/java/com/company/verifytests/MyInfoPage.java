package com.company.verifytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {
    public static WebDriver driver;
    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement editSaveBtn;

    @FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//input[@id='personal_txtOtherID']")
    private WebElement otherId;

    @FindBy(xpath = "//input[@id='personal_txtLicenNo']")
    private WebElement driverNumber;

    @FindBy(xpath = "//input[@id='personal_optGender_2']")
    private WebElement genderStatus;

    @FindBy(xpath = "//option[contains(text(),'Ukrainian')]")
    private WebElement nationality;

    @FindBy(xpath = "//option[contains(text(),'Other')]")
    private WebElement maritalStatus;

    @FindBy(xpath = "//input[@id='personal_DOB']")
    private WebElement birthDate;


    public MyInfoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public MyInfoPage clickEditSave(){
        editSaveBtn.click();
        return new MyInfoPage(driver);
    }

    public MyInfoPage inputFirstName(String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return new MyInfoPage(driver);
    }

    public MyInfoPage inputLastName(String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return new MyInfoPage(driver);
    }


    public MyInfoPage inputEmployeeId(String id){
        employeeIdInput.clear();
        employeeIdInput.sendKeys(id);
        return new MyInfoPage(driver);
    }

    public MyInfoPage inputOtherId(String id){
        otherId.clear();
        otherId.sendKeys(id);
        return new MyInfoPage(driver);
    }
    public MyInfoPage inputDriverNo(String driverNo){
        driverNumber.clear();
        driverNumber.sendKeys(driverNo);
        return new MyInfoPage(driver);
    }

    public MyInfoPage chooseGender(){
        genderStatus.click();
        return new MyInfoPage(driver);
    }

    public MyInfoPage chooseNationality(){
        nationality.click();
        return this;
    }

    public MyInfoPage chooseMaritalStatus(){
        maritalStatus.click();
        return new MyInfoPage(driver);
    }

    public MyInfoPage inputDateOfBirth(String dateOfBirths){
        birthDate.clear();
        birthDate.sendKeys(dateOfBirths);
        return new MyInfoPage(driver);
    }

}
