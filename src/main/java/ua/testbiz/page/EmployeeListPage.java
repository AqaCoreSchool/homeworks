package ua.testbiz.page;

import data.UserInformation;
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

    public boolean isEmployeeInList(UserInformation information) {
        for (WebElement element : employeeTable) {
            if (element.getText().contains(information.getFirstName())
                    && element.getText().contains(information.getLastName())) {
                System.out.printf("Employee %s exists.", element.getText());
                return true;
            }
        }
        return false;
    }

}
