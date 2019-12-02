package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.driver.Driver;

import java.util.List;

public class EmployeeListPage {
    private WebDriverWait wait;

    @FindBy(id = "resultTable")
    private WebElement resultTable;

    @FindBy(xpath = "//tbody//td")
    private List<WebElement> webElements;

    public EmployeeListPage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
    }

    public EmployeeListPage collectEmployees() {
        webElements = resultTable.findElements(By.xpath("//tbody//td"));
        return this;
    }

    public boolean isUserExists() {
        return webElements.stream()
                .anyMatch(webElement -> webElement.getText().equals("Hrytsyshyn"));
    }
}
