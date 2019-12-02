package ua.biz.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

    @FindBy(xpath ="//input[@id='personal_txtEmpFirstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
    private WebElement id;
    @FindBy(xpath ="//input[@id='btnSave']" )
    private WebElement editButton;


    public MyInfoPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void editEmployeeData() {
        editButton.click();
        firstName.clear();
        firstName.sendKeys("Ivan");
        lastName.clear();
        lastName.sendKeys("Mosiychuk");
        editButton.click();
    }

}
