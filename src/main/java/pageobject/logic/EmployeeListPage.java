package pageobject.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeListPage {

    @FindBy(tagName = "tr")
    private List<WebElement> employees;

    public EmployeeListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String findEmployeeInfo(String firstName, String lastName, String id){
        return employees.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(firstName))
                .filter(s -> s.contains(lastName))
                .filter(s -> s.contains(id))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
