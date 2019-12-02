package com.company.verifytests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeeRecordsPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='menu_attendance_viewAttendanceRecord']")
    private WebElement employeeRecords;

    @FindBy(xpath = "//input[@id='attendance_date']")
    private WebElement chooseDate;

    @FindBy (xpath = "//input[@id='btView']")
    private WebElement viewButton;

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> table;


    public EmployeeRecordsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public EmployeeRecordsPage clickEmployeeRecords(){
        employeeRecords.click();
        return new EmployeeRecordsPage(driver);
    }

    public EmployeeRecordsPage chooseDateOfRecords(String dateOfRecords){
        chooseDate.click();
        chooseDate.clear();
        chooseDate.sendKeys(dateOfRecords, Keys.ENTER);
        return new EmployeeRecordsPage(driver);
    }

    public EmployeeRecordsPage clickViewBtn(){
        viewButton.click();
        return new EmployeeRecordsPage(driver);
    }

    public boolean verifyEmployeeRecords(String fullName, String date){
        boolean employee = table.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(fullName)
                        &e.contains(date));
        return employee;
    }

}
