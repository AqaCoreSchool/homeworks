package ua.biz.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.SQLDataProv.EmployeeSQLDataProvider;
import ua.biz.test.SQLDataProv.VacancySQLDataProvider;
import ua.biz.test.base.BasePage;
import ua.biz.test.entity.Employee;
import ua.biz.test.entity.Vacancy;

import java.util.List;

public class EmployeeListPage extends BasePage {

    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> emloyeeDataList;

    public boolean isEmployeePresent(Employee employee) {
        return emloyeeDataList.stream().
                map(WebElement::getText).
                anyMatch(element -> element.contains(employee.getFirstName()) &&
                        element.contains(employee.getLastName()) &&
                        element.contains(String.valueOf(employee.getId())));
    }

    public boolean isEmployeePresentByVacancy(Vacancy vacancy) {
        Employee employee = EmployeeSQLDataProvider.getEmployeeByVacancy(vacancy);
        return emloyeeDataList.stream().map(WebElement::getText).
                anyMatch(element -> element.contains(employee.getFullName()));
    }
}
