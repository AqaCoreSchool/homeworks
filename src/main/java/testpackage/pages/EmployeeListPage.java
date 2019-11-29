package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testpackage.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeListPage {

    @FindBy (xpath = "//table[@id='resultTable']//tbody")
    private List<WebElement> table;

    public EmployeeListPage() {
        PageFactory.initElements(BasePage.getInstance().getDriver(), this);
    }

    public String filterEmployeeList(String firstName, String middleName, String lastName, String id){
        String employee = table.stream()
                .map(WebElement::getText)
                .filter(e->e.contains(firstName)
                        &e.contains(middleName)
                        &e.contains(lastName)
                        &e.contains(id))
                .collect(Collectors.joining(" "));
        return employee;
    }
}
