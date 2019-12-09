package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

import java.util.List;

public class EmployeeListPage extends BasePage {

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> table;

    public boolean filterEmployeeList(String firstName, String middleName, String lastName, String id){
        boolean employee = table.stream()
                .map(WebElement::getText)
                .anyMatch(e->e.contains(firstName)
                        &e.contains(middleName)
                        &e.contains(lastName)
                        &e.contains(id));
        return employee;
    }
}
