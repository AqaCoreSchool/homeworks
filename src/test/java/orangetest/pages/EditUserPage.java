package orangetest.pages;

import io.qameta.allure.Step;
import orangetest.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditUserPage extends BasePage {

    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement saveEditButton;
    @FindBy(xpath = "//input[@id='personal_optGender_2']")
    WebElement gender;
    @FindBy(xpath = "//input[@id='personal_DOB']")
    WebElement calendar;
    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    WebElement nationality;
    @FindBy(xpath = "//select[@id='personal_cmbMarital']")
    WebElement marital;
    @FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='personal_txtEmpMiddleName']")
    WebElement middleName;
    @FindBy(xpath = "//table[@id='resultTable']//tbody")
    WebElement resultTable;
    @FindBy(linkText = "Mykytovych")
    WebElement myUser;

    public EditUserPage editUser(String fName, String lName, String mName, String birthday) {
        pimMenuItem.click();
        viewEmployeeList.click();
        myUser.click();
        saveEditButton.click();
        calendar.click();
        calendar.clear();
        calendar.sendKeys(birthday, Keys.ENTER);
        nationality.click();
        nationality.findElement(By.xpath("//option[contains(text(),'Ukrainian')]")).click();
        marital.click();
        marital.findElement(By.xpath("//option[contains(text(),'Other')]")).click();
        gender.click();
        calendar.click();
        calendar.clear();
        calendar.sendKeys(user.getBirthday(), Keys.ENTER);
        firstName.clear();
        firstName.sendKeys(fName);
        lastName.clear();
        lastName.sendKeys(lName);
        middleName.clear();
        middleName.sendKeys(mName);
        saveEditButton.click();
        return this;
    }

    @Step("Checking if all changes are saved after editing")
    public boolean isUserEdited(String fName, String lName, String mName) {
        pimMenuItem.click();
        viewEmployeeList.click();
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        return tableRows.stream().map(WebElement::getText).anyMatch
                (o -> o.contains(fName) &&
                        o.contains(lName) &&
                        o.contains(mName));
    }
}
