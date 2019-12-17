package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.Employee;
import ua.biz.test.utils.WaitUtil;

public class MyInfoPage extends BasePage {

    @FindBy(xpath ="//input[@id='personal_txtEmpFirstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
    private WebElement id;
    @FindBy(xpath ="//input[@id='btnSave']" )
    private WebElement editButton;

    public MyInfoPage() {
        super();
    }

    public void editEmployeeData(Employee employee) {
        editButton.click();
        WaitUtil.waitAndClear(firstName);
        firstName.sendKeys(employee.getFirstName());
        lastName.clear();
        lastName.sendKeys(employee.getLastName());
        editButton.click();
    }

}
