package selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyInfoPage extends BasePage {

    @FindBy(id = "btnSave")
    private WebElement btnSave;

    @FindBy(xpath = "//form[@id='frmEmpPersonalDetails']/fieldset//*")
    private List<WebElement> inputElements;

    @FindBy(id = "frmEmpPersonalDetails")
    private WebElement employeeInfoForm;

    @FindBy(id = "personal_txtEmpFirstName")
    private WebElement employeeFirstName;

    @FindBy(id = "personal_txtEmpLastName")
    private WebElement employeeLastName;

    @FindBy(id = "personal_txtOtherID")
    private WebElement employeeOtherId;

    @FindBy(id = "personal_txtEmployeeId")
    private WebElement employeeId;

    @FindBy(id = "personal_txtLicenNo")
    private WebElement employeeLicenceNo;

    @FindBy(id = "personal_txtLicExpDate")
    private WebElement employeeLicenceExDate;

    @FindBy(id = "personal_DOB")
    private WebElement employeeBirthDate;

    @FindBy(id = "personal_optGender_1")
    private WebElement employeeGender;

    @FindBy(id = "personal_cmbNation")
    private WebElement employeeNation;

    @FindBy(id = "personal_cmbMarital")
    private WebElement employeeMarital;

    public MyInfoPage clearAllFields() {
        inputElements.stream()
                .filter(webElement -> webElement.getTagName().equals("input"))
                .filter(webElement -> webElement.getAttribute("type").equals("text"))
                .forEach(WebElement::clear);
        inputElements.stream()
                .filter(webElement -> webElement.getTagName().equals("select"))
                .map(Select::new)
                .forEach(select -> select.selectByVisibleText("-- Select --"));
        return this;
    }

    public MyInfoPage fillEmployeeName(String name) {
        employeeFirstName.sendKeys(name);
        return this;
    }

    public MyInfoPage fillEmployeeLastName(String lastname) {
        employeeLastName.sendKeys(lastname);
        return this;
    }

    public MyInfoPage fillEmployeeOtherId(String id) {
        employeeOtherId.sendKeys(id);
        return this;
    }

    public MyInfoPage fillEmployeeId(String id) {
        employeeId.sendKeys(id);
        return this;
    }

    public MyInfoPage fillEmployeeLicenceNo(String licenceNo) {
        employeeLicenceNo.sendKeys(licenceNo);
        return this;
    }

    public MyInfoPage fillEmployeeLicenceExpDate(String date) {
        employeeLicenceExDate.sendKeys(date);
        return this;
    }

    public MyInfoPage fillEmployeeBirthDate(String date) {
        employeeBirthDate.sendKeys(date);
        return this;
    }

    public MyInfoPage fillEmployeeNation(String nation) {
        employeeNation.sendKeys(nation, Keys.ENTER);
        return this;
    }

    public MyInfoPage selectEmployeeGender() {
        employeeGender.click();
        return this;
    }

    public MyInfoPage fillEmployeeMarital(String maritalStatus) {
        employeeMarital.sendKeys(maritalStatus, Keys.ENTER);
        return this;
    }

    public MyInfoPage btnClick() {
        getWait().until(ExpectedConditions.elementToBeClickable(btnSave));
        btnSave.click();
        return this;
    }

    public WebElement getEmployeeFirstName() {
        return employeeFirstName;
    }

}
