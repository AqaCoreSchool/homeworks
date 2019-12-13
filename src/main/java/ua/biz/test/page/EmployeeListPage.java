package ua.biz.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.biz.test.pojo.Employee;
import ua.biz.test.util.LocalDriver;

import java.util.List;

public class EmployeeListPage {
    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> employeeTable;

    public EmployeeListPage() {
        PageFactory.initElements(LocalDriver.getDriver(), this);
    }

    public boolean isEmployeeInList(List<Employee> employees) {
        int counter = 0;
        for (WebElement element : employeeTable) {
            for (Employee employee : employees) {
                if (element.getText().contains(employee.getFirstName())
                        && element.getText().contains(employee.getLastName())) {
                    System.out.printf("Employee %s exists.", element.getText());
                    counter++;
                }
            }
        }
        return (counter == employees.size());
    }

}
