package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeeListPage extends BasePage{

    @FindBy(id = "resultTable")
    private WebElement resultTable;

    @FindBy(xpath = "//tbody//td")
    private List<WebElement> webElements;

    public EmployeeListPage collectEmployees() {
        webElements = resultTable.findElements(By.xpath("//tbody//td"));
        return this;
    }

    public boolean isUserExists() {
        return webElements.stream()
                .anyMatch(webElement -> webElement.getText().equals("Hrytsyshyn"));
    }
}
