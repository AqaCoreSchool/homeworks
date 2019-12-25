package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class EditUserPage {

    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    private WebElement pimMenuItem;
    @FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
    private WebElement viewEmployeeList;
    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveEditButton;
    @FindBy(xpath = "//input[@id='personal_optGender_2']")
    private WebElement gender;
    @FindBy(xpath = "//input[@id='personal_DOB']")
    private WebElement calendar;
    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    private WebElement nationality;
    @FindBy(xpath = "//select[@id='personal_cmbMarital']")
    private WebElement marital;
    @FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='personal_txtEmpMiddleName']")
    private WebElement middleName;
    @FindBy(xpath = "//table[@id='resultTable']//tbody")
    private WebElement resultTable;
    @FindBy(linkText = "Mykytovych")
    private WebElement myUser;

    public EditUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void editUser(String fName, String lName, String mName, String birthday) {
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
        firstName.clear();
        firstName.sendKeys(fName);
        lastName.clear();
        lastName.sendKeys(lName);
        middleName.clear();
        middleName.sendKeys(mName);
        saveEditButton.click();
    }

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
