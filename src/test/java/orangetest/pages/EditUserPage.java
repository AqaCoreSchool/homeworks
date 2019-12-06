package orangetest.pages;

import io.qameta.allure.Step;
import orangetest.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditUserPage extends BasePage {
    private static final String FIRST_NAME = "Mariana";
    private static final String LAST_NAME = "Mykytovych";
    private static final String MIDDLE_NAME = "Romanivna";
    private static final String BIRTHDAY = "1993-09-07";


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
    @FindBy(linkText = LAST_NAME)
    WebElement myUser;

    User user = new User();

    public EditUserPage() {
        super();
    }

    @Step("Editing an Existing User")
    public EditUserPage editUser() {
        pimMenuItem.click();
        viewEmployeeList.click();
        myUser.click();
        saveEditButton.click();
        nationality.click();
        nationality.findElement(By.xpath("//option[contains(text(),'Ukrainian')]")).click();
        marital.click();
        marital.findElement(By.xpath("//option[contains(text(),'Other')]")).click();
        gender.click();
        calendar.click();
        calendar.clear();
        calendar.sendKeys(user.getBirthday(), Keys.ENTER);
        firstName.clear();
        firstName.sendKeys(user.getFirstName());
        lastName.clear();
        lastName.sendKeys(user.getLastName());
        middleName.clear();
        middleName.sendKeys(user.getMiddleName());
        saveEditButton.click();
        return this;
    }

    @Step("Checking if all changes are saved after editing")
    public boolean checkEditedUser() {
        pimMenuItem.click();
        viewEmployeeList.click();
        List<WebElement> tableRows = resultTable.findElements(By.tagName("tr"));
        return tableRows.stream().map(WebElement::getText).anyMatch
                (o -> o.contains(FIRST_NAME) &&
                        o.contains(LAST_NAME) &&
                        o.contains(MIDDLE_NAME));
    }
}
