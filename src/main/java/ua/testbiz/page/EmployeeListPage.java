package ua.testbiz.page;

import data.UserInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Application;

import java.util.List;

public class EmployeeListPage {
    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> employeeTable;

    public EmployeeListPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public boolean checkEmployee(UserInformation information) {
        for (WebElement element : employeeTable) {
            List<WebElement> employeeData = element.findElements(By.tagName("a"));
            if (employeeData.get(1).getText().equals(information.getFirstName())) {
                System.out.printf("Employee %s %s exists.", employeeData.get(1).getText(), employeeData.get(2).getText());
                return true;
            }
        }
        return false;
    }
}
